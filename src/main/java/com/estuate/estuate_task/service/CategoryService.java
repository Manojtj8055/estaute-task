package com.estuate.estuate_task.service;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estuate.estuate_task.entity.Category;
import com.estuate.estuate_task.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

  
    public BigDecimal getCategoryStandard(String category) {
        return categoryRepository.findById(category)
                .map(Category::getStandardPercentage)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }
}

