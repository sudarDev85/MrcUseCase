package com.abc.travel.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.abc.travel.exception.InvalidInputException;
import com.abc.travel.vo.ReseverationDetails;

@Service
public class ReserverService {

	public String reserver(ReseverationDetails reseverationDetails) {
		StringBuilder erromsg=new StringBuilder(); 
		
		   if(StringUtils.isEmpty(reseverationDetails.getAddressLine1())) {
			    
			   erromsg.append("AddressLine1 is Empty");
		   }
		   if(StringUtils.isEmpty(reseverationDetails.getAddressLine2())) {
			    
			   erromsg.append("AddressLine2 is Empty");
		   }
		   if(StringUtils.isEmpty(reseverationDetails.getCity())) {
			    
			   erromsg.append("City is Empty");
		   }
		   if(StringUtils.isEmpty(reseverationDetails.getCountry())) {
			    
			   erromsg.append("Country is Empty");
		   }
		   if(StringUtils.isEmpty(reseverationDetails.getFirstName())) {
			    
			   erromsg.append("First Name is Empty");
		   }
		   if(StringUtils.isEmpty(reseverationDetails.getLastName())) {
			    
			   erromsg.append("Last Name is Empty");
		   }
		   if(StringUtils.isEmpty(reseverationDetails.getState())) {
			    
			   erromsg.append("State is Empty");
		   }
		   if(reseverationDetails.getHotelId()<1) {
			    
			   erromsg.append("Hotel is Invalid");
		   }		   
		
		   if(erromsg.length()>0) {
			   throw new InvalidInputException(erromsg.toString());
		   }	
		
		
		return "1234";
		
	}
	
}
