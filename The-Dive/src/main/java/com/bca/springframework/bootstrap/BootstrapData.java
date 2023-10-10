package com.bca.springframework.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bca.springframework.model.Employee;
import com.bca.springframework.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Transactional
@Component
public class BootstrapData implements CommandLineRunner {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception{
		forEmployees();
	}

	private void forEmployees() {
		if(employeeRepository.count()==0) {
			Employee employee1 = Employee.builder()
					.name("Hamza")
					.email("hamza@company.com")
					.department("WebDev")
					.manager("Akshay")
					.build();
			
			Employee employee2 = Employee.builder()
					.name("Faraz")
					.email("faraz@company.com")
					.department("Cloud Computing")
					.manager("Akshay")
					.build();
			
			Employee employee3 = Employee.builder()
					.name("Anushka")
					.email("anushka@company.com")
					.department("Product Support")
					.manager("Rippan")
					.build();
			
			Employee employee4 = Employee.builder()
					.name("Abhi")
					.email("abhi@company.com")
					.department("WebDev")
					.manager("Ranjeet")
					.build();
			
			employeeRepository.save(employee1);
			employeeRepository.save(employee2);
			employeeRepository.save(employee3);
			employeeRepository.save(employee4);
		}
		
	}
}
