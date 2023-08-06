package com.fpoly.iocare.rest.controller.admin;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.iocare.model.Authority;
import com.fpoly.iocare.model.Employee;
import com.fpoly.iocare.model.Role;
import com.fpoly.iocare.service.IAuthorityService;
import com.fpoly.iocare.service.IEmployeeService;

@CrossOrigin("*")
@RestController
public class EmployeeRestController {
	@Autowired
	IEmployeeService employeeService;
	
	@Autowired
	BCryptPasswordEncoder pe;
	@Autowired
	IAuthorityService authorityService;
	
	
	@GetMapping("/rest/employees")
	public List<Employee> getEmployees(@RequestParam("admin") Optional<Boolean> admin){
		if(admin.orElse(false)) {
			return employeeService.getAdministrators();
		}
		return employeeService.findAll();
	}
	
	@PostMapping("/rest/employee")
	public ResponseEntity<Employee> post(@RequestBody Employee employee){

		if(employeeService.existsById(employee.getEmployeeId())){
			return ResponseEntity.badRequest().build();
		}

		String password = pe.encode(employee.getEmployeePassword());
		employee.setEmployeePassword(password);
		employeeService.create(employee);
		
		Authority authority = new Authority();
		authority.setEmployee(employee);
		Role role = new Role();
		// set role mặc định tùy vào cách đặt trong DB
		role.setRoleId("2");
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		authority.setRole(role);
		
		authorityService.create(authority);
		return ResponseEntity.ok(employee);
	}
	
	@GetMapping("/rest/employee/{employeeId}")
	public Employee getEmployee(@PathVariable("employeeId") String employeeId){
		return employeeService.findById(employeeId);
	}
	
}