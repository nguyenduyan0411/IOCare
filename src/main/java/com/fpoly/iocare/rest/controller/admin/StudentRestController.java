package com.fpoly.iocare.rest.controller.admin;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.iocare.model.Student;
import com.fpoly.iocare.service.IStudentService;
import com.fpoly.iocare.service.impl.StudentServiceImpl;

@CrossOrigin("*")
@RestController
public class StudentRestController {
	@Autowired
	IStudentService studentService = new StudentServiceImpl();
	
	/*--Import students--*/
	@PostMapping("/rest/student")
	public ResponseEntity<Student> post(@RequestBody Student student){
		if(studentService.existsById(student.getStudentId())) {
			System.out.println(student.getStudentId());
			return ResponseEntity.badRequest().build();
		}
		studentService.create(student);
		return ResponseEntity.ok(student);
	}
	
	/*--Lấy tất cả sinh viên--*/
	@GetMapping("/rest/student/{importedFileName}")
	public ResponseEntity<List<Student>> findAll(@PathVariable("importedFileName") String importedFileName){
		List<Student> students = studentService.findAll(importedFileName);
		if(students.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(students);
	}
	
	@GetMapping("/rest/student2")
	public ResponseEntity<List<Student>> findNotNull(){
		List<Student> students = studentService.findNotNull();
		if(students.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(students);
	}
	
	/*--Lấy tất cả sinh viên theo nhân sự--*/
	@GetMapping("/rest/studentforem/{employeeId}")
	public ResponseEntity<List<Student>> findByEmployeeId(@PathVariable("employeeId") String employeeId) {
		
		List<Student> students = studentService.findByEmployeeId(employeeId);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(students);
	}
	
	/*--Cập nhật student (phân công nhân sự)--*/
	@PutMapping("/rest/student/{studentId}")
	public ResponseEntity<Student> update (@PathVariable("studentId") String studentId, @RequestBody Student student){
		if(studentService.existsById(studentId)) {
			studentService.update(student);
			return ResponseEntity.ok(student);
		}
		return ResponseEntity.notFound().build();
	}
}
