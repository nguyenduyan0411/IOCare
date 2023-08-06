package com.fpoly.iocare.service;

import java.util.List;

import com.fpoly.iocare.model.RiskClassification;

public interface IRiskClassificationService {
	/*--Hiển thị tất cả phân loại rủi ro--*/
	List<RiskClassification> findAll();
}