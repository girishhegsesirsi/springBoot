package com.sb.demo.controller;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.sb.demo.entity.Department;
import com.sb.demo.error.DepartmentNotFoundException;
import com.sb.demo.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private DepartmentService departmentSerice;
	private Department department;
	
	@BeforeEach
	void setUp() throws Exception {
		
		department = Department.builder()
				.departmentAddress("Bengaluru")
				.departmentCode("DEP-01")
				.departmentId(1L)
				.departmentName("IT").build();
	}

	@Test
	void testSaveDepartment() throws Exception {
		Department inputDepartment = Department.builder()
				.departmentAddress("Bengaluru")
				.departmentCode("DEP-01")
				.departmentName("IT").build();
		Mockito.when(departmentSerice.saveDepartment(inputDepartment))
		.thenReturn(department);
		
		
		 mockMvc
	        .perform(MockMvcRequestBuilders
	            .post("/departments")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content("{\r\n"
	                		+ "\r\n"
	                		+ "    \"departmentName\":\"IT\",\r\n"
	                		+ "    \"departmentAddress\":\"Bengaluru\",\r\n"
	                		+ "    \"departmentCode\":\"DEP-01\"\r\n"
	                		+ "}"
	                ))
	        .andExpect(MockMvcResultMatchers.status().isOk());
	}
	

	@Test
	void testFetchDepartmentById() throws Exception {
		Mockito.when(departmentSerice.fetchDepartmentById(1L))
		.thenReturn(department);
		
		
		 mockMvc
	        .perform(MockMvcRequestBuilders
	            .get("/departments/1")
	                .contentType(MediaType.APPLICATION_JSON))
	        .andExpect(MockMvcResultMatchers.status().isOk())
	        .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
	        		.value(department.getDepartmentName()));
	}
	

}
