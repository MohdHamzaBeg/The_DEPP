package com.bca.springframework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bca.springframework.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
