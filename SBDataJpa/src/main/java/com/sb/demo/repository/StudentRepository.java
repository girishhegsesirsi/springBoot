package com.sb.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sb.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	public List<Student> findByFirstName (String firstName);
	public List<Student> findByFirstNameContains (String name);
	public List<Student> findByFirstNameAndLastName (String firstName,String lastName);
	public List<Student> findByLastNameNotNull ();
	public List<Student> findByGuardianName(String name);
	
	//JPQL
	@Query("select s from Student s where s.emailId=?1")
	public List<Student> getStudentByEmailAddress(String emailId);
	
	@Query(value="select * from schooldb.tbl_student  where email_address =?1", nativeQuery=true)
	public List<Student> getStudentByEmailAddressNative(String emailId);
	
	@Query(value="select * from schooldb.tbl_student  where email_address =:email", nativeQuery=true)
	public List<Student> getStudentByEmailAddressNativeNamedParam(@Param("email")String emailId);
	
	@Transactional
	@Modifying
	@Query(value="update schooldb.tbl_student  set first_name=?1 where email_address =?2", nativeQuery=true)
	public int updateStudentNameByEmailId(String firstName, String emailId);
}
