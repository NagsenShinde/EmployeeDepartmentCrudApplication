package com.example.employee_crud1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_crud1.entity.Department;
import com.example.employee_crud1.entity.Employee;

import jakarta.transaction.Transactional;
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer>  {
  
	 
	Department findBydeptuuid(String id);


	@Transactional
	int deleteBydeptuuid(String id);


	Department findByDeptName(String s);


	Department findByDeptHead(String s1);

 
}
