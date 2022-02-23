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
class CourseRepositoryTest {
	
	@Autowired
private CourseRepository courseRepository;
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void printCoursesTest() {
		
	List<Course>courses= courseRepository.findAll();
	System.out.println("Available Courses: "+courses);
	}
	@Test
	void saveCoursesTest() {

			Teacher teacher = Teacher.builder()
					.firstName("Vighesh")
					.lastName("Upadhya")
					.build();
			
			CourseMaterial courseMaterial = CourseMaterial.builder()
					.url("www.google.com")
					.build();
			
			Course course = Course.builder()
					.title("CS")
					.credit(6)
					.teacher(teacher)
					.courseMaretial(courseMaterial)
					.build();
			
			
			
			
	 courseRepository.save(course);
	
	}
}
