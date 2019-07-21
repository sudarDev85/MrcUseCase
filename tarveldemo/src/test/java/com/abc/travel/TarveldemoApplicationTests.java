package com.abc.travel;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.abc.travel.controller.Search;
import com.abc.travel.service.SearchAndFilterService;
import com.abc.travel.vo.HotelDetails;
import com.abc.travel.vo.Results;


@RunWith(SpringRunner.class)
@WebMvcTest(Search.class)
public class TarveldemoApplicationTests {

	@Autowired
    private MockMvc mvc;
 
	
	@MockBean
    private SearchAndFilterService service;

	@Before
    public void setUp() {
		HotelDetails hotelDetails = new HotelDetails(1,"Le Mediran",
				"Housekeeping,SwimmingPool,Restaurant,Parking,Bar",20,new BigDecimal("1000.50"));
		List<HotelDetails> hotellist= new ArrayList<>();
    	hotellist.add(hotelDetails);
    	
    	Results results = new Results();
    	results.setResults(hotellist);
    	
        Mockito.when(service.search(Mockito.any()))
          .thenReturn(results);   
        
        Mockito.when(service.searchandFilter(Mockito.any()))
        .thenReturn(results);   
       
    } 
	
	@Test
	public void searchLocationSuccess() throws Exception {
		
		mvc.perform(get("/search?city=Chennai&fromdate=07/02/2019&todate=07/03/2019")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())			     
			      .andExpect(jsonPath("$.results[0].name", is("Le Mediran")));
	}
	
	@Test
	public void searchLocationFailure() throws Exception {
		
		mvc.perform(get("/search?city=Chennai&fromdate=07/02/2019&todate=")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isBadRequest());	     
			    
	}
	
	@Test
	public void searchLocationAndFilterSuccess() throws Exception {
		
		mvc.perform(get("/search?city=Chennai&fromdate=07/02/2019&todate=07/03/2019&fq=Parking,Bar,Restaurant&minprice=10.00&maxprice=2000")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())			     
			      .andExpect(jsonPath("$.results[0].name", is("Le Mediran")));
	}
	
	@Test
	public void searchLocationAndFilterFailure() throws Exception {
		
		mvc.perform(get("/search?city=Chennai&fromdate=07/02/2019&todate=07/03/2019&fq=Parking,Bar,Restaurant&maxprice=2000")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isInternalServerError());		     
			      
	}
	

}
