package com.reactive.application.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.application.bo.EmployeeBO;
import com.reactive.application.entity.Employee;
import com.reactive.application.repo.EmployeeRepo;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	public Mono<Employee> saveEmployee(EmployeeBO employeeBO) {
		Employee employee;
		Mono<Employee> savedEmployee;
		
		employee = new Employee();
		
		
		BeanUtils.copyProperties(employeeBO, employee);

		try {
			savedEmployee = employeeRepo.save(employee);
			return savedEmployee;
		}catch(Exception e) {
				
		}
		
		return null;
	}
}
