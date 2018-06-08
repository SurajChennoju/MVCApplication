package com.javawebtutor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "PRODUCT")
public class Product 
{
    private int id;
    private String name;
    private String description;
    private float price;
 
    //private Category category;
 
    public Product() {
    }
 
    public Product(int id,String name, String description, float price)
    {
        this.name = name;
        this.description = description;
        this.price = price;
        //this.category = category;
    }
 
    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue
    public int getId() {
        return id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setId(int id) {
		this.id = id;
	}
 
    /*
     * @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    public Category getCategory() {
        return category;
    }
    */
 
    // other getters and setters
    
}