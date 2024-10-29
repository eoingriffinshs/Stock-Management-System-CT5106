package com.ct5106.StockManagementSystem.domain;

import java.util.List;

import com.ct5106.StockManagementSystem.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
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
	
	List<Product> findByColour(String colour);
	
	// JPA query method
    List<Product> findDistinctByNameAndColour(@Param("name") String name, @Param("colour") String colour);

    // JPQL query using @Query annotation
    @Query("SELECT p FROM Product p WHERE p.price > :price AND p.quantityInStock < :quantityInStock")
    List<Product> findExpensiveProductsWithLowStock(@Param("price") double price, @Param("quantityInStock") int quantityInStock);
	
}