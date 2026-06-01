package com.smartcampus.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartcampus.dto.StudentDto;
import com.smartcampus.entity.Company;
import com.smartcampus.entity.Student;
import com.smartcampus.repository.CompanyRepository;
import com.smartcampus.repository.StudentRepository;
import com.smartcampus.service.SmartCampusService;

@Service
public class SmartCampusServiceImpl implements SmartCampusService{
    @Autowired
	private StudentRepository smartcampusrepo;
    @Autowired
	private CompanyRepository Companyrepo;

	@Override
	public Student addStudent(StudentDto stddto) {
		Student student=new Student();
		student.setName(stddto.getName());
		student.setBranch(stddto.getBranch());
		student.setCgpa(stddto.getCgpa());
		student.setNo_of_backlog(stddto.getNo_of_backlog());

		    List<Company> eligibleCompanies =
		            Companyrepo.findEligibleCompanies(
		                    student.getBranch(),
		                    student.getCgpa(),
		                    student.getNo_of_backlog()
		            );

		    student.setCompanies(eligibleCompanies);

     return smartcampusrepo.save(student);
	}

	@Override
	public Company addCompany(Company comp) {
		Company company=Companyrepo.save(comp);
		return company;
	}

	@Override
	public List<Student> getStudent() {
		List<Student> liststd=smartcampusrepo.findAll();
		return liststd;
	}

	@Override
	public List<Company> getCompany() {
		List<Company> clist=Companyrepo.findAll();
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
	

}
