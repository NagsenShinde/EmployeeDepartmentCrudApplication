package com.example.employee_crud1.entity;

 
import java.util.UUID;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
  
@Entity(name="employee") 
public class Employee {
	 
	  @Column(name="Emp_UUID",unique=true)
	  private String empuuid =UUID.randomUUID().toString();
 
	 public String getEmpuuid() {
		return empuuid;
	}

	public void setEmpuuid(String empuuid) {
		this.empuuid = empuuid;
	}

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="Emp_ID")
	 private int empId;
	
	 @Column(name="First_Name")
	  private String firstName;
	 
	 @Column(name="Emp_DOB")
	 private String empDOB;
	 
	 @Column(name="Emp_DOJ")
	 private String empDOJ;
	 
	 @Column(name="Emp_Emailid",unique=true)
	 private String empEmailid;
	 
	 @Column(name="Emp_Mob",unique=true)
	 private long empmob;
	  
	  @Column(name="Last_Name")
	  private String lastName;
	  
	  @Column(name="Emp_Sal")
	 private int empSal;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getEmpSal() {
		return empSal;
	}

	public void setEmpSal(int empSal) {
		
		this.empSal = empSal;
	}
	public String getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(String empDOB) {
		this.empDOB = empDOB;
	}

	public String getEmpDOJ() {
		return empDOJ;
	}

	public void setEmpDOJ(String empDOJ) {
		this.empDOJ = empDOJ;
	}

	public String getEmpEmailid() {
		return empEmailid;
	}

	public void setEmpEmailid(String empEmailid) {
		this.empEmailid = empEmailid;
	}

	public long getEmpmob() {
		return empmob;
	}

	public void setEmpmob(long empmob) {
		this.empmob = empmob;
	} 
	
	
	
	  //@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	  //@JoinColumn(name="Dept_No")
	  //@JsonBackReference 
	//@Transient
	  //Department department;

	 
}