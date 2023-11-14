package com.bca.springframework.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bca.springframework.model.Department;

public interface DepartmentRepostiory extends JpaRepository<Department, Long>{

}
