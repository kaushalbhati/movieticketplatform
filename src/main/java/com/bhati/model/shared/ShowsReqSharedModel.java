package com.bhati.model.shared;

import java.util.Date;

import javax.persistence.Column;

public class ShowsReqSharedModel {

	private Date showtime;
	private int movieid;
	private int theatreid;
	private int currentAvailability;
	private int price;
	
	public Date getShowtime() {
		return showtime;
	}
	public void setShowtime(Date showtime) {
		this.showtime = showtime;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public int getTheatreid() {
		return theatreid;
	}
	public void setTheatreid(int theatreid) {
		this.theatreid = theatreid;
	}
	public int getCurrentAvailability() {
		return currentAvailability;
	}
	public void setCurrentAvailability(int currentAvailability) {
		this.currentAvailability = currentAvailability;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
