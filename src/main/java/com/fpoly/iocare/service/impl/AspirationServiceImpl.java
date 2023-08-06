package com.fpoly.iocare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.iocare.dao.IAspirationDAO;
import com.fpoly.iocare.model.Aspiration;
import com.fpoly.iocare.service.IAspirationService;

@Service
public class AspirationServiceImpl implements IAspirationService{
	
	@Autowired
	IAspirationDAO dao;
	
	/*--Hiển thị tất cả nguyện vọng--*/
	@Override
	public List<Aspiration> findAll() {
		return dao.findAll();
	}
}