package com.smartcampus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartcampus.dto.CompanyDto;
import com.smartcampus.dto.StudentDto;
import com.smartcampus.dto.StudentUpdateDto;
import com.smartcampus.entity.Company;
import com.smartcampus.serviceimpl.SmartCampusServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/campus")
@CrossOrigin(origins = "*")
public class SmartCampusController {
	@Autowired
	private SmartCampusServiceImpl smartcampusimpl;

	@PostMapping("/addstd")
	public ResponseEntity<String> addStudentData(@RequestBody StudentDto stddto) {
		smartcampusimpl.addStudent(stddto);
		return new ResponseEntity<>("Student data Saved!", HttpStatus.CREATED);

	}

	@PostMapping("/addcompany")
	public ResponseEntity<String> addCompanyData(@RequestBody CompanyDto compdto) {
		smartcampusimpl.addCompany(compdto);
		return new ResponseEntity<>("Campnay data Saved!", HttpStatus.CREATED);
	}

	@GetMapping("/getstd")
	public ResponseEntity<List<StudentDto>> getStudentData() {

		List<StudentDto> lstudent = smartcampusimpl.getStudent();
		return new ResponseEntity<>(lstudent, HttpStatus.OK);
	}

	@GetMapping("/getcompany")
	public ResponseEntity<List<Company>> getCompanyData() {
		List<Company> lcomp = smartcampusimpl.getCompany();
		return new ResponseEntity<>(lcomp, HttpStatus.OK);
	}

	@GetMapping("/std/{id}")
	public String getStudentCompanies(@PathVariable int id) {
		return smartcampusimpl.getStudentAndCompanies(id);
	}

	@PutMapping("/updatestd/{email}")
	public String updateStd(@PathVariable String email, StudentUpdateDto stddto) {
		return smartcampusimpl.updateStudent(email, stddto);
	}

	@PutMapping("/updatecomp/{name}")
	public String updateCompany(@PathVariable String name, CompanyDto compdto) {
		return smartcampusimpl.updateCompany(name, compdto);
	}

	@DeleteMapping("/dltcomp/{name}")
	public String deleteCompany(@PathVariable String name) {
		return smartcampusimpl.deleteCompany(name);
	}

}
