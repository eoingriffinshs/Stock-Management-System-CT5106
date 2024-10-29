package com.ct5106.StockManagementSystem.domain;

import org.springframework.data.repository.CrudRepository;
import com.ct5106.StockManagementSystem.domain.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long>
{

	// JPA query method
    List<Manufacturer> findDistinctByNameAndDescription(@Param("name") String name, @Param("description") String description);

    // JPQL query using @Query annotation
    @Query("SELECT m FROM Manufacturer m WHERE m.totalOrders > :totalOrders")
    List<Manufacturer> findManufacturersWithMoreThanTotalOrders(@Param("totalOrders") int totalOrders);
	
}
