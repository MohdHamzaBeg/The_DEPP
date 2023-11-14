package com.bca.springframework.bootstrap;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bca.springframework.model.Department;
import com.bca.springframework.model.Employee;
import com.bca.springframework.repository.DepartmentRepostiory;
import com.bca.springframework.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
	

	private final EmployeeRepository employeeRepository;

	private final DepartmentRepostiory departmentRepostiory;
	
	@Transactional
	@Override
	public void run(String... args) throws Exception{
		forDepartment();
		forEmployees();
		
	}
		Department dep1;
		Department dep2;
		Department dep3;
	private void forDepartment() {
		if(departmentRepostiory.count()==0) {
			dep1 = Department.builder()
					
					.name("WebDev")
					.employees(null)
					.director("Apurba")
					.datecreated(LocalDateTime.now())
					.build();
			dep2 = Department.builder()
					.name("Product Support")
					.employees(null)
					.director("Aditya")
					.datecreated(LocalDateTime.now())
					.build();
			dep3 = Department.builder()
					.name("CloudComputing")
					.employees(null)
					.director("Sunny")
					.datecreated(LocalDateTime.now())
					.build();
			dep1= departmentRepostiory.save(dep1);
			dep2 = departmentRepostiory.save(dep2);
			dep3 = departmentRepostiory.save(dep3);
		}
	}
	
	private void forEmployees() {
		if(employeeRepository.count()==0) {
			
			Employee employee1 = Employee.builder()
					.name("Hamza B")
					.email("hamza@company.com")
					.department(dep1)
					.manager("Akshay")
					.build();
			
			Employee employee2 = Employee.builder()
					.name("Faraz")
					.email("faraz@company.com")
					.department(dep2)
					.manager("Akshay")
					.build();
			
			Employee employee3 = Employee.builder()
					.name("Anushka")
					.email("anushka@company.com")
					.department(dep3)
					.manager("Rippan")
					.build();
			
			Employee employee4 = Employee.builder()
					.name("Abhi")
					.email("abhi@company.com")
					.department(dep1)
					.manager("Ranjeet")
					.build();
			
			employeeRepository.save(employee1);
			employeeRepository.save(employee2);
			employeeRepository.save(employee3);
			employeeRepository.save(employee4);
		}
		
	}
}
