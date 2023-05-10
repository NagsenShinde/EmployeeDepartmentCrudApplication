package com.example.employee_crud1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class EmployeecrudApplicatin1ApplicationTests {
 
	Tests test=new Tests();
	
	@Test
	void contextLoads() {
		
	}
	
	@Test
	public void sum()
	{
		int exceptedResult=10;
		int actualResult=test.add(5, 5);   
		assertThat(actualResult).isEqualTo(exceptedResult);
	}
    
	@Test
	public void product()
	{
		int expectedResult=25;
		int actualResult=test.product(5, 5);
		assertThat(actualResult).isEqualTo(expectedResult);
	}
	@Test
	//@Disabled
	public void Comapred()
	{
		boolean actualRsult=test.comapare(5, 5);
		assertThat(actualRsult).isTrue();
	}
}
