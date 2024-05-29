package com.reactive.application.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.reactive.application.entity.Employee;

@Repository
public interface EmployeeRepo extends ReactiveCrudRepository<Employee, Integer>{

}
