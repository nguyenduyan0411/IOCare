package com.fpoly.iocare.rest.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.iocare.model.Employee;
import com.fpoly.iocare.model.ImportedData;
import com.fpoly.iocare.service.IEmployeeService;
import com.fpoly.iocare.service.IImportedDataService;
import com.fpoly.iocare.service.impl.EmployeeServiceImpl;
import com.fpoly.iocare.service.impl.ImportedDataServiceImpl;

@CrossOrigin("*")
@RestController
public class ImportedDataRestController {
	@Autowired
	IImportedDataService importedDataService = new ImportedDataServiceImpl();
	
	@Autowired
	IEmployeeService employeeService = new EmployeeServiceImpl();

	/*--tạo mới importedData--*/
	@PostMapping("/rest/imported")
	public ResponseEntity<ImportedData> post(HttpServletRequest request, @RequestBody ImportedData importedData){
		Employee emp = employeeService.findById(request.getRemoteUser());
		importedData.setEmployee(emp);
		System.out.println(importedData.getEmployee().getEmployeeId());
		importedDataService.create(importedData);
		return ResponseEntity.ok(importedData);
	}
	
	/*--Lấy tất cả importedData--*/
	@GetMapping("/rest/imported")
	public ResponseEntity<List<ImportedData>> findAll(){
		List<ImportedData> impData = importedDataService.findAll();
		if(impData.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(impData);
	}
}
