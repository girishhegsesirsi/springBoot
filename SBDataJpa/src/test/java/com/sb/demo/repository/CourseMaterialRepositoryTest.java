package com.sb.demo.repository;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sb.demo.entity.Course;
import com.sb.demo.entity.CourseMaterial;
import com.sb.demo.entity.Teacher;

@SpringBootTest
class CourseMaterialRepositoryTest {
	@Autowired
private CourseMaterialRepository courseMaterialRepository;
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void saveCourseMaterialTest() {
		Teacher teacher = Teacher.builder()
				.firstName("Vidya")
				.lastName("Rani")
				.build();
		
		Course course = Course.builder()
				.title("DSA")
				.credit(6)
				.teacher(teacher)
				.build();
		
		CourseMaterial courseMaterial = CourseMaterial.builder()
				.url("www.google.com")
				.course(course)
				.build();
		
		courseMaterialRepository.save(courseMaterial);
	}
	
	@Test
	void printAllCourseMaterialTest() {
	List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
	System.out.println("CourseMaterials Available : "+courseMaterials);
	}

}
