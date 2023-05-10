package com.example.employee_crud1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_crud1.entity.Department;
import com.example.employee_crud1.entity.Employee;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	Employee findByempuuid(String id);

	@Transactional
	int deleteByempuuid(String id);

	 

	Employee findByEmpEmailid(String s5);

	Employee findByEmpmob(long s6);

	 
}
