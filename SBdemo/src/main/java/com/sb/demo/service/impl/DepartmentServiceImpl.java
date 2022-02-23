package com.sb.demo.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.demo.entity.Department;
import com.sb.demo.error.DepartmentNotFoundException;
import com.sb.demo.repository.DepartmentRepository;
import com.sb.demo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
		
	}
	@Override
	public List<Department> fetchDepartmentList() {
	
		return departmentRepository.findAll();
	}
	@Override
	public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {
		
		Optional<Department> dep = departmentRepository.findById(id);
		
		if (!dep.isPresent()) {
			throw new DepartmentNotFoundException("Department not available");
		}
		return dep.get();
	}
	@Override
	public void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		 departmentRepository.delete(fetchDepartmentById(departmentId));;
	}
	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		Department depDB = departmentRepository.getById(departmentId);
		
		if (Objects.nonNull(department.getDepartmentName())&&
				!"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}
		if (Objects.nonNull(department.getDepartmentAddress())&&
				!"".equalsIgnoreCase(department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		if (Objects.nonNull(department.getDepartmentCode())&&
				!"".equalsIgnoreCase(department.getDepartmentCode())) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}
		return departmentRepository.save(depDB);
	}
	@Override
	public Department fetchDepartmentByName(String departmentName) {
		// TODO Auto-generated method stub
		return departmentRepository.findBydepartmentName(departmentName);
	}

}
