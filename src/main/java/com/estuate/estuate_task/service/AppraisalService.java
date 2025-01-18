package com.estuate.estuate_task.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estuate.estuate_task.entity.Appraisal;
import com.estuate.estuate_task.entity.Employee;
import com.estuate.estuate_task.repository.AppraisalRepository;

@Service
public class AppraisalService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AppraisalRepository appraisalRepository;

    /**
     * Calculate the actual percentage for the given employee based on their rating
     */
    public BigDecimal calculateActualPercentage(Employee employee) {
        // The logic for actual percentage can be customized based on rating logic.
        switch (employee.getRating()) {
            case 1: return BigDecimal.valueOf(90);
            case 2: return BigDecimal.valueOf(75);
            case 3: return BigDecimal.valueOf(60);
            case 4: return BigDecimal.valueOf(45);
            case 5: return BigDecimal.valueOf(30);
            default: return BigDecimal.ZERO;
        }
    }

    /**
     * Calculate the deviation between actual and standard percentage
     */
    public BigDecimal calculateDeviation(Employee employee, BigDecimal actualPercentage) {
        BigDecimal standardPercentage = categoryService.getCategoryStandard(employee.getCategory());
        return actualPercentage.subtract(standardPercentage);
    }

    /**
     * Suggest revision based on deviation
     */
    public String suggestRevision(BigDecimal deviation) {
        BigDecimal threshold = BigDecimal.valueOf(5);
        if (deviation.compareTo(threshold) > 0) {
            return "Suggest Revision - Over Performance";
        } else if (deviation.compareTo(threshold.negate()) < 0) {
            return "Suggest Revision - Under Performance";
        } else {
            return "No Revision Needed";
        }
    }

    /**
     * Save appraisal data after calculating deviation and suggestion
     */
    public void saveAppraisal(Employee employee, BigDecimal actualPercentage, BigDecimal deviation, String suggestion) {
        Appraisal appraisal = new Appraisal();
        appraisal.setEmployeeId(employee.getId());
        appraisal.setActualPercentage(actualPercentage);
        appraisal.setDeviation(deviation);
        appraisal.setSuggestion(suggestion);
        appraisalRepository.save(appraisal);
    }
}
