package com.sb.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.sb.demo.entity.Department;

@DataJpaTest
class DepartmentRepositoryTest {
	
	@Autowired
private DepartmentRepository departmentRepository;
	@Autowired
	private TestEntityManager testEntityManager;
	
	@BeforeEach
	void setUp() throws Exception {
		
		Department department = Department.builder().departmentAddress("Bengaluru").departmentCode("DEP-05").departmentName("ME").build();
		testEntityManager.persist(department);

	}

	@Test
	void whenFindById_thenReturnDepartment() {
		String detartmentName="ME";
		Department department = departmentRepository.findById(1L).get();
		//Department department = departmentRepository.findBydepartmentName("ME");
		//System.out.println("value from DB : "+department);
		//assertEquals(detartmentName, department.getDepartmentName());
		assertEquals( department.getDepartmentName(),detartmentName);

	}

}
