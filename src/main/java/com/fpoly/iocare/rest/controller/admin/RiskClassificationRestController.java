package com.fpoly.iocare.rest.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.iocare.model.RiskClassification;
import com.fpoly.iocare.service.IRiskClassificationService;
import com.fpoly.iocare.service.impl.RiskClassificationServiceImpl;

@CrossOrigin("*")
@RestController
public class RiskClassificationRestController {
	@Autowired
	IRiskClassificationService riskclassification = new RiskClassificationServiceImpl();
	
	/*--Hiển thị tất cả phân loại rủi ro--*/
	@GetMapping("/rest/riskclassification")
	public ResponseEntity<List<RiskClassification>> findAll(){
		return ResponseEntity.ok(riskclassification.findAll());
	}
	
}