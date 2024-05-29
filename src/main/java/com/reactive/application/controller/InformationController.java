package com.reactive.application.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.application.bo.EmployeeBO;
import com.reactive.application.entity.Employee;
import com.reactive.application.repo.EmployeeRepo;
import com.reactive.application.service.IEmployeeService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/info")
public class InformationController {

	
	@Autowired
	private IEmployeeService employeeService;
	
	@RequestMapping(path = "/save/{name}")
	public ResponseEntity<Mono<String>> saveName(@PathVariable(value = "name")String name) {
		
		EmployeeBO employee = new EmployeeBO();
		employee.setName(name);
		
		employeeService.saveEmployee(employee);
		
		return ResponseEntity.ok(null);
	}
	
}
