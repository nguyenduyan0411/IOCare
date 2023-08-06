package com.fpoly.iocare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.iocare.dao.IRiskClassificationDAO;
import com.fpoly.iocare.model.RiskClassification;
import com.fpoly.iocare.service.IRiskClassificationService;

@Service
public class RiskClassificationServiceImpl implements IRiskClassificationService{
	
	@Autowired
	IRiskClassificationDAO dao;
	
	/*--Hiển thị tất cả phân loại rủi ro--*/
	@Override
	public List<RiskClassification> findAll() {
		return dao.findAll();
	}
}