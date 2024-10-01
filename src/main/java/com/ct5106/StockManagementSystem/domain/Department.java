package com.ct5106.StockManagementSystem.domain;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Department
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name, description;
	
	private int totalSales;

	private double salesPrice;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
	private List<Product> product;

	public Department()
	{
		// super();
	}

	public Department(String name, String description, double salesPrice, int totalSales)
	{
		super();
		this.name = name;
		this.description = description;
		this.salesPrice = salesPrice;
		this.totalSales = totalSales;
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public double getSalesPrice()
	{
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice)
	{
		this.salesPrice = salesPrice;
	}

	public int getTotalSales()
	{
		return totalSales;
	}
	
	public void setTotalSales(int totalSales)
	{
		this.totalSales = totalSales;
	}
}
