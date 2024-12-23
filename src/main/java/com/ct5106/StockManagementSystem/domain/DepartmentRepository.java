package com.ct5106.StockManagementSystem.domain;

import org.springframework.data.repository.CrudRepository;
import com.ct5106.StockManagementSystem.domain.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Long>
{

	// JPA query method
    List<Department> findDistinctByNameAndDescription(@Param("name") String name, @Param("description") String description);

    // JPQL query using @Query annotation
    @Query("SELECT m FROM Department m WHERE m.totalSales > :totalSales")
    List<Department> findDepartmentsWithMoreThanTotalSales(@Param("totalSales") int totalSales);
	
}