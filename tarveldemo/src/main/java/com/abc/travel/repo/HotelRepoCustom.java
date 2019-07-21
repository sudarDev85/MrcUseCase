package com.abc.travel.repo;

import java.math.BigDecimal;
import java.util.List;

import com.abc.travel.model.Hotels;

public interface HotelRepoCustom {

	
	public List<Hotels> findByLocationAndFilterbyFeatureAndPrice (String location,List<String> featuresList,BigDecimal min, BigDecimal max);

	
	public List<Hotels> findByLocationAndFilterbyFeature (String location,List<String> featuresList);
}
