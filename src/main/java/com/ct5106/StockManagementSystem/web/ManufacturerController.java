package com.ct5106.StockManagementSystem.web;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ct5106.StockManagementSystem.domain.Department;
import com.ct5106.StockManagementSystem.domain.DepartmentRepository;
import com.ct5106.StockManagementSystem.domain.Manufacturer;
import com.ct5106.StockManagementSystem.domain.ManufacturerRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/manufacturer")
public class ManufacturerController {

    private final ManufacturerRepository mrepository;

    public ManufacturerController(ManufacturerRepository mrepository) {
        this.mrepository = mrepository;
    }

    @GetMapping
    public Iterable<Manufacturer> getManufacturers() {
        return mrepository.findAll();
    }

    @PostMapping
    public Manufacturer createManufacturer(@RequestBody Manufacturer manufacturer) {
        return mrepository.save(manufacturer);
    }


}
