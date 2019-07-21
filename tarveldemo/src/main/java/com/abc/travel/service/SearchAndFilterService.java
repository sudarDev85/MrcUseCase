package com.abc.travel.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.travel.model.Hotels;
import com.abc.travel.repo.HotelRepo;
import com.abc.travel.vo.HotelDetails;
import com.abc.travel.vo.Results;
import com.abc.travel.vo.SearchInput;

@Service
public class SearchAndFilterService {

	@Autowired
	private HotelRepo hotelRepo;
	
	public Results search(SearchInput searchIP) {		
		Results  results= new Results();
		
		List<Hotels> hotelsList= hotelRepo.findByLocation(searchIP.getLocation());
		if(hotelsList!=null) {
		results.setResults(hotelsList.stream().
				map(x -> new HotelDetails(x.getHotelId(),x.getHotelName(),x.getFeatures(),x.getAvailableRoom(),x.getPrice())).collect(Collectors.toList()));
		
		results.setResultCount(results.getResults().size());
		}
		
		return results;
		
	}
	
	public Results searchandFilter(SearchInput searchIP) {		
		Results  results= new Results();
	
		List<Hotels> hotelsList= null;
		
		if(searchIP.getFeaturefilters()!=null && searchIP.getMinPrice()!=null && searchIP.getMaxPrice()!=null) {
			
			hotelsList= hotelRepo.findByLocationAndFilterbyFeatureAndPrice(searchIP.getLocation(),
					Arrays.asList(searchIP.getFeaturefilters().split(",")),searchIP.getMinPrice(),searchIP.getMaxPrice());
			
		} else if(searchIP.getFeaturefilters()!=null) {
			
			hotelsList= hotelRepo.findByLocationAndFilterbyFeature(searchIP.getLocation(),Arrays.asList(searchIP.getFeaturefilters().split(",")));
			
		}else if(searchIP.getMinPrice()!=null && searchIP.getMaxPrice()!=null) {
			
			hotelsList= hotelRepo.findByLocationAndFilterbyPrice(searchIP.getLocation(),searchIP.getMinPrice(),searchIP.getMaxPrice());
			
		} else{
			results.setResultCount(0);
			return results;
		}
		if(hotelsList!=null) {
		results.setResults(hotelsList.stream().
				map(x -> new HotelDetails(x.getHotelId(),x.getHotelName(),x.getFeatures(),x.getAvailableRoom(),x.getPrice())).collect(Collectors.toList()));
		
		results.setResultCount(results.getResults().size());
		}
		return results;
		
	}
	
	
	
}
