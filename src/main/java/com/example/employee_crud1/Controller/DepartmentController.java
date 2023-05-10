package com.example.employee_crud1.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_crud1.entity.Department;
import com.example.employee_crud1.entity.DepartmentmodelClass;
import com.example.employee_crud1.entity.Employee;
import com.example.employee_crud1.repository.DepartmentRepository;
import com.example.employee_crud1.repository.EmployeeRepository;

@RestController
public class DepartmentController {
	  
	@Autowired
	private DepartmentRepository departmentrepo; 
	
	@Autowired
	private EmployeeRepository employeerepo;
	
	@GetMapping("/department")
	public List<Department> getDepartmentRecord()
	{
		System.out.println("Departmentgetrequest");
		return departmentrepo.findAll();
		
	}
	
	@GetMapping("/department/")
	public Department getbyId(@RequestParam("uuid")  String id)
	{
		try
		{
		Department existingDepartment=departmentrepo.findBydeptuuid(id);
		return existingDepartment;
		}
		catch(Exception e)
		{
			return null ;
		}
		
	}
	
	@PostMapping("/department")
	public String saveDepartment(@RequestBody Department department)
	{ 
		try {
		System.out.println(department.toString());
		 departmentrepo.save(department);
		 return "Sucessfully Added";
		}
		catch(Exception e)
		{
			String s=department.getDeptName();
			Department depart=departmentrepo.findByDeptName(s);
			String s1=department.getDeptHead();
			Department departs=departmentrepo.findByDeptHead(s1);
			if(depart!=null)
			{
				 return "Department name already Exist";
			} 
			else if(departs!=null)
			{ 
				return "department head already Exist"; 
			}
			else
			return "Invalid data";
		}
		
	}
	@DeleteMapping("/department/")
	public String DeletebyId(@RequestParam("uuid")  String id)
	{
		System.out.println(id);
		int a=departmentrepo.deleteBydeptuuid(id);
		if(a!=0) {
			return "Sucessfully Deleted" ;
		}
		else
		return "Not Exist" ;
	}
	
	@PutMapping("/department/") 
	public String updateByuuid(@RequestBody DepartmentmodelClass department,@RequestParam("uuid")  String id)
	{
		//System.out.println(id);
		//System.out.println(department.getDept_UUID());
		try {
	Department existingDepartment=departmentrepo.findBydeptuuid(id);
	if(department.getDeptName()!=null)
	existingDepartment.setDeptName(department.getDeptName());
	if(department.getDeptHead()!=null)
	existingDepartment.setDeptHead(department.getDeptHead()); 
	if(department.getDeptLocation()!=null)
	existingDepartment.setDeptLoaction(department.getDeptLocation());
	List<Employee> employee=department.getEmployee();
//List<Employee> employee2= new ArrayList<>();
	for(Employee employee1:employee )
	{
		int i=employee.indexOf(employee1);
		String uuid=employee1.getEmpuuid();
		Employee existingEmployee=employeerepo.findByempuuid(uuid);
		employee.set(i,existingEmployee);
	}
	existingDepartment.setEmployee(employee);
	departmentrepo.save(existingDepartment); 
	return "Sucessfully Updated";
	
		}
catch(Exception e)
	{
		return e +"";
	}
	
	}
}