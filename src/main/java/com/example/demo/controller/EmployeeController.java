package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController                         // Controller layer is dependent on service layer, so must always first change service layer
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService; // Constructor based Dependency injection 

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	
	// Build create employee REST API
	// Controller layer is dependent on service layer, so must always first change service layer
	// ResponseEntity class used because you can provide complete response details in this class - EG Status, Header
	
	@PostMapping()            // This should handle POST HTTP request
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	
	// Build get all employees REST API
	// Controller layer is dependent on service layer, so must always first change service layer
	@GetMapping                  // This REST API Handles GET HTTP requests
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	
	// Build get employee by id REST API
	// Controller layer is dependent on service layer, so must always first change service layer
	// First create a method and then make this into a REST API by annotation
	// URL Template EG: http://localhost:8080/api/employees/1
	
	@GetMapping("{id}")                                    // Syntax to bind pathway level value which can by dynamically changed so is wrapped in curly braces
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}
	
	
	// Build update employee REST API
	// Controller layer is dependent on service layer, so must always first change service layer
	// URL Template EG: http://localhost:8080/api/employees/1
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id")long id
												  ,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}
	
	// Build delete employee REST API
	// Controller layer is dependent on service layer, so must always first change service layer
	// URL Template EG: http://localhost:8080/api/employees/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id")long id){
		
		// delete employee from DB
		employeeService.deleteEmployee(id);
		
		
		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
		
	}
	


}




// @RestController is a convenient annotation that combines @Controller and @ResponseBody, 
// which eliminates the need to annotate every request handling method of the controller class with the @ResponseBody annotation