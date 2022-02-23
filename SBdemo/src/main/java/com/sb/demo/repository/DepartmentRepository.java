package com.sb.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.demo.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

    //Spring provides implementation internally and provides default methods with the primary key
	
	
	//not a default method
	//naming convention is important, method name should start with findBy followed by variable name
	public Department findBydepartmentName (String departmentName);
}
