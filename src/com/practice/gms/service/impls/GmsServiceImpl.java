package com.practice.gms.service.impls;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
				/*
				 * line 29 was below line 33, which was illogical because you can't retrieve or
				 * get already deleted guest's name.
				 */
				database.getGuestList().remove(i);
			}
		}
		if (deletedGuestName != null) { // deletedGuestName was initialized to null, so only one condition in if.
			message = "A guest named " + deletedGuestName + " was successfully deleted!!";
		} else {
			message = "No guest was found for that ID: " + guestID;
		}
		return message;
	}

	@Override
	public Guest searchGuestDetailsByName(String guestName) {
		Guest guestFound = null;
		if (database.getGuestList().size() != 0) {
			for (int i = 0; i < database.getGuestList().size(); i++) {
				if (database.getGuestList().get(i).getGuestName().equalsIgnoreCase(guestName)) {
					guestFound = database.getGuestList().get(i);
					// System.out.println(guestFound);
				}
			}
		}

		return guestFound;
	}

	@Override
	public List<Guest> getAllGuests() {

		return database.getGuestList();
	}

	@Override
	public Map<Integer, Guest> sortGuestsByName() {
		List<Guest> guestList = database.getGuestList();

		Comparator comparator = new Comparator<Guest>() {
			@Override
			public int compare(Guest o1, Guest o2) {
				return o1.getGuestName().compareToIgnoreCase(o2.getGuestName());
			}
		};

		Collections.sort(guestList, comparator);

		Map<Integer, Guest> guestHashMap = new HashMap<Integer, Guest>();
		for (int i = 0; i < guestList.size(); i++) {
			guestHashMap.put(i, guestList.get(i));
		}
		return guestHashMap;
	}

	@Override
	public Guest updateRoomNumberByPhoneNumber(long guestPhoneNumber, short roomNumber) {

		List<Guest> guestList = database.getGuestList();
		Guest guest = new Guest();

		for (int i = 0; i < guestList.size(); i++) {
			if (guestPhoneNumber == guestList.get(i).getGuestPhoneNumber()) {
				guestList.get(i).setGuestRoomNumber(roomNumber);
				guest = guestList.get(i);

			}

		}
		return guest;
	}

	@Override
	public boolean validateRoomNumber(List<Guest> allGuests, short roomNumber) {
		boolean flag = false;
		if (allGuests.size() == 0)
			flag = true;
		if (roomNumber > 0 && roomNumber < 100) {
			for (int i = 0; i < allGuests.size(); i++) {
				if (allGuests.get(i).getGuestRoomNumber() != roomNumber) {
					flag = true;
				}
			}
		}
		return flag;
	}

	@Override
	public boolean validatePhoneNumber(long phoneNumber) {
		List<Guest> guestList = database.getGuestList();
		for (int i = 0; i < guestList.size(); i++) {
				if(guestList.get(i).getGuestPhoneNumber() == phoneNumber) {
					return true;
				}
		}
		return false;
	}

}
