package com.estuate.estuate_task.dto;

import java.math.BigDecimal;

public class EmployeeAppraisalDTO {

    private int employeeId;
    private String employeeName;
    private String category;
    private BigDecimal actualPercentage;
    private BigDecimal deviation;
    private String suggestion;

  
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
