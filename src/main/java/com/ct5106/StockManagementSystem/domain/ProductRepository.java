package com.ct5106.StockManagementSystem.domain;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Long>
{

	List<Product> findByName(String name);
	
	List<Product> findByCode(String code);
	
	List<Product> findByDescription(String description);
	
	List<Product> findByColour(String Colour);
	
}