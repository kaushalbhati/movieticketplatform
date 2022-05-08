package com.bhati.model.shared;

import java.util.Date;

public class BookingResSharedModel {

	private int id;
	private boolean bookingDone;
	private Date showtime;
	private int ticketAsked;
	private int finalPrice;
	private int hourValue;
	private String discountReason;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isBookingDone() {
		return bookingDone;
	}

	public void setBookingDone(boolean bookingDone) {
		this.bookingDone = bookingDone;
	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}

	public String getDiscountReason() {
		return discountReason;
	}

	public void setDiscountReason(String discountReason) {
		this.discountReason = discountReason;
	}

	public Date getShowtime() {
		return showtime;
	}

	public void setShowtime(Date showtime) {
		this.showtime = showtime;
	}

	public int getTicketAsked() {
		return ticketAsked;
	}

	public void setTicketAsked(int ticketAsked) {
		this.ticketAsked = ticketAsked;
	}

	public int getHourValue() {
		return hourValue;
	}

	public void setHourValue(int hourValue) {
		this.hourValue = hourValue;
	}
	
	
	
}
