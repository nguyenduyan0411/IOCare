package com.fpoly.iocare.rest.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.iocare.model.Aspiration;
import com.fpoly.iocare.service.IAspirationService;
import com.fpoly.iocare.service.impl.AspirationServiceImpl;

@CrossOrigin("*")
@RestController
public class AspirationRestController {
	@Autowired
	IAspirationService aspirationService = new AspirationServiceImpl();
	
	/*--Hiển thị tất cả nguyện vọng--*/
	@GetMapping("/rest/aspiration")
	public ResponseEntity<List<Aspiration>> findAll(){
		return ResponseEntity.ok(aspirationService.findAll());
	}
	
}