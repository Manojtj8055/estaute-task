package com.estuate.estuate_task.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estuate.estuate_task.service.AppraisalService;


@RestController
@RequestMapping("/appraisal")
public class AppraisalController {

    @Autowired
    private AppraisalService appraisalService;

    @GetMapping("/bellcurve")
    public Map<String, Object> getBellCurveData() {
        return appraisalService.generateBellCurveData();
    }
}