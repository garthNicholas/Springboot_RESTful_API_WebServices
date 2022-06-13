package com.example.demo.model; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employees")   // Table annotation specifies the table in the database with which this entity is mapped
public class Employee {
	
	@Id                       // @Id annotation specifies the primary key of the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY)   // GeneratedValue annotation specifies the generation strategies for the values of primary keys
	private long id;
	
	@Column(name="first_name", nullable = false)  // @Column annotation  - to map a field to column
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	

}
