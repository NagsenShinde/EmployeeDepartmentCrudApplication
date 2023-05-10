package com.example.employee_crud1.entity;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name="department")
public class Department {
 
	@Column(name="Dept_UUID",unique=true)
    private String deptuuid=UUID.randomUUID().toString();	 
	 
	
	public String getDeptuuid() {
		return deptuuid;
	}

	public void setDeptuuid(String deptuuid) {
		this.deptuuid = deptuuid;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Dept_No")
	private int deptNo;
	
	@Column(name="Dept_Loaction")
	private String deptLoaction;
	
	@Column(name="Dept_Name",unique=true)
	private String deptName;
	

	@Column(name="Dept_Head",unique=true)
	private String deptHead;
 

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptLoaction() {
		return deptLoaction;
	}

	public void setDeptLoaction(String deptLoaction) {
		this.deptLoaction = deptLoaction;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}
	
	//@JsonManagedReference
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},targetEntity=Employee.class)
	@JoinColumn(name="Dept_No",referencedColumnName ="Dept_No")
	private List<Employee> employee;

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		
		if(this.employee == null) {
			this.employee = new ArrayList<>();
		}
		this.employee.addAll(employee);
	}

	}