package com.bca.springframework.service;

import java.util.List;
import java.util.Optional;

import com.bca.springframework.model.Department;

public interface DepartmentService {
	List<Department> listofDepartments();
	
	void addDepartment(Department department);
	
	Optional<Department> getDepartmentbyId(long id);
	
	void updateDepartment(Department department);
	
	void deleteDepartment(long id);
	
}
