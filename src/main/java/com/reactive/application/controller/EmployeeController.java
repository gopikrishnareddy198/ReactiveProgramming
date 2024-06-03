package com.reactive.application.controller;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.application.entity.Employee;
import com.reactive.application.repo.EmployeeRepo;
import com.reactive.application.service.IEmployeeService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/info")
@Slf4j
public class EmployeeController {

	
	private IEmployeeService employeeService;
	
	public EmployeeController(IEmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping(path = "/save/{name}")
	
	public Mono<Employee> saveName(@PathVariable(value = "name")String name) {
		Employee employee = new Employee();
		employee.setName(name);
//		employee.setId(1);
		return employeeService.saveEmployee(employee);
	}
	
}
