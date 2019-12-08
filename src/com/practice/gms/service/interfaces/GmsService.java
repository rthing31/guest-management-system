package com.practice.gms.service.interfaces;

import java.util.List;

import com.practice.gms.entities.Guest;

public interface GmsService {
	Guest enterGuest(Guest guest) ;
	String deleteGuestByID(int guestID);
	Guest searchGuestDetailsByName(String guestName);
	List<Guest> getAllGuests();
	List<Guest> sortGuestsByName();
	Guest updateRoomNumberByPhoneNumber(long guestPhoneNumber);

}
