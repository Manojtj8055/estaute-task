package com.estuate.estuate_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estuate.estuate_task.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
