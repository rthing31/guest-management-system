package com.practice.gms.client;

import java.util.List;
import java.util.Map;

import com.practice.gms.entities.Guest;
import com.practice.gms.service.impls.GmsServiceImpl;
import com.practice.gms.utilities.Printer;
import com.practice.gms.utilities.ScannerUtil;

/*
 * 
 * Menu driven application to enter, search, delete, update, sort 
 * hotel clients
 * 
 * 
 */
public class GmsClient {
	//just to practice git push action
	//Aashman changed a line
	private static Printer printer = new Printer();
	private static ScannerUtil scanner = new ScannerUtil();
	private static GmsServiceImpl gmsServiceImpl = new GmsServiceImpl();

	public static void main(String[] args) {
		
		//System.out.println(gmsServiceImpl.getAllGuests());

		System.out.println("Welcome to Guest Management System");
		boolean flag = true;
		do {
			String message = "Please enter \n" + "1. to add a guest \n" + "2. to delete a guest \n"
					+ "3. to search a guest \n" + "4. to print all guest details \n"
					+ "5. to sort guests details by name \n" + "6. to update room number for a guest \n"
					+ "7. to exit from the guest management system ]\n" + "Thank you!!";
			int choice = scanner.getInt(message);
			switch (choice) {
			case 1:
				Guest guest = new Guest();
				guest.setGuestID();
				String name = scanner.getString("Please enter first and last name.");
				guest.setGuestName(name);
				String address = scanner.getString("Please enter address.");
				guest.setGuestAddress(address);
				long phone = scanner.getLong("Please enter a valid number.");
				guest.setGuestPhoneNumber(phone);
				short roomNumber;
				boolean flag2 = true;
				do {
					roomNumber = scanner.getShort("Please enter a room between 1 to 100.");
					boolean result = gmsServiceImpl.validateRoomNumber(gmsServiceImpl.getAllGuests(), roomNumber);
					System.out.println(result);
					if(result == true) {
						guest.setGuestRoomNumber(roomNumber);
						flag2 = false;
					}
					else System.out.println("The room is already booked.");
				} while (flag2);

				Guest enteredGuest = gmsServiceImpl.enterGuest(guest);
				System.out.println(enteredGuest);
				break;
			case 2:
				int guestID = scanner.getInt("Please enter the guest ID you want to delete.");
				String msg = gmsServiceImpl.deleteGuestByID(guestID);
				System.out.println(msg);
				break;
			case 3:
				String guestName = scanner.getString("Please enter guest name to search details.");
				Guest guestFound = gmsServiceImpl.searchGuestDetailsByName(guestName);
				if(guestFound!=null)
				System.out.println("Guest found: \n"+guestFound);
				else System.out.println("Guest not found");
				break;
			case 4:
				List<Guest> guestList2 = gmsServiceImpl.getAllGuests();
				printer.printList(guestList2);
				
				break;
			case 5:
				Map<Integer, Guest> sortedGuests = gmsServiceImpl.sortGuestsByName();
				sortedGuests.forEach((k, v) -> System.out.println(v) );
				break;
			case 6:
				break;
			case 7:
				flag = false;
			default:
				System.out.println("Please enter a number from 1 to 7.");
			}
		} while (flag);

	}

}
