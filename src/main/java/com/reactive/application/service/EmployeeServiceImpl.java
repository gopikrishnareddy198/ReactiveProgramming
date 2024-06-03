package com.reactive.application.service;

import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.application.entity.Employee;
import com.reactive.application.exceptions.RecordNotSavedException;
import com.reactive.application.repo.EmployeeRepo;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService{

	
	private EmployeeRepo employeeRepo;

	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public Mono<Employee> saveEmployee(Employee employee) {
		return 
		employeeRepo.save(employee)
		.doOnError(ex-> log.error("Failed to save Employee"))
		.onErrorMap(ex->new RecordNotSavedException(ex.getMessage()));
	
	}
}
