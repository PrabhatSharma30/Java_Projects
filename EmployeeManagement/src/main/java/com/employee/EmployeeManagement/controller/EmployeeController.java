package com.employee.EmployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.EmployeeManagement.model.Employee;
import com.employee.EmployeeManagement.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
//	Display the list of all employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees",employeeService.getAllEmployees());
		return "index";
	}
	
//	Take to new form for adding new employee
	@GetMapping("/newEmployeeForm")
	public String newEmployeeForm(Model model) {
	    Employee employee = new Employee();
	    model.addAttribute("employees",employee);
	    
//      it will take to the new_employee.html page
	    return "new_employee";
	}
	
//	Add new Employee
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employees") Employee employee) {
	    employeeService.saveEmployee(employee);
	    
//	    it will redirect to the home page where the path is "/"
	    return "redirect:/";
	}
	
//	Update employee details
	@GetMapping("/formForUpdate/{id}")
	public String formForUpdate(@PathVariable(value = "id") long id, Model model) {
	    Employee employee = employeeService.getEmployeeById(id);
	    model.addAttribute("employees",employee);
	    
//	    it will take to the update_employee.html page
	    return "update_employee";
	}
	
//	Delete employee
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {
	    this.employeeService.deleteEmployeeById(id);
	    
//      it will redirect to the home page where the path is "/"
	    return "redirect:/";
	}
	
}
