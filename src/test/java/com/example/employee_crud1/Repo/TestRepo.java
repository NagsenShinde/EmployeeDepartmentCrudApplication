package com.example.employee_crud1.Repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.employee_crud1.entity.Department;
import com.example.employee_crud1.repository.DepartmentRepository;

public class TestRepo {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Test
	public void findByLocation()
	{
		Department department=new Department();
		
		department.getDeptName();
		departmentRepository.save(department);
		Department actualResult=departmentRepository.findByDeptName("sabiz");
		assertThat(actualResult).isEqualTo(department);
		
	}

}
