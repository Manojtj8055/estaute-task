package com.estuate.estuate_task.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id
    private String category;
    private BigDecimal standardPercentage;
    
    
    
    
    
    
	public Category(String category, BigDecimal standardPercentage) {
		super();
		this.category = category;
		this.standardPercentage = standardPercentage;
	}

	@Override
	public String toString() {
		return "Category [category=" + category + ", standardPercentage=" + standardPercentage + "]";
	}
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public BigDecimal getStandardPercentage() {
		return standardPercentage;
	}
	public void setStandardPercentage(BigDecimal standardPercentage) {
		this.standardPercentage = standardPercentage;
	}
    
    
    
}
