package com.ct5106.StockManagementSystem.web;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ct5106.StockManagementSystem.domain.Department;
import com.ct5106.StockManagementSystem.domain.DepartmentRepository;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentRepository drepository;

    public DepartmentController(DepartmentRepository drepository) {
        this.drepository = drepository;
    }

    @GetMapping
    public Iterable<Department> getDepartments() {
        return drepository.findAll();
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return drepository.save(department);
    }


}