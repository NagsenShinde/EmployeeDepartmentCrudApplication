package com.example.employee_crud1.entity;

import java.util.List;

public class DepartmentmodelClass {
	
	 private String deptLocation;
	
	private String deptHead;
	
	private String deptName;

	public String getDeptLocation() {
		return deptLocation;
	}

	public void setDeptLocation(String deptLocation) {
		this.deptLocation = deptLocation;
	}

	public String getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	private List<Employee> employee;

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
}
