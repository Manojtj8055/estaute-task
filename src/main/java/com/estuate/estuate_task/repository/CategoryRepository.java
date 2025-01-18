package com.estuate.estuate_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estuate.estuate_task.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{

}
