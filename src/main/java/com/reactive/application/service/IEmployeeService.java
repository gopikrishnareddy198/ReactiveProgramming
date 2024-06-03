package com.reactive.application.service;

import com.reactive.application.entity.Employee;

import reactor.core.publisher.Mono;

public interface IEmployeeService {
	Mono<Employee> saveEmployee(Employee employeeBO);
}
