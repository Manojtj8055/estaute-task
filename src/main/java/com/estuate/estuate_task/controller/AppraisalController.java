package com.estuate.estuate_task.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estuate.estuate_task.entity.Employee;
import com.estuate.estuate_task.service.AppraisalService;
import com.estuate.estuate_task.service.CategoryService;
import com.estuate.estuate_task.service.EmployeeService;

@RestController
@RequestMapping("/appraisal")
public class AppraisalController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AppraisalService appraisalService;

    /**
     * Endpoint to get the actual percentage based on employee's rating
     * @param employeeId the ID of the employee
     * @return the actual percentage
     */
    @GetMapping("/actual-percentage/{employeeId}")
    public BigDecimal getActualPercentage(@PathVariable int employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return appraisalService.calculateActualPercentage(employee);
    }

    /**
     * Endpoint to get the deviation between the actual percentage and the standard
     * @param employeeId the ID of the employee
     * @return the deviation between actual and standard percentage
     */
    @GetMapping("/deviation/{employeeId}")
    public BigDecimal getDeviation(@PathVariable int employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);

        // Calculate the actual percentage for the employee
        BigDecimal actualPercentage = appraisalService.calculateActualPercentage(employee);

        // Calculate the deviation between actual and standard percentage
        return appraisalService.calculateDeviation(employee, actualPercentage);
    }

    /**
     * Endpoint to get the suggestion/advice based on the deviation of the employee
     * @param employeeId the ID of the employee
     * @return the suggestion message
     */
    @GetMapping("/suggestion/{employeeId}")
    public String getRevisionSuggestion(@PathVariable int employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);

        // Calculate the actual percentage for the employee
        BigDecimal actualPercentage = appraisalService.calculateActualPercentage(employee);

        // Calculate the deviation between actual and standard percentage
        BigDecimal deviation = appraisalService.calculateDeviation(employee, actualPercentage);

        // Get the suggestion based on the deviation
        return appraisalService.suggestRevision(deviation);
    }
}
