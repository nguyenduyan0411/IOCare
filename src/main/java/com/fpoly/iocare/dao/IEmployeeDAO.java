package com.fpoly.iocare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fpoly.iocare.model.Employee;
import com.fpoly.iocare.model.Semester;

@Repository
public interface IEmployeeDAO extends JpaRepository<Employee, String>{
	@Query("Select Distinct ar.employee From Authority ar where ar.role.roleId IN ('1','2')")
	List<Employee> getAdministrators();
	
	@Query(value = "select * from Employees where employeeEmail = ?1", nativeQuery = true)
	Employee findByEmail(String email);
}
