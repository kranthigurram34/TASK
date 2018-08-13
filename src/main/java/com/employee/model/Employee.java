package com.employee.model;

import java.util.UUID;

public class Employee {
   private UUID empId;
	private String empName;
    private String designation;
	private String feedback;
	
	
	

	public Employee() {
		// TODO Auto-generated constructor stub
	}




	public UUID getEmpId() {
		return empId;
	}




	public void setEmpId(UUID empId) {
		this.empId = empId;
	}




	public String getEmpName() {
		return empName;
	}




	public void setEmpName(String empName) {
		this.empName = empName;
	}




	public String getDesignation() {
		return designation;
	}




	public void setDesignation(String designation) {
		this.designation = designation;
	}




	public String getFeedback() {
		return feedback;
	}




	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}



	
	
}
