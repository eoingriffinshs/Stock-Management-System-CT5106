package com.ct5106.StockManagementSystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name, description, colour, code;
	
	private int quantityInStock;

	private double price;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department")
	private Department department;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manufacturer")
	private Manufacturer manufacturer;

	public Product()
	{
		// super();
	}

	public Product(String name, String description, String colour, String code,int quantityInStock, double price, Department department, Manufacturer manufacturer)
	{
		super();
		this.name = name;
		this.quantityInStock = quantityInStock;
		this.description = description;
		this.colour = colour;
		this.code = code;
		this.price = price;
		this.department = department;
		this.manufacturer = manufacturer;
		
	}

	public Long getId()
	{
		return id;
	}

	// this should only be set in the DB, so commenting this one out
	/*
	 * public void setId(Long id) { this.id = id; }
	 */

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getQuantityInStock()
	{
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock)
	{
		this.quantityInStock = quantityInStock;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getColour()
	{
		return colour;
	}

	public void setColour(String colour)
	{
		this.colour = colour;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	// Getter and setter
	public Department getDepartment()
	{
		return department;
	}

	public void setDepartment(Department department)
	{
		this.department = department;
	}
	
	public Manufacturer getManufacturer()
	{
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer)
	{
		this.manufacturer = manufacturer;
	}
}