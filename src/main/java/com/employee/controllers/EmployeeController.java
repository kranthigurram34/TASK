package com.employee.controllers;


import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.documents.Employee;


import com.employee.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	Employee employee;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() { 
		return empService.getAllEmployee();
	}
	@GetMapping("/employee/{empId}")
	public Employee getOneEmployee(@PathVariable String empId) {
		UUID Id=UUID.fromString(empId);
		return empService.getEmpById(Id);
	} 
	@PostMapping("/employee/create")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		employee.setEmpId(UUID.randomUUID());
		return empService.createEmployee(employee);
	}
	
	@RequestMapping(value="/employee/{empId}", method=RequestMethod.PUT)
	public String updateEmployee(@PathVariable String empId, @RequestBody Employee employee) { 
		UUID Id=UUID.fromString(empId);
		empService.updateEmployee(Id, employee);
		return "Employee Details Updated Successfully!";
	}
 
	@DeleteMapping("/employee/{empId}")
	public String deleteEmployee(@PathVariable String empId) {
		UUID Id=UUID.fromString(empId);
		empService.deleteOneEmployee(Id);
		return "Employee has been deleted!";
	}
	
	@DeleteMapping("/employee/delete")
	public String deleteAllEmployees() {
		empService.deleteAllEmployees();	
		return "All Employees have been deleted!";
	}	
}

	
		
	
	
/*@RequestMapping(value="/update",method=RequestMethod.PUT)
public String update(@ModelAttribute Vendor vendor) {
	vendorrep.save(vendor);
	return "Html_pages/update";
}*/
