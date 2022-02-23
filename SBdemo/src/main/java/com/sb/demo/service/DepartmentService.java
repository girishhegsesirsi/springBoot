package com.sb.demo.service;

import java.util.List;
import java.util.Optional;

import com.sb.demo.entity.Department;
import com.sb.demo.error.DepartmentNotFoundException;

public interface DepartmentService {

	Department saveDepartment(Department department);

	List<Department> fetchDepartmentList();

	Department  fetchDepartmentById(Long id) throws DepartmentNotFoundException;

	void deleteDepartmentById(Long id) throws DepartmentNotFoundException;

	Department updateDepartment(Long departmentId, Department department);

	Department fetchDepartmentByName(String departmentName);

}
