package com.abc.travel.vo;

import java.math.BigDecimal;
import java.time.LocalDate;


public class SearchInput {
	
	
	public String location;
	
	public LocalDate checkInDate;
	
	public LocalDate checkOutDate;	
	
	public String featurefilters;
	
	public BigDecimal minPrice;
	
	
	public BigDecimal maxPrice;
	
	
	public String getFeaturefilters() {
		return featurefilters;
	}

	public void setFeaturefilters(String featurefilters) {
		this.featurefilters = featurefilters;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	

	
	
}
