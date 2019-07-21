package com.abc.travel.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.travel.exception.InvalidInputException;
import com.abc.travel.service.SearchAndFilterService;
import com.abc.travel.vo.Results;
import com.abc.travel.vo.SearchInput;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class Search {
	
@Autowired
private SearchAndFilterService searchService;

@GetMapping("/search")
 public ResponseEntity<Results>  search(@RequestParam Map<String,String> searchParams) throws InvalidInputException {
	
	   String city= searchParams.get("location");
	   String fromdate = searchParams.get("checkinDate");
	   String todate=searchParams.get("checkoutDate");
	   String filters=searchParams.get("fq");
	   String minprice=searchParams.get("minprice");
	   String maxprice=searchParams.get("maxprice");
	   
	   Results result=null;
	   SearchInput searchInput = new SearchInput();
	   if(validateInput(city, fromdate, todate)) {
		    searchInput.setCheckInDate(convertDate(fromdate));
		   searchInput.setCheckOutDate(convertDate(todate));
		   searchInput.setLocation(city);
		   
		   if(filters==null&&minprice==null && maxprice==null){
			   result=searchService.search(searchInput); 
		   }else { 
			   searchInput.setFeaturefilters(filters);
			   searchInput.setMinPrice(new BigDecimal(minprice));
			   searchInput.setMaxPrice(new BigDecimal(maxprice));
			   result=searchService.searchandFilter(searchInput); 
		   }
	   }
		 
	 return  new ResponseEntity<>(result,HttpStatus.OK);
 }

private boolean validateInput(String city,String fromdate,String todate) throws InvalidInputException{
	
	StringBuilder erromsg=new StringBuilder(); 
	
   if(fromdate==null||city.isEmpty()) {
	    
	   erromsg.append("City is Empty");
   }
   if(fromdate==null||fromdate.isEmpty()) {
	   
	   erromsg.append((erromsg.length()>0)?",":""+"Check in date is Empty");  
 	 }
   if(todate==null||todate.isEmpty()) {
	  
	   erromsg.append((erromsg.length()>0)?",":""+"Check out date is Empty");  
 	 }
   
   if(erromsg.length()>0) {
	   throw new InvalidInputException(erromsg.toString());
   }
   return true;
}

private LocalDate convertDate(String date) {
	try {
	
	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");    		

     return LocalDate.parse(date, formatter);
	}
	catch(Exception e) {
		 throw new InvalidInputException("Invalid Date format");
	}

}


	
}
