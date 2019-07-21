package com.abc.travel.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abc.travel.model.Hotels;

@Repository
public interface  HotelRepo extends JpaRepository<Hotels, Integer>,HotelRepoCustom {

@Query(value="from Hotels where location= :location")
public List<Hotels> findByLocation(String location);
//
//@Query(value="from Hotels where location= :location AND(features IN :featuresList OR price BETWEEN :min AND :max )")
//public List<Hotels> findByLocationAndFilterbyFeatureAndPrice (String location,List<String> featuresList,Integer min, Integer max);
//
//@Query(value="from Hotels where location= :location AND features IN :featuresList")
//public List<Hotels> findByLocationAndFilterbyFeature (String location,List<String> featuresList);

@Query(value="from Hotels where location= :location AND price BETWEEN :min AND :max ")
public List<Hotels> findByLocationAndFilterbyPrice (String location,BigDecimal min, BigDecimal max);

}
