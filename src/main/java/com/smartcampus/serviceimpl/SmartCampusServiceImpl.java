package com.smartcampus.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartcampus.dto.CompanyDto;
import com.smartcampus.dto.StudentDto;
import com.smartcampus.dto.StudentUpdateDto;
import com.smartcampus.entity.Company;
import com.smartcampus.entity.Student;
import com.smartcampus.repository.CompanyRepository;
import com.smartcampus.repository.StudentRepository;
import com.smartcampus.service.SmartCampusService;

@Service
public class SmartCampusServiceImpl implements SmartCampusService {
	@Autowired
	private StudentRepository smartcampusrepo;
	@Autowired
	private CompanyRepository Companyrepo;

	@Override
	public Student addStudent(StudentDto stddto) {
		Student student = new Student();
		student.setName(stddto.getName());
		student.setBranch(stddto.getBranch());
		student.setCgpa(stddto.getCgpa());
		student.setNo_of_backlog(stddto.getNo_of_backlog());
		student.setEmail(stddto.getEmail());
		List<Company> eligibleCompanies = Companyrepo.findEligibleCompanies(student.getBranch(), student.getCgpa(),
				student.getNo_of_backlog());

		student.setCompanies(eligibleCompanies);
		 if (smartcampusrepo.existsByEmail(student.getEmail())) {
			throw new RuntimeException("Email already exists!");
		} 
		return smartcampusrepo.save(student);
	}

	@Override
	public Company addCompany(CompanyDto compdto) {
		Company comp = new Company();
		comp.setName(compdto.getName());
		comp.setBacklogcriteria(compdto.getBacklogcriteria());
		comp.setBranchcriteria(compdto.getBranchcriteria());
		comp.setCgpacriteria(compdto.getCgpacriteria());
		return Companyrepo.save(comp);
	}

	@Override
	public List<StudentDto> getStudent() {
		List<Student> std = smartcampusrepo.findAll();
		StudentDto stddto=new StudentDto();
		List<StudentDto> lstddto=new ArrayList<>();
		for(Student s : std) {
			stddto.setName(s.getName());
			stddto.setBranch(s.getBranch());
			stddto.setCgpa(s.getCgpa());
			stddto.setNo_of_backlog(s.getNo_of_backlog());
			stddto.setEmail(s.getEmail());
			lstddto.add(stddto);
		}
		return lstddto;
	}

	@Override
	public List<Company> getCompany() {
		List<Company> clist = Companyrepo.findAll();
		return clist;
	}

	public String getStudentAndCompanies(int studentId) {
		Student student = smartcampusrepo.findById(studentId)
				.orElseThrow(() -> new RuntimeException("Student not found"));
    String result = "Student Name: " + student.getName() + "\nCompanies: ";

		for (Company company : student.getCompanies()) {
			result += company.getName() + " ";
		}

		return result;
	}

	public String updateStudent(String email, StudentUpdateDto stddto) {
		Student existing = smartcampusrepo.findByEmail(email);
		existing.setName(stddto.getName());
		existing.setBranch(stddto.getBranch());
		existing.setCgpa(stddto.getCgpa());
		existing.setNo_of_backlog(stddto.getNo_of_backlog());
		smartcampusrepo.save(existing);
		String msg = "student updated";
		return msg;
	}

	public String updateCompany(String name, CompanyDto compdto) {
		Company comp = Companyrepo.findByName(name);
		comp.setName(compdto.getName());
		comp.setBacklogcriteria(compdto.getBacklogcriteria());
		comp.setBranchcriteria(compdto.getBranchcriteria());
		comp.setCgpacriteria(compdto.getCgpacriteria());
		Companyrepo.save(comp);
		String msg = "COMPANY UPDATED!";
		return msg;
	}

	public String deleteCompany(String name) {
		Company comp = Companyrepo.findByName(name);
		Companyrepo.delete(comp);
		return "COMPANY DELERED!";
	}

}
