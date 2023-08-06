package com.fpoly.iocare.rest.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.iocare.model.ObjClassification;
import com.fpoly.iocare.service.IObjClassificationService;
import com.fpoly.iocare.service.impl.ObjClassificationServiceImpl;

@CrossOrigin("*")
@RestController
public class ObjClassificationRestController {
	@Autowired
	IObjClassificationService objClassificationService = new ObjClassificationServiceImpl();
	
	/*--Hiển thị tất cả phân loại đối tượng--*/
	@GetMapping("/rest/objclassification")
	public ResponseEntity<List<ObjClassification>> findAll(){
		return ResponseEntity.ok(objClassificationService.findAll()); 
	}
	
}