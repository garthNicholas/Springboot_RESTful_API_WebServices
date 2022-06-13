package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootResTfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootResTfulWebServicesApplication.class, args);
	}

}



//
//3 important points to remember when dealing with service layer, the class that implements the service layer and the annotations needed:
//	1 - You do not need to add @Respository annotation - for the Public interface EmployeeRepository because Spring Data JPA already does this
//	2 - You do not need to add @Transactional annotation for the Public class EmployeeServiceImpl because Spring Data  JPA already provides tranactions for all its methods
//	3 - Starting with Spring 4.3, if a class, which is configured as a Spring Bean, has only one constuctor. The @Autowired annotation can be omitted and Spring will use that constructor and inject all necessary dependancies