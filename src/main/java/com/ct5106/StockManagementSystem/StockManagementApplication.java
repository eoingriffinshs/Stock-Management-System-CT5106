package com.ct5106.StockManagementSystem;

import org.slf4j.Logger;



import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ct5106.StockManagementSystem.domain.AppUser;
import com.ct5106.StockManagementSystem.domain.AppUserRepository;
import com.ct5106.StockManagementSystem.domain.Department;
import com.ct5106.StockManagementSystem.domain.DepartmentRepository;
import com.ct5106.StockManagementSystem.domain.Product;
import com.ct5106.StockManagementSystem.domain.ProductRepository;
import com.ct5106.StockManagementSystem.domain.Manufacturer;
import com.ct5106.StockManagementSystem.domain.ManufacturerRepository;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class StockManagementApplication implements CommandLineRunner
{
	private final ProductRepository repository ;
	
	private final DepartmentRepository drepository;
	
	private final ManufacturerRepository mrepository;
	
	private final AppUserRepository urepository;


	private static final Logger logger = LoggerFactory.getLogger(StockManagementApplication.class);

	public StockManagementApplication(ProductRepository repository, DepartmentRepository drepository, ManufacturerRepository mrepository, AppUserRepository urepository)
	{
		this.repository = repository;
		this.drepository = drepository;
		this.mrepository = mrepository;
		this.urepository = urepository;
		
	}

	public static void main(String[] args)
	{

		SpringApplication.run(StockManagementApplication.class, args);

		logger.info("Application started");

	}

	@Override
	public void run(String... args) throws Exception 
	{
		
		// username, password, role
		// "user", "user", "USER"
		urepository.save(new AppUser("user","$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));
		// "admin", "admin", ADMIN"
		urepository.save(new AppUser("admin","$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
		
		logger.info("Starting the initialization of Products, Departments and Manufacturers...");
		
		Department department1 = new Department("Womens" , "Womens Clothes", 0.0, 0);
		Department department2 = new Department("Mens" , "Mens Clothes",0.0, 0);
		drepository.save(department1);
		drepository.save(department2);
		
		logger.info("Departments saved: {}, {}", department1.getName(), department2.getName());
		
		Manufacturer manufacterer1 = new Manufacturer("Galway shirt co.","shirt and t-shirt manufacturer", 0,0 );
		Manufacturer manufacterer2 = new Manufacturer("Levi","denim manufacturer", 0,0 );
		mrepository.save(manufacterer1);
		mrepository.save(manufacterer2);
		
		logger.info("Manufacturers saved: {}, {}", manufacterer1.getName(), manufacterer2.getName());
		
		repository.save(new Product("T-shirt", "Crew Neck", "White", "210786542", 20, 2.50, department1, manufacterer1));
		repository.save(new Product("Jeans", "Denim", "Blue", "210567832", 15, 8, department1, manufacterer2));
		
		repository.save(new Product("Mens T-shirt", "Crew Neck", "White", "210786542", 20, 2.50, department2, manufacterer1));
		repository.save(new Product("Mens Jeans", "Denim", "Blue", "210567832", 15, 8, department2, manufacterer2));

		//Fetch all products and log to console
		
		for (Product product : repository.findAll()) 
		{
			logger.info("name: {}, description: {}, colour: {}", product.getName(), product.getDescription(), product.getColour());
		}	
		
	}
}