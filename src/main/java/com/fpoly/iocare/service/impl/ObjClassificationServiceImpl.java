package com.fpoly.iocare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.iocare.dao.IObjClassificationDAO;
import com.fpoly.iocare.model.ObjClassification;
import com.fpoly.iocare.service.IObjClassificationService;

@Service
public class ObjClassificationServiceImpl implements IObjClassificationService{
	
	@Autowired
	IObjClassificationDAO dao;
	
	/*--Hiển thị tất cả phân loại đối tượng--*/
	@Override
	public List<ObjClassification> findAll() {
		return dao.findAll();
	}
}