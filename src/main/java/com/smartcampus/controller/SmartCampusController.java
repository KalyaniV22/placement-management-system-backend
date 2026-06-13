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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartcampus.dto.CompanyDto;
import com.smartcampus.dto.CompanyEligibilityDto;
import com.smartcampus.dto.EligibleStudentDto;
import com.smartcampus.dto.StudentDto;
import com.smartcampus.dto.StudentUpdateDto;
import com.smartcampus.entity.Company;
import com.smartcampus.serviceimpl.SmartCampusServiceImpl;

@RestController
@RequestMapping("/campus")
@CrossOrigin(origins = "*")
public class SmartCampusController {
	@Autowired
	private SmartCampusServiceImpl smartcampusimpl;

	@PostMapping("/add-student")
	public ResponseEntity<String> addStudentData(@RequestBody StudentDto stddto) {
		smartcampusimpl.addStudent(stddto);
		return new ResponseEntity<>("Student data Saved!", HttpStatus.CREATED);

	}

	@PostMapping("/add-company")
	public ResponseEntity<String> addCompanyData(@RequestBody CompanyDto compdto) {
		smartcampusimpl.addCompany(compdto);
		return new ResponseEntity<>("Campnay data Saved!", HttpStatus.CREATED);
	}

	@GetMapping("/view-student")
	public ResponseEntity<List<StudentDto>> getStudentData() {

		List<StudentDto> lstudent = smartcampusimpl.getStudent();
		return new ResponseEntity<>(lstudent, HttpStatus.OK);
	}

	@GetMapping("/view-companies")
	public ResponseEntity<List<Company>> getCompanyData() {
		List<Company> lcomp = smartcampusimpl.getCompany();
		return new ResponseEntity<>(lcomp, HttpStatus.OK);
	}

	@GetMapping("/view-studentbyid/{id}")
	public String getStudentCompanies(@PathVariable int id) {
		return smartcampusimpl.getStudentAndCompanies(id);
	}

	@PutMapping("/update-student/{email}")
	public String updateStd(@PathVariable String email, StudentUpdateDto stddto) {
		return smartcampusimpl.updateStudent(email, stddto);
	}

	@PutMapping("/update-company/{name}")
	public String updateCompany(@PathVariable String name, CompanyDto compdto) {
		return smartcampusimpl.updateCompany(name, compdto);
	}

	@DeleteMapping("/delete-company/{name}")
	public String deleteCompany(@PathVariable String name) {
		return smartcampusimpl.deleteCompany(name);
	}
	@GetMapping("/view-eligiblecompany/{name}")
	public List<EligibleStudentDto> getcompstudent(@PathVariable String name) {
		return smartcampusimpl.getEligibleStudents(name);
	}
	
	@GetMapping("/eligibility-dashboard")
	public CompanyEligibilityDto getDashboard(String name) {
	    return smartcampusimpl.getCompanyEligibility(name);
	}

}
