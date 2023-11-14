package com.bca.springframework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bca.springframework.model.Department;
import com.bca.springframework.model.Employee;
import com.bca.springframework.service.DepartmentService;
import com.bca.springframework.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	private final DepartmentService departmentService;
	
	@GetMapping("/list")
	public String listofEmployees(Model model) {
		model.addAttribute("listEmployees", employeeService.listofEmployees());
		return "empindex";
	}
	
	@GetMapping("/employeeForm")
	public String employeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("departments", departmentService.listofDepartments());
		model.addAttribute("employee", employee); // Adding the empty employee attribute to the model 
		return "employeeform"; // so that the form data can be binded to this object using the key "employee"
	}
		
	@PostMapping("/add")
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.addEmployee(employee);
		return "redirect:/employee/home";
	}
	@GetMapping("/employeepage/{employeeid}")
	public String employeepage(@PathVariable("employeeid") long id,Model model) {
		model.addAttribute("employee", employeeService.getEmployeebyId(id).get());
		return "employeepage";
	}
	@GetMapping("/updateform/{employeeid}")
	public String updatepage(@PathVariable("employeeid") long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeebyId(id).get());
		model.addAttribute("departments", departmentService.listofDepartments());
		return "empupdateform";
	}
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.updateEmployee(employee);
		return "redirect:/employee/home";
	}
	@GetMapping("/delete/{employeeid}")
	public String deleteEmployee(@PathVariable("employeeid") long id ) {
		employeeService.deleteEmployee(id);
		return  "redirect:/employee/home";
	}
	
}
