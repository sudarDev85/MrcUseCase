package com.abc.travel;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.abc.travel.model.Hotels;
import com.abc.travel.repo.HotelRepo;
import com.abc.travel.service.SearchAndFilterService;
import com.abc.travel.vo.Results;
import com.abc.travel.vo.SearchInput;


@RunWith(SpringRunner.class)
public class TravelDemoRepoIntegrationTest {
	
	@TestConfiguration
    static class SearchAndFilterTestContextConfiguration {
  
        @Bean
        public SearchAndFilterService SearchAndFilterService() {
            return new SearchAndFilterService();
        }
    }
	
	   @Autowired
	    private SearchAndFilterService searchAndFilterService;
	   
	  
	    @MockBean
	    private HotelRepo hotelRepo;
	    
	    @Before
	    public void setUp() {
	    	Hotels hotel = new Hotels();
	    	hotel.setHotelId(1);
	    	hotel.setHotelName("Le Mediran");
	    	hotel.setLocation("Chennai");
	    	hotel.setAvailableRoom(20);
	    	hotel.setFeatures("Housekeeping,SwimmingPool,Restaurant,Parking,Bar");
	    	hotel.setPrice(new BigDecimal("1000.50"));
	    	List<Hotels> hotellist= new ArrayList<>();
	    	hotellist.add(hotel);
	    	
    	
	        Mockito.when(hotelRepo.findByLocation("Chennai"))
	          .thenReturn(hotellist);
	        
	        Mockito.when(hotelRepo.findByLocation("Pondy"))
	          .thenReturn(null);
	        
	        Mockito.when(hotelRepo.findByLocationAndFilterbyFeatureAndPrice("Chennai",Arrays.asList("Spa"),  new BigDecimal("20.00"),new BigDecimal("2000.00")))
	          .thenReturn(hotellist);
	        
	        Mockito.when(hotelRepo.findByLocationAndFilterbyFeatureAndPrice("Pondy",Arrays.asList("Spa"),  new BigDecimal("20.00"),new BigDecimal("2000.00")))
	          .thenReturn(null);
	        
	        Mockito.when(hotelRepo.findByLocationAndFilterbyFeature("Chennai", Arrays.asList("Spa")))
	          .thenReturn(hotellist);
	        
	        Mockito.when(hotelRepo.findByLocationAndFilterbyFeature("Pondy", Arrays.asList("Spa")))
	          .thenReturn(null);
	        
	        Mockito.when(hotelRepo.findByLocationAndFilterbyPrice("Chennai",  new BigDecimal("20.00"),new BigDecimal("2000.00")))
	          .thenReturn(hotellist);
	        
	        Mockito.when(hotelRepo.findByLocationAndFilterbyPrice("Pondy", new BigDecimal("20.00"),new BigDecimal("2000.00")))
	          .thenReturn(null);
	    } 
	    
	    @Test
	    public void testFindByLocation_Success() {
	    	SearchInput searchIP = new SearchInput();
	    	searchIP.setLocation("Chennai");
	    	 Results results=searchAndFilterService.search(searchIP);
	    	 
	    	 assertThat(results.getResults().size(),is(1));
	    	 assertThat(results.getResults().get(0).getName()).isEqualTo("Le Mediran");
	    	
	    }
	    
	    @Test
	    public void testFindByLocation_Faliure() {
	    	SearchInput searchIP = new SearchInput();
	    	searchIP.setLocation("Pondy");
	    	 Results results=searchAndFilterService.search(searchIP);
	    	 assertNull(results.getResults());
	    	 
	    	
	    }
	    
	    
	    @Test
	    public void testfindByLocationAndFilterbyFeatureAndPrice_Success() {
	    	SearchInput searchIP = new SearchInput();
	    	searchIP.setLocation("Chennai");
	    	searchIP.setFeaturefilters("Spa");
	    	searchIP.setMaxPrice(new BigDecimal("2000.00"));
	    	searchIP.setMinPrice(new BigDecimal("20.00"));
	    	 Results results=searchAndFilterService.searchandFilter(searchIP);
	    	 
	    	 assertThat(results.getResults().size(),is(1));
	    	 assertThat(results.getResults().get(0).getName()).isEqualTo("Le Mediran");
	    	
	    }
	    
	    @Test
	    public void testfindByLocationAndFilterbyFeatureAndPrice_Faliure() {
	    	SearchInput searchIP = new SearchInput();
	    	searchIP.setLocation("Pondy");
	    	searchIP.setFeaturefilters("Spa");
	    	 Results results=searchAndFilterService.searchandFilter(searchIP);
	    	 assertNull(results.getResults());
	    	 
	    	
	    }
	    @Test
	    public void testfindByLocationAndFilterbyFeature_Success() {
	    	SearchInput searchIP = new SearchInput();
	    	searchIP.setLocation("Chennai");
	    	searchIP.setFeaturefilters("Spa");	    	
	    	 Results results=searchAndFilterService.searchandFilter(searchIP);
	    	 
	    	 assertThat(results.getResults().size(),is(1));
	    	 assertThat(results.getResults().get(0).getName()).isEqualTo("Le Mediran");
	    	
	    }
	    
	    @Test
	    public void testfindByLocationAndFilterbyFeature_Faliure() {
	    	SearchInput searchIP = new SearchInput();
	    	searchIP.setLocation("Pondy");
	    	searchIP.setFeaturefilters("Spa");	    	
	    	 Results results=searchAndFilterService.searchandFilter(searchIP);
	    	 assertNull(results.getResults());
	    	 
	    	
	    }
	    
	    @Test
	    public void testfindByLocationAndFilterbyPrice_Success() {
	    	SearchInput searchIP = new SearchInput();
	    	searchIP.setLocation("Chennai");
	    	searchIP.setMaxPrice(new BigDecimal("2000.00"));
	    	searchIP.setMinPrice(new BigDecimal("20.00"));
	    	 Results results=searchAndFilterService.searchandFilter(searchIP);
	    	 
	    	 assertThat(results.getResults().size(),is(1));
	    	 assertThat(results.getResults().get(0).getName()).isEqualTo("Le Mediran");
	    	
	    }
	    
	    @Test
	    public void testfindByLocationAndFilterbyPrice_Faliure() {
	    	SearchInput searchIP = new SearchInput();
	    	searchIP.setLocation("Pondy");
	    	searchIP.setMaxPrice(new BigDecimal("2000.00"));
	    	searchIP.setMinPrice(new BigDecimal("20.00"));
	    	 Results results=searchAndFilterService.searchandFilter(searchIP);
	    	 assertNull(results.getResults());
	    	 
	    	
	    }
	    
	    
	   
}
