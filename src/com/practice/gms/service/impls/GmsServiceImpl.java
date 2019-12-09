package com.practice.gms.service.impls;

import java.util.List;

import com.practice.gms.entities.Database;
import com.practice.gms.entities.Guest;
import com.practice.gms.service.interfaces.GmsService;

public class GmsServiceImpl implements GmsService {

	private Database database = new Database();

	@Override
	public Guest enterGuest(Guest guest) {
		List<Guest> modifiedGuestList = database.getGuestList();
		modifiedGuestList.add(guest);
		database.setGuestList(modifiedGuestList);
		return guest;
	}

	@Override
	public String deleteGuestByID(int guestID) {
		String message = "";
		int databaseSize = database.getGuestList().size();
		String deletedGuestName = null;
		for (int i = 0; i < databaseSize; i++) {
			if (database.getGuestList().get(i).getGuestID() == guestID) {
				deletedGuestName = database.getGuestList().get(i).getGuestName(); 
				/*line 29 was below line 33, which was illogical 
				 * because you can't retrieve or get already deleted guest's name. 
				 */
				database.getGuestList().remove(i);		
			}
		}
		if (deletedGuestName != null) { //deletedGuestName was initialized to null, so only one condition in if.
			message = "A guest named " + deletedGuestName + " was successfully deleted!!";
		} else {
			message = "No guest was found for that ID: "+guestID;
		}
		return message;
	}

	@Override
	public Guest searchGuestDetailsByName(String guestName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Guest> getAllGuests() {

		return database.getGuestList();
	}

	@Override
	public List<Guest> sortGuestsByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guest updateRoomNumberByPhoneNumber(long guestPhoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
