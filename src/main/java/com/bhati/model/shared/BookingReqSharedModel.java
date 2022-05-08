package com.bhati.model.shared;

import javax.persistence.Column;

public class BookingReqSharedModel {

	private int userid;
	private int seatsbooked;
	private int showid;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getSeatsbooked() {
		return seatsbooked;
	}
	public void setSeatsbooked(int seatsbooked) {
		this.seatsbooked = seatsbooked;
	}
	public int getShowid() {
		return showid;
	}
	public void setShowid(int showid) {
		this.showid = showid;
	}
	
}
