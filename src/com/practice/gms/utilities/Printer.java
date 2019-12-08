package com.practice.gms.utilities;

import java.util.List;

import com.practice.gms.entities.Guest;

public class Printer {

	
	public void printList(List<Guest> guestList) {
		guestList.forEach(guest -> System.out.println("======================================================\n"+guest));
	}
}
