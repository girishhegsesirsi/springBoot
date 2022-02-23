package com.sb.demo.repository;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sb.demo.entity.Guardian;
import com.sb.demo.entity.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;	
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		
	}

	@Test
	public void saveStudent() {
	Student student = Student.builder()
			.emailId("nik@gmail.com")
			.firstName("Nikhil")
			.lastName("Hegde")
			//.guardianName("Mahesh")
			//.guardianEmail("mahi@gmail.com")
			//.guardianMobile("9876543210")
			.build();
	
	studentRepository.save(student);
					
	}
	
	@Test
	public void saveStudentWithGuardian() {
		Guardian guardian = Guardian.builder()
				.name("Suresh")
				.email("suresh@gmail.com")
				.mobile("8976543211")
				.build();
						
	Student student = Student.builder()
			.emailId("hema@gmail.com")
			.firstName("Hema")
			.lastName("YG")
            .guardian(guardian)
			.build();
	
	studentRepository.save(student);
					
	}
	
	
@Test
public void printAllStudents()
{
	List<Student> studentList = studentRepository.findAll();
	System.out.println("Student List : "+studentList);
	}

@Test
public void printStudentByFirstName()
    {
	List<Student> studentList = studentRepository.findByFirstName("Hema");
	System.out.println("Student List : "+studentList);
	}
@Test
public void printStudentByMatchingFirstName()
    {
	List<Student> studentList = studentRepository.findByFirstNameContains("a");
	System.out.println("Student List : "+studentList);
	}
@Test
public void printStudentByFirstNameAndLastName()
    {
	List<Student> studentList = studentRepository.findByFirstNameAndLastName("Hema","YG");
	System.out.println("Student List : "+studentList);
	}
@Test
public void printfindByLastNameNotNull()
    {
	List<Student> studentList = studentRepository.findByLastNameNotNull();
	System.out.println("Student List : "+studentList);
	}
@Test
public void printfindByGuardianName()
    {
	List<Student> studentList = studentRepository.findByGuardianName("mahesh");
	System.out.println("Student List : "+studentList);
	}

@Test
public void printStudentByEmailAddress()
    {
	List<Student> studentList = studentRepository.getStudentByEmailAddress("hema@gmail.com");
	System.out.println("Student List : "+studentList);
	}

@Test
public void printStudentByEmailAddressNative()
    {
	List<Student> studentList = studentRepository.getStudentByEmailAddressNative("hema@gmail.com");
	System.out.println("Student List : "+studentList);
	}


@Test
public void printStudentByEmailAddressNativeNamedParam()
    {
	List<Student> studentList = studentRepository.getStudentByEmailAddressNativeNamedParam("hema@gmail.com");
	System.out.println("Student List : "+studentList);
	}

@Test
public void testupdateStudentNameByEmailId()
    {
	int status = studentRepository.updateStudentNameByEmailId("nikhil","nik@gmail.com");
	System.out.println("update Status : "+status);
	}
}
