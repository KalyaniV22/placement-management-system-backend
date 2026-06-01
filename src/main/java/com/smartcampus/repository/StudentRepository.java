package com.smartcampus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartcampus.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
 
	
}
