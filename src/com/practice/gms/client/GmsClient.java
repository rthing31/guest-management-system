package com.practice.gms.client;

import java.util.List;

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
				List<Guest> guestList = gmsServiceImpl.getAllGuests();
				boolean flag2 = true;
				do {
					roomNumber = scanner.getShort("Please enter a room number.");
					if (guestList == null || guestList.size() == 0) {
						flag2 = false;
						guest.setGuestRoomNumber(roomNumber);
					} else {
						for (int i = 0; i < guestList.size(); i++) {
							if (guestList.get(i).getGuestPhoneNumber() == roomNumber) {
								System.out.println(" Sorry: The room is already booked.");
							} else {
								flag2 = false;
								guest.setGuestRoomNumber(roomNumber);
							}
						}
					}
				} while (flag2);

				Guest enteredGuest = gmsServiceImpl.enterGuest(guest);
				System.out.println(enteredGuest);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				List<Guest> guestList2 = gmsServiceImpl.getAllGuests();
				printer.printList(guestList2);
				
				break;
			case 5:
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
