package com.estuate.estuate_task.service;



import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estuate.estuate_task.dto.EmployeeAppraisalDTO;
import com.estuate.estuate_task.entity.Category;
import com.estuate.estuate_task.entity.Employee;
import com.estuate.estuate_task.repository.CategoryRepository;
import com.estuate.estuate_task.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Get all employees with calculated bell curve data (actual percentage, deviation, and suggestion)
     */
    public List<EmployeeAppraisalDTO> getEmployeeBellCurveData() {
        List<Employee> employees = employeeRepository.findAll();
        List<Category> categories = categoryRepository.findAll();

        Map<String, BigDecimal> categoryStandardPercentageMap = categories.stream()
                .collect(Collectors.toMap(Category::getCategory, Category::getStandardPercentage));

     
        return employees.stream().map(employee -> {
            EmployeeAppraisalDTO dto = new EmployeeAppraisalDTO();
            dto.setEmployeeId(employee.getId());
            dto.setEmployeeName(employee.getName());
            dto.setCategory(employee.getCategory());

           
            BigDecimal actualPercentage = calculateActualPercentage(employee.getCategory());
            dto.setActualPercentage(actualPercentage);

         
            BigDecimal standardPercentage = categoryStandardPercentageMap.get(employee.getCategory());

         
            BigDecimal deviation = actualPercentage.subtract(standardPercentage);
            dto.setDeviation(deviation);

          
            String suggestion = generateSuggestion(deviation);
            dto.setSuggestion(suggestion);

            return dto;
        }).collect(Collectors.toList());
    }

    /**
     * Calculate the actual percentage based on the employee's category.
     * You can replace this with actual logic based on your rules.
     */
    private BigDecimal calculateActualPercentage(String category) {
        switch (category) {
            case "A":
                return new BigDecimal("10.0");  
            case "B":
                return new BigDecimal("20.0");  
            case "C":
                return new BigDecimal("30.0");  
            case "D":
                return new BigDecimal("25.0");  
            case "E":
                return new BigDecimal("15.0");  
            default:
                return BigDecimal.ZERO;
        }
    }

  
    private String generateSuggestion(BigDecimal deviation) {
        int comparison = deviation.compareTo(BigDecimal.ZERO);

        if (comparison > 0) {
            return "Review Needed";
        } else if (comparison < 0) {
            return "No Review Needed";
        } else {
            return "Perfectly Aligned";
        }
    }

  
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

   
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }
}
