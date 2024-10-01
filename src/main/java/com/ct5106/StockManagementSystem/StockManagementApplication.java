package com.ct5106.StockManagementSystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ct5106.StockManagementSystem.domain.Department;
import com.ct5106.StockManagementSystem.domain.DepartmentRepository;
import com.ct5106.StockManagementSystem.domain.Product;
import com.ct5106.StockManagementSystem.domain.ProductRepository;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class StockManagementApplication implements CommandLineRunner
{
	private final ProductRepository repository ;
	
	private final DepartmentRepository drepository;

	private static final Logger logger = LoggerFactory.getLogger(StockManagementApplication.class);

	public StockManagementApplication(ProductRepository repository, DepartmentRepository drepository)
	{
		this.repository = repository;
		this.drepository = drepository;
		
	}

	public static void main(String[] args)
	{

		SpringApplication.run(StockManagementApplication.class, args);

		logger.info("Application started");

	}

	@Override
	public void run(String... args) throws Exception 
	{
		Department department1 = new Department("Womens" , "Womens Clothes", 0.0, 0);
		Department department2 = new Department("Mens" , "Mens Clothes",0.0, 0);
		drepository.save(department1);
		drepository.save(department2);
		
		repository.save(new Product("T-shirt", "Crew Neck", "White", "210786542", 20, 2.50, department1));
		repository.save(new Product("Jeans", "Denim", "Blue", "210567832", 15, 8, department1));
		
		repository.save(new Product("Mens T-shirt", "Crew Neck", "White", "210786542", 20, 2.50, department2));
		repository.save(new Product("Mens Jeans", "Denim", "Blue", "210567832", 15, 8, department2));

		//Fetch all products and log to console
		
		for (Product product : repository.findAll()) 
		{
			logger.info("name: {}, description: {}, colour: {}", product.getName(), product.getDescription(), product.getColour());
		}
		
		//Find by colour
		
		for (Product product : repository.findByColour("White")) 
		{
			logger.info("name: {}, description: {}, colour: {}", product.getName(), product.getDescription(), product.getColour());
		}
		

		
		
	}
}