package com.abc.travel.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.abc.travel.model.Hotels;

public class HotelRepoCustomImpl implements HotelRepoCustom{
	
	@PersistenceContext
    private EntityManager entityManager;
 

	@Override
	public List<Hotels> findByLocationAndFilterbyFeatureAndPrice(String location, List<String> featuresList,
			BigDecimal min, BigDecimal max) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hotels> query = cb.createQuery(Hotels.class);
        Root<Hotels> root = query.from(Hotels.class);
 
       
        List<Predicate> predicates = new ArrayList<>();
       
        for (String feature : featuresList) {
            predicates.add(cb.like(root.get("features"),"%"+feature.trim()+"%"));
        }
        query.select(root)
            .where(cb.equal(root.get("location"),location),cb.between(root.get("price"), min, max),
            		cb.and(predicates.toArray(new Predicate[predicates.size()]))     		
            				);
 
        return entityManager.createQuery(query)
            .getResultList();
		
	}

	@Override
	public List<Hotels> findByLocationAndFilterbyFeature(String location, List<String> featuresList) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hotels> query = cb.createQuery(Hotels.class);
        Root<Hotels> root = query.from(Hotels.class);
 
       
        List<Predicate> predicates = new ArrayList<>();
       
        for (String feature : featuresList) {
            predicates.add(cb.like(root.get("features"),"%"+feature.trim()+"%"));
        }
        query.select(root)
            .where(cb.equal(root.get("location"),location),
            		cb.and(predicates.toArray(new Predicate[predicates.size()]))     		
            				);
 
        return entityManager.createQuery(query)
            .getResultList();
	}

}
