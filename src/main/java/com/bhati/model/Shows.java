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
public class Shows {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="show_id")
	private int id;
	
	@Column(name ="showtime")
	private Date showtime;
	
	@Column
	private int movieid;
	
	@Column
	private int theatreid;

	@Column
	private int currentAvailability;
	
	@Column
	private int price;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
