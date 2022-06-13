package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

// JPA repository has <two, parameters>     Type of entity & Type of primary key
// Spring Data JPA internally provides @Repository Annotation so we do not need to add @Repository Annotation to EmployeeRepository interface
// By default Spring Data JPA made JpaRepository methods transactional, so we do not need to add @Transactional Annotation in service class


public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
