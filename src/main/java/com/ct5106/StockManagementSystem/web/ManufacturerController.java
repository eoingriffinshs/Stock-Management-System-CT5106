package com.ct5106.StockManagementSystem.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct5106.StockManagementSystem.domain.Manufacturer;
import com.ct5106.StockManagementSystem.domain.ManufacturerRepository;

@RestController
public class ManufacturerController
{
	private final ManufacturerRepository mrepository;

	public ManufacturerController(ManufacturerRepository mrepository)
	{
		this.mrepository = mrepository;
	}

	@GetMapping("/manufacturer")
	public Iterable<Manufacturer> getManufacturers()
	{
		return mrepository.findAll();
	}

}