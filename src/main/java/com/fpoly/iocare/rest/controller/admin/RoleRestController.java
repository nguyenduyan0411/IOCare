package com.fpoly.iocare.rest.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.iocare.model.Role;
import com.fpoly.iocare.service.IRoleService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class RoleRestController {
	@Autowired
	IRoleService roleService;
	
	@GetMapping
	public List<Role> getAll(){
		return roleService.findAll();
	}
}