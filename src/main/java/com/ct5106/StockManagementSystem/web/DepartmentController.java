package com.ct5106.StockManagementSystem.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct5106.StockManagementSystem.domain.Department;
import com.ct5106.StockManagementSystem.domain.DepartmentRepository;

@RestController
public class DepartmentController
{
	private final DepartmentRepository drepository;

	public DepartmentController(DepartmentRepository drepository)
	{
		this.drepository = drepository;
	}

	@GetMapping("/department")
	public Iterable<Department> getDepartments()
	{
		return drepository.findAll();
	}

}