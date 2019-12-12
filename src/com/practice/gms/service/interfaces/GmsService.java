package com.practice.gms.service.interfaces;

import java.util.List;
import java.util.Map;

import com.practice.gms.entities.Guest;

public interface GmsService {
	Guest enterGuest(Guest guest) ;
	String deleteGuestByID(int guestID);
	Guest searchGuestDetailsByName(String guestName);
	List<Guest> getAllGuests();
	//map is a collection interface, that stores data in key value pair system
	Map<Integer,Guest> sortGuestsByName();
	Guest updateRoomNumberByPhoneNumber(long guestPhoneNumber,short roomNumber);
	boolean validateRoomNumber(List<Guest> allGuests, short roomNumber);
	boolean validatePhoneNumber(long phoneNumber);
	
    //Comment
}
