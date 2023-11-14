package com.bca.springframework.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bca.springframework.model.Department;
import com.bca.springframework.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
	
	private final DepartmentService departmentService;
	
	@GetMapping("/home")
	public String listofDepartments(Model model) {
		model.addAttribute("listDepartments", departmentService.listofDepartments());
		return "dindex";
	}
	
	@GetMapping("/departmentForm")
	public String departmentForm(Model model) {
		Department department = new Department();
		model.addAttribute("department", department);
		return "departmentform";
	}
	@PostMapping("/add")
	public String addDepartment(@ModelAttribute("department") Department department) {
		department.setDatecreated(LocalDateTime.now());
		departmentService.addDepartment(department);
		return "redirect:/department/home";
	}
	@GetMapping("/departmentpage/{departmentid}")
	public String departmentpage(@PathVariable("departmentid") long id, Model model) {
		model.addAttribute("department", departmentService.getDepartmentbyId(id).get());
		return "departmentpage";
	}
	@GetMapping("/updateform/{departmentid}")
	public String updateDepartment(@PathVariable("departmentid") long id, Model model) {
		model.addAttribute("department", departmentService.getDepartmentbyId(id).get());
		return "dupdateform";
	}
	@PostMapping("/update")
	public String updateDepartment(@ModelAttribute("department") Department department) {
		departmentService.updateDepartment(department);
		return "redirect:/department/home";
	}
	@GetMapping("/delete/{departmentid}")
	public String deleteEmployee(@PathVariable("departmentid") long id) {
		departmentService.deleteDepartment(id);
		return "redirect:/department/home";
	}
}
