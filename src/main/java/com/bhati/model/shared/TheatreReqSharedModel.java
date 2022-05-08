package com.bhati.model.shared;

import javax.persistence.Column;

public class TheatreReqSharedModel {

	private String name;
	private String location;
	private int capactiy;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCapactiy() {
		return capactiy;
	}
	public void setCapactiy(int capactiy) {
		this.capactiy = capactiy;
	}
	
	
}
