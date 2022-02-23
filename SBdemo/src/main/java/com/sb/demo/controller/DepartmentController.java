package com.sb.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.demo.entity.Department;
import com.sb.demo.error.DepartmentNotFoundException;
import com.sb.demo.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("Inside saveDepartment () of DepartmentController");
		return departmentService.saveDepartment(department);
	}
	
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department) {
		LOGGER.info("Inside updateDepartment () of DepartmentController");
		return departmentService.updateDepartment(departmentId,department);
	}
	
	
	@GetMapping("/departments")
	public List<Department> getDepartment() {
		LOGGER.info("Inside getDepartment () of DepartmentController");
		return departmentService.fetchDepartmentList();
	}
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id")Long id) throws DepartmentNotFoundException {
		LOGGER.info("Inside fetchDepartmentById () of DepartmentController");
		return departmentService.fetchDepartmentById( id);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name")String departmentName) {
		LOGGER.info("Inside fetchDepartmentByName () of DepartmentController");
		return departmentService.fetchDepartmentByName( departmentName);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id")Long id) throws DepartmentNotFoundException {
		LOGGER.info("Inside deleteDepartmentById () of DepartmentController");
		 departmentService.deleteDepartmentById( id);
		 
		 return "Department deleted successfully";
	}

}
