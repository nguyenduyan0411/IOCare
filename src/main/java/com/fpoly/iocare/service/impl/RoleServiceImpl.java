package com.fpoly.iocare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.fpoly.iocare.dao.IRoleDAO;
import com.fpoly.iocare.model.Role;
import com.fpoly.iocare.service.IRoleService;


@Service
public class RoleServiceImpl implements IRoleService{
	
	@Autowired
	IRoleDAO dao;

	@Autowired
	BCryptPasswordEncoder pe;
	
	@Override
	public List<Role> findAll() {
		return dao.findAll();
	}
}