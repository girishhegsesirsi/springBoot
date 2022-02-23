package com.sb.demo.repository;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sb.demo.entity.Course;
import com.sb.demo.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	TeacherRepository teacherRepository;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void saveTeacherTest() {
		Course courseDBA = Course.builder()
				.title("DBA")
				.credit(5)
				.build();
		
		Course courseJava = Course.builder()
				.title("Java")
				.credit(6)
				.build();
		
		Teacher teacher = Teacher.builder()
				.firstName("Vidya")
				.lastName("Rani")
			//	.courses(List.of(courseDBA,courseJava))
				.build();
		teacherRepository.save(teacher);
	}

}
