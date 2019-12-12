package com.practice.gms.entities;

import java.util.ArrayList;
import java.util.List;

public class Database {
	
	
	private List<Guest> guestList = new ArrayList<Guest>();

	public List<Guest> getGuestList() {
		return guestList;
	}

	public void setGuestList(List<Guest> guestList) {
		this.guestList = guestList;
	} 
}
