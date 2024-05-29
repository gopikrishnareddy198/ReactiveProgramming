package com.reactive.application.service;

import com.reactive.application.bo.EmployeeBO;
import com.reactive.application.entity.Employee;

import reactor.core.publisher.Mono;

public interface IEmployeeService {
	Mono<Employee> saveEmployee(EmployeeBO employeeBO);
}
