package com.abc.travel.vo;

import java.math.BigDecimal;
import java.util.List;

public class HotelDetails {
	
    private int hotelId;
	private String name;
	
	private String feature;
	
	private int availableRooms;
	
	private BigDecimal price;
	
	public HotelDetails(int hotelId,String name,String feature,int availableRooms,BigDecimal price) {
		this.hotelId=hotelId;
		this.name = name;
		this.feature= feature;
		this.availableRooms= availableRooms;
		this.price=price;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public int getAvailableRooms() {
		return availableRooms;
	}

	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
 
	


}
