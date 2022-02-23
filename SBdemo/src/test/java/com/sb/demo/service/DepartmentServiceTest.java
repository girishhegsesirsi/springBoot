package com.sb.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sb.demo.entity.Department;
import com.sb.demo.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {
	
	@Autowired
DepartmentService departmentService;
	@MockBean
DepartmentRepository departmentRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		
		Department department = Department.builder()
				.departmentAddress("Bengaluru")
				.departmentCode("DEP-01")
				.departmentId(1L)
				.departmentName("IT").build();
		
		Mockito.when(departmentRepository.findBydepartmentName("IT")).thenReturn(department);
	}

	@Test
	@DisplayName("Get data based on valid Departmentname")
void whenValidDepartmentName_ThenDepartmentShouldFound() {
		String departmentName="IT";
		
		Department found= departmentService.fetchDepartmentByName(departmentName);
		assertEquals(departmentName, found.getDepartmentName());
	}
	

/*	@Test
	void testSaveDepartment() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchDepartmentList() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchDepartmentById() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteDepartmentById() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateDepartment() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchDepartmentByName() {
		fail("Not yet implemented");
	}
	*/
}
