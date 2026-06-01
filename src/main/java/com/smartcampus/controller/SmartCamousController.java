package com.smartcampus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartcampus.dto.StudentDto;
import com.smartcampus.entity.Company;
import com.smartcampus.entity.Student;
import com.smartcampus.serviceimpl.SmartCampusServiceImpl;


@RestController
@RequestMapping("/campus")
public class SmartCamousController {
    @Autowired
	private SmartCampusServiceImpl smartcampusimpl;
    
     
	@PostMapping("/addstd")
	public ResponseEntity<String> addStudentData(@RequestBody StudentDto stddto){
		smartcampusimpl.addStudent(stddto);
	return new ResponseEntity<>("Student data Saved!",HttpStatus.CREATED);
		
	}
	@PostMapping("/addcompany")
	public ResponseEntity<String> addCompanyData(@RequestBody Company comp){
		smartcampusimpl.addCompany(comp);
		return new ResponseEntity<>("Campnay data Saved!",HttpStatus.CREATED);
	}
	@GetMapping("/getstd")
	public ResponseEntity<List<Student>> getStudentData(){
		
		List<Student> lstudent=smartcampusimpl.getStudent();
	return new ResponseEntity<>(lstudent,HttpStatus.OK);
		}
	
	@GetMapping("/getcompany")
	public ResponseEntity<List<Company>> getCompanyData(){
		List<Company> lcomp=smartcampusimpl.getCompany();
		return new ResponseEntity<>(lcomp,HttpStatus.OK);
	}
	@GetMapping("/std/{id}")
	public String getStudentCompanies(@PathVariable int id) {
	    return smartcampusimpl.getStudentAndCompanies(id);
	}
	
	}	
