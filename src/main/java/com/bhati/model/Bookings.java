package com.bhati.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Bookings {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="book_id")
	private int id;
	
	@Column
	private int userid;
	
	@Column
	private int theatreid;
	
	@Column
	private int seatsbooked;
	
	@Column
	private int discountedSeats;
	
	@Column
	private int showid;

	@Column
	private int movieid;
	
	@Column
	private int totalprice;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getTheatreid() {
		return theatreid;
	}

	public void setTheatreid(int theatreid) {
		this.theatreid = theatreid;
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

	public int getMovieid() {
		return movieid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public int getDiscountedSeats() {
		return discountedSeats;
	}

	public void setDiscountedSeats(int discountedSeats) {
		this.discountedSeats = discountedSeats;
	}
	
}
