package com.estuate.estuate_task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estuate.estuate_task.service.EmployeeService;
import com.estuate.estuate_task.dto.EmployeeAppraisalDTO;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

  
    @GetMapping("/appraisal-details")
    public List<EmployeeAppraisalDTO> getEmployeeBellCurveData() {
        return employeeService.getEmployeeBellCurveData();
    }
}
