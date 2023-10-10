package com.bca.springframework.service;

import java.util.List;
import java.util.Optional;

import com.bca.springframework.model.Employee;

public interface EmployeeService {
	List<Employee> listofEmployees();
	
	void addEmployee(Employee employee);
	
	Optional<Employee> getEmployeebyId(long id);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployee(long id);
}
