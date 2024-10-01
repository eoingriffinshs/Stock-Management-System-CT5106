package com.ct5106.StockManagementSystem.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct5106.StockManagementSystem.domain.Product;
import com.ct5106.StockManagementSystem.domain.ProductRepository;

@RestController
public class ProductController
{
	private final ProductRepository repository;

	public ProductController(ProductRepository repository)
	{
		this.repository = repository;
	}

	@GetMapping("/product")
	public Iterable<Product> getProducts()
	{
		return repository.findAll();
	}

}