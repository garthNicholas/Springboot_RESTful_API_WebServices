package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);                   // We have defined a method in the Employee Service interface that can now be implemented
	List<Employee> getAllEmployees();                           // GETALL Employees REST API method
	Employee getEmployeeById(long id);                          // Parse ID as a method argument to this method
	Employee updateEmployee(Employee employee, long id);        // Method used to update Employee that has two arguments 
	void deleteEmployee(long id);
	
}
