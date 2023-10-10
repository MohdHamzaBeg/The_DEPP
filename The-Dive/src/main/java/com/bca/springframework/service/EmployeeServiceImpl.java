package com.bca.springframework.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bca.springframework.model.Employee;
import com.bca.springframework.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> listofEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeebyId(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
		
	}
	
}
