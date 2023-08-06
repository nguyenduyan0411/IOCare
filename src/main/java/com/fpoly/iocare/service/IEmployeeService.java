package com.fpoly.iocare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fpoly.iocare.model.Employee;


@Service
public interface IEmployeeService {
	Employee findById(String username);
	
	boolean existsById(String id);
	
	Employee findByEmail(String email);

	List<Employee> getAdministrators();

	List<Employee> findAll();

	Employee create(Employee Employee);

	Employee update(Employee Employee);

	Long getTotalEmployee();

}
