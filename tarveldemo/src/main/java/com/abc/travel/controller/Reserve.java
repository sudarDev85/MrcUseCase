package com.abc.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.travel.service.ReserverService;
import com.abc.travel.vo.ReseverationDetails;



@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class Reserve {

	@Autowired
	public ReserverService reserv;
	
@RequestMapping(value = "/reserve",method = RequestMethod.POST)
public ResponseEntity<String>  confirmReservation(@RequestBody ReseverationDetails reseverationDetails){
	
	     reserv.reserver(reseverationDetails);
	
	 return  new ResponseEntity<>("Success",HttpStatus.OK);
}
	
}
