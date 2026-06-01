package com.smartcampus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartcampus.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer>{
	@Query(value = """
		    SELECT *
		    FROM company c
		    WHERE FIND_IN_SET(:branch, REPLACE(c.branchcriteria, ' ', '')) > 0
		    AND c.cgpacriteria <= :cgpa
		    AND c.backlogcriteria >= :noOfBacklog
		    """, nativeQuery = true)
		List<Company> findEligibleCompanies(
		        @Param("branch") String branch,
		        @Param("cgpa") float cgpa,
		        @Param("noOfBacklog") int noOfBacklog);
	}
