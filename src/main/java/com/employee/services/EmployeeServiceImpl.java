package com.employee.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.documents.Employee;
import com.employee.repositories.EmployeeRepository;


@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}
	
	@Override
	public Employee getEmpById(UUID Id) {
		return empRepo.findByEmpId(Id);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return empRepo.insert(employee);
	}
	
	@Override
	public String updateEmployee(UUID Id, Employee employee) {
		Employee employeeData = empRepo.findByEmpId(Id);
		if (Id == null) {
			return "Employee Not Found";
		}
		employeeData.setEmpName(employee.getEmpName());
		employeeData.setDesignation(employee.getDesignation());
		employeeData.setFeedback(employee.getFeedback());
		empRepo.save(employeeData);
		
		return "Employee Details Updated Successfully!";
	}


	@Override
	public String deleteOneEmployee(UUID Id) {
		empRepo.deleteById(Id);
		return "Employee has been Deleted!";
	}

	@Override
	public String deleteAllEmployees() {
		empRepo.deleteAll();
		return "All Employees have been Deleted!";
	}
}