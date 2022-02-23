package com.sb.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.demo.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
Course findByCourseMaterialCourseMaterialId(Long Id);
}
