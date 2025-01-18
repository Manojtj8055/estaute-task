package com.estuate.estuate_task.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estuate.estuate_task.entity.Category;
import com.estuate.estuate_task.entity.Employee;
import com.estuate.estuate_task.repository.CategoryRepository;
import com.estuate.estuate_task.repository.EmployeeRepository;

@Service
public class AppraisalService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private long getTotalEmployees(List<Employee> employees) {
        return employees.size();
    }

  
    private Map<String, Long> countEmployeesByCategory(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getCategory, Collectors.counting()));
    }

  
    private Map<String, BigDecimal> calculateActualPercentage(Map<String, Long> categoryCounts, long totalEmployees) {
        Map<String, BigDecimal> actualPercentages = new HashMap<>();
        for (Map.Entry<String, Long> entry : categoryCounts.entrySet()) {
            BigDecimal percentage = BigDecimal.valueOf(entry.getValue())
                    .divide(BigDecimal.valueOf(totalEmployees), 4, BigDecimal.ROUND_HALF_UP)
                    .multiply(BigDecimal.valueOf(100));
            actualPercentages.put(entry.getKey(), percentage);
        }
        return actualPercentages;
    }

    private Map<String, BigDecimal> calculateDeviations(Map<String, BigDecimal> actualPercentages) {
        Map<String, BigDecimal> deviations = new HashMap<>();
        
        // Fetch the standard percentages from the category table
        List<Category> categories = categoryRepository.findAll();
        Map<String, BigDecimal> standardPercentages = categories.stream()
                .collect(Collectors.toMap(Category::getCategory, Category::getStandardPercentage));

        // Calculate the deviation for each category
        for (String category : actualPercentages.keySet()) {
            BigDecimal actual = actualPercentages.get(category);
            BigDecimal standard = standardPercentages.get(category);
            BigDecimal deviation = actual.subtract(standard);
            deviations.put(category, deviation);
        }

        return deviations;
    }

   
    private Map<String, String> suggestRevisions(Map<String, BigDecimal> deviations) {
        Map<String, String> suggestions = new HashMap<>();
        for (Map.Entry<String, BigDecimal> entry : deviations.entrySet()) {
            if (entry.getValue().abs().compareTo(BigDecimal.valueOf(10)) > 0) {
                suggestions.put(entry.getKey(), "Consider revision");
            } else {
                suggestions.put(entry.getKey(), "No revision needed");
            }
        }
        return suggestions;
    }

    
    public Map<String, Object> generateBellCurveData() {
      
        List<Employee> employees = employeeRepository.findAll();
        
     
        long totalEmployees = getTotalEmployees(employees);
        
       
        Map<String, Long> categoryCounts = countEmployeesByCategory(employees);
        
      
        Map<String, BigDecimal> actualPercentages = calculateActualPercentage(categoryCounts, totalEmployees);
        
       
        Map<String, BigDecimal> deviations = calculateDeviations(actualPercentages);
        
       
        Map<String, String> suggestions = suggestRevisions(deviations);

        
        Map<String, Object> bellCurveData = new HashMap<>();
        bellCurveData.put("categoryCounts", categoryCounts);
        bellCurveData.put("actualPercentages", actualPercentages);
        bellCurveData.put("deviations", deviations);
        bellCurveData.put("suggestions", suggestions);

        return bellCurveData;
    }
}
