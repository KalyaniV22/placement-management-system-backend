package com.smartcampus.service;

import java.util.List;

import com.smartcampus.dto.CompanyDto;
import com.smartcampus.dto.StudentDto;
import com.smartcampus.entity.Company;
import com.smartcampus.entity.Student;

public interface SmartCampusService {

	public abstract Student addStudent(StudentDto stddto);

	public abstract Company addCompany(CompanyDto compdto);

	public abstract List<StudentDto> getStudent();

	public abstract List<Company> getCompany();

}
