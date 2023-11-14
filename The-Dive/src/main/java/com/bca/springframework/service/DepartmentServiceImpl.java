package com.bca.springframework.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bca.springframework.model.Department;
import com.bca.springframework.repository.DepartmentRepostiory;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepostiory departmentRepostiory;

	@Override
	public List<Department> listofDepartments() {
		return departmentRepostiory.findAll();
	}

	@Override
	public void addDepartment(Department department) {
		departmentRepostiory.save(department);
		
	}

	@Override
	public Optional<Department> getDepartmentbyId(long id) {
		Optional<Department> department = departmentRepostiory.findById(id);
		return department;
	}

	@Override
	public void updateDepartment(Department department) {
		departmentRepostiory.save(department);
		
	}

	@Override
	public void deleteDepartment(long id) {
		departmentRepostiory.deleteById(id);
		
	}
	
	
}
