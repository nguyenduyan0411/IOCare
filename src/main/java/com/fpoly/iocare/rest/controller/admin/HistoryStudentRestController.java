package com.fpoly.iocare.rest.controller.admin;

import java.util.ArrayList;
import java.util.Date;
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

import com.fpoly.iocare.model.HistoryStudent;
import com.fpoly.iocare.model.Student;
import com.fpoly.iocare.service.IHistoryStudentService;

@CrossOrigin("*")
@RestController
public class HistoryStudentRestController {
	@Autowired
	IHistoryStudentService historyStudentService;
	
	@GetMapping("/rest/historystudent")
	public ResponseEntity<List<HistoryStudent>> getAll(){
		List<HistoryStudent> history = historyStudentService.findAll();
		return ResponseEntity.ok(history);
	}

	/*--Lấy tất cả lịch sử sinh viên--*/
	@GetMapping("/rest/historystudent/{employeeId}")
	public ResponseEntity<List<HistoryStudent>> findAll(@PathVariable("employeeId") String employeeId) {
		try {
			List<HistoryStudent> history = historyStudentService.findByEmployeeId(employeeId);
			if (history.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(history);
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}

	}

	/*--Tạo mới 1 lịch sử mới--*/
	@PostMapping("/rest/historystudent")
	public ResponseEntity<HistoryStudent> post(@RequestBody HistoryStudent historyStudent) {
//		historyStudent.setTakeCareTime(new Date());
		System.out.println(historyStudent.getTakeCareTime());
		historyStudentService.create(historyStudent);
		return ResponseEntity.ok(historyStudent);
	}

	/*--Cập nhật student (phân công nhân sự)--*/
	@PutMapping("/rest/historystu/{historyId}")
	public ResponseEntity<HistoryStudent> update(@PathVariable("historyId") Integer historyId,
			@RequestBody HistoryStudent historyStudent) {
		System.out.println(historyId);
		historyStudent.setHistoryStudentId(historyId);
		historyStudentService.update(historyStudent);
		return ResponseEntity.ok(historyStudent);

	}
}
