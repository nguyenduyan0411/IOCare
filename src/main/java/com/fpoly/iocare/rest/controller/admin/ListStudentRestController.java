package com.fpoly.iocare.rest.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.iocare.model.ListStudent;
import com.fpoly.iocare.service.IListStudentService;
import com.fpoly.iocare.service.impl.ListStudentServiceImpl;

@CrossOrigin("*")
@RestController
public class ListStudentRestController {
	@Autowired
	IListStudentService listStudentService = new ListStudentServiceImpl();
	
	@PostMapping("/rest/list-student")
	public ResponseEntity<ListStudent> post(@RequestBody ListStudent listStudent){
		if(listStudentService.existsById(listStudent.getStudentId())) {
			return ResponseEntity.badRequest().build();
		}
		listStudentService.create(listStudent);
		return ResponseEntity.ok(listStudent);
	}
	
	@GetMapping("/rest/list-student")
	public ResponseEntity<List<ListStudent>> findAll(){
		List<ListStudent> listStudent = listStudentService.findAll();
		if(listStudent.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listStudent);
	}
}
