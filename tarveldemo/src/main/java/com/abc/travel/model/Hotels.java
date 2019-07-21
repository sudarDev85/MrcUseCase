package com.abc.travel.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hotels {
	
	@Id
	private Integer hotelId;
	
	private String hotelName;
	
	private String location;
	
	private Integer availableRoom;
	
	private String features;
	
	private BigDecimal price;

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getAvailableRoom() {
		return availableRoom;
	}

	public void setAvailableRoom(Integer availableRoom) {
		this.availableRoom = availableRoom;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
	  
}
