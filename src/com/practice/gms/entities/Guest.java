package com.practice.gms.entities;

public class Guest {
	private static int counter = 1000;
	private int guestID;
	private String guestName;
	private String guestAddress;
	private long guestPhoneNumber;
	private short guestRoomNumber;
	public Guest() {

	}
	public Guest(String guestName, String guestAddress, long guestPhoneNumber, short guestRoomNumber) {
		super();
		this.guestName = guestName;
		this.guestAddress = guestAddress;
		this.guestPhoneNumber = guestPhoneNumber;
		this.guestRoomNumber = guestRoomNumber;
	}
	public int getGuestID() {
		return guestID;
	}
	public void setGuestID() {
		++counter;
		this.guestID = counter;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGuestAddress() {
		return guestAddress;
	}
	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}
	public long getGuestPhoneNumber() {
		return guestPhoneNumber;
	}
	public void setGuestPhoneNumber(long guestPhoneNumber) {
		this.guestPhoneNumber = guestPhoneNumber;
	}
	public short getGuestRoomNumber() {
		return guestRoomNumber;
	}
	public void setGuestRoomNumber(short guestRoomNumber) {
		this.guestRoomNumber = guestRoomNumber;
	}
	@Override
	public String toString() {
		return "Guest [guestID=" + guestID + ", guestName=" + guestName + ", guestAddress=" + guestAddress
				+ ", guestPhoneNumber=" + guestPhoneNumber + ", guestRoomNumber=" + guestRoomNumber + "]";
	}
	
	
	
	

}
