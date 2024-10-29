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
public class Manufacturer
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name, description;
	
	private int totalOrders;

	private double orderPrice;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer")
	private List<Product> product;

	public Manufacturer()
	{
		// super();
	}

	public Manufacturer(String name, String description, double orderPrice, int totalOrders)
	{
		super();
		this.name = name;
		this.description = description;
		this.orderPrice = orderPrice;
		this.totalOrders = totalOrders;
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

	public double getOrderPrice()
	{
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice)
	{
		this.orderPrice = orderPrice;
	}

	public int getTotalOrders()
	{
		return totalOrders;
	}
	
	public void setTotalOrders(int totalOrders)
	{
		this.totalOrders = totalOrders;
	}
}