package com.example.employee_crud1.Controller;

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
import com.example.employee_crud1.entity.Employee;
import com.example.employee_crud1.repository.EmployeeRepository;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeerepo;
	
	@GetMapping("/employee")
	public List<Employee> getAll(){
		return employeerepo.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getbyId(@PathVariable int id)
	{
		Employee existingEmployee=employeerepo.findById(id).orElse(null);
		return existingEmployee;	
	}
	@PostMapping("/employee")
	public String saveEmployee(@RequestBody Employee employee)
	{
		try {
		String s=employee.getFirstName();
		if(s!=null)
		{
			String s2=employee.getLastName();
			if(s2!=null)
			{
				int sal=employee.getEmpSal();
				if(sal!=0) {
					 
				String s3=employee.getEmpDOB();
				if(s3!=null)
				{
					String s4=employee.getEmpDOJ();
					if(s4!=null)
					{
						String s5=employee.getEmpEmailid();
						Employee emp=employeerepo.findByEmpEmailid(s5);
						if(s5!=null && emp==null)
						{
							long s6=employee.getEmpmob();
							Employee emp2=employeerepo.findByEmpmob(s6);
							if(s6!=0 && emp2==null)
							{
								 employeerepo.save(employee);
								 return "Sucessfully Added";
							}
							else
								return "Employee Mobile no can not be Null";
						}
						else
							return "Employee EmailId can not be Null";
					}
					else 
						return "Employee Date of joining can not be null";
				}
				else
					return "Employee Date of Birth can not be Null";
				}
				else
					return "Salary " + sal+ " is not allowed";
			}
			else
				return "Last Name can not be Null";
			
		}
		else
			return "First Name can not be null";
		 
	}
		catch(Exception e)
		{
			return "Invalid";
		}
	}
	
	@DeleteMapping("/employee/")
	public String DeletebyId(@RequestParam("uuid")  String id)
	{
		System.out.println(id);
		int a=employeerepo.deleteByempuuid(id); 
		if(a!=0)
		{
			return "Sucessfully Deleted" ;
		}
		else
		return "Not Exist" ;
	}
	
	@PutMapping("/employee/") 
	public String updateByuuid(@RequestBody Employee employee,@RequestParam("uuid")  String id)
	{
		try
		{
	Employee existingEmployee=employeerepo.findByempuuid(id);
	if(employee.getEmpSal()!=0)
	existingEmployee.setEmpSal(employee.getEmpSal()); 
	if(employee.getFirstName()!=null)
	existingEmployee.setFirstName(employee.getFirstName());
	if(employee.getLastName()!=null)
	existingEmployee.setLastName(employee.getLastName());
	if(employee.getEmpmob()!=0)
	existingEmployee.setEmpmob(employee.getEmpmob());
	if(employee.getEmpEmailid()!=null)
	existingEmployee.setEmpEmailid(employee.getEmpEmailid());
	if(employee.getEmpDOB()!=null)
	existingEmployee.setEmpDOB(employee.getEmpDOB());
	if(employee.getEmpDOJ()!=null)
	existingEmployee.setEmpDOJ(employee.getEmpDOJ());
	 employeerepo.save(existingEmployee); 
	 return "Sucessfully Updated";
	}
		catch(Exception e)
		{
			return e +"";
		}
	}
}
