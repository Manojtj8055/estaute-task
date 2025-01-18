package com.estuate.estuate_task.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estuate.estuate_task.entity.Employee;

@Service
public class BellCurveService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AppraisalService appraisalService;

    /**
     * Calculate and process the performance appraisals for all employees
     */
    public void calculateBellCurve() {
        // Get all employees
        List<Employee> employees = employeeService.getAllEmployees();

        // Process each employee
        for (Employee employee : employees) {
            // Calculate the actual percentage based on employee's rating
            BigDecimal actualPercentage = appraisalService.calculateActualPercentage(employee);

            // Calculate the deviation between the actual and the standard percentage
            BigDecimal deviation = appraisalService.calculateDeviation(employee, actualPercentage);

            // Get the suggestion based on the deviation
            String suggestion = appraisalService.suggestRevision(deviation);

            // Save the appraisal result for the employee
            appraisalService.saveAppraisal(employee, actualPercentage, deviation, suggestion);
        }
    }
}
