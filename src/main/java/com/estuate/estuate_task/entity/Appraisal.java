package com.estuate.estuate_task.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appraisal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int employeeId;
    private BigDecimal actualPercentage;
    private BigDecimal deviation;
    private String suggestion;
    
    
    
	public Appraisal() {
		super();
	}
	public Appraisal(Long id, int employeeId, BigDecimal actualPercentage, BigDecimal deviation, String suggestion) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.actualPercentage = actualPercentage;
		this.deviation = deviation;
		this.suggestion = suggestion;
	}
	@Override
	public String toString() {
		return "Appraisal [id=" + id + ", employeeId=" + employeeId + ", actualPercentage=" + actualPercentage
				+ ", deviation=" + deviation + ", suggestion=" + suggestion + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public BigDecimal getActualPercentage() {
		return actualPercentage;
	}
	public void setActualPercentage(BigDecimal actualPercentage) {
		this.actualPercentage = actualPercentage;
	}
	public BigDecimal getDeviation() {
		return deviation;
	}
	public void setDeviation(BigDecimal deviation) {
		this.deviation = deviation;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
    
    

   
}