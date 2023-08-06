package com.fpoly.iocare.rest.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.iocare.model.Semester;
import com.fpoly.iocare.service.ISemesterService;
import com.fpoly.iocare.service.impl.SemesterServiceImpl;

@CrossOrigin("*")
@RestController
public class SemesterRestController {
	@Autowired
	ISemesterService semesterService = new SemesterServiceImpl();
	
	/*--Hiển thị tất cả học kỳ--*/
	@GetMapping("/rest/semester")
	public ResponseEntity<List<Semester>> findAll(){
		return ResponseEntity.ok(semesterService.findAll());
	}
	
	
	/*--Hiển thị 1 học kỳ dựa vào mã học kỳ--*/
	@GetMapping("/rest/semester/{semesterId}")
	public ResponseEntity<Semester> findOne(@PathVariable("semesterId") String semesterId){
		if(semesterService.existsById(semesterId)) {
			return ResponseEntity.ok(semesterService.findById(semesterId));
		}
		return ResponseEntity.notFound().build();
	}
	
	/*--Tạo mới 1 học kỳ--*/
	@PostMapping("/rest/semester")
	public ResponseEntity<Semester> post(@RequestBody Semester semester){
		System.out.println(semester.getStartTime());
		System.out.println(semester.getEndTime());
		if(semesterService.existsById(semester.getSemesterId())) {
			return ResponseEntity.badRequest().build(); // 400 bad request
		}
		semesterService.create(semester);
		return ResponseEntity.ok(semester);
	}
	
	/*--Xóa học kỳ--*/
	@DeleteMapping("/rest/semester/{semesterId}")
	public ResponseEntity<Void> delete(@PathVariable("semesterId") String semesterId){
		if(semesterService.existsById(semesterId)) {
			semesterService.deleteById(semesterId);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	/*--Update học kỳ--*/
	@PutMapping("/rest/semester/{semesterId}")
	public ResponseEntity<Semester> update(@PathVariable("semesterId") String semesterId, @RequestBody Semester semester){
		if(semesterService.existsById(semesterId)) {
			semesterService.update(semester);
			return ResponseEntity.ok(semester);
		}
		return ResponseEntity.notFound().build();
			
	}
}
