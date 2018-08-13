package com.employee.services;

import java.util.List;
import java.util.UUID;


import com.employee.documents.Employee;


public interface EmployeeService {
	Employee getEmpById(UUID Id);
	List<Employee> getAllEmployee();
	Employee createEmployee(Employee employee);
	String updateEmployee(UUID ID,Employee employee);
	String deleteOneEmployee(UUID Id);
	String deleteAllEmployees();
	
	}