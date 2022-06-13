package com.example.demo.service.impl;

import java.util.List;
//import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service  // Always add service annotation when creating a serviceClass
public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeRepository employeeRepository;   // Create private employeeRepository object
	
	
	// Since we are using Constructor based dependency injection:
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {  
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) { // Dependency injection is needed before implementing this method
		return employeeRepository.save(employee); // Saves employee instance to DB
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);        // Simply fetch employee object from the database by parsing ID
//		
//		// Perform check to check if the optional object contains the employee object or not
//	    if(employee.isPresent()){
//	    	return employee.get();
//	    }else {
//	    	throw new ResourceNotFoundException("Employee", "Id", id);
//	    }
		return employeeRepository.findById(id).orElseThrow(() ->
						new ResourceNotFoundException("Employee", "Id", id));  // Using Lambda expression for the same logic used above
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		// We need to check whether employee with given ID exists in the database or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> 
					new ResourceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
	
		// save existing employee to DB
		employeeRepository.save(existingEmployee);
		
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		
		// check whether a employee exists in DB or not
		employeeRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Employee", "Id", id));   // lambda  expression
	
		employeeRepository.deleteById(id);
	}
	
	
	
}





// Service layer changes completed for saving or creating an employee REST API


// There are two types of dependency injection: 
// 1 - Setter based dependency injection - whenever you have optional parameters
// 2 - Constructor based dependency injection - whenever you have mandatory parameters


