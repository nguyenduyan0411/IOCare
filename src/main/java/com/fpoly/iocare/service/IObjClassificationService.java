package com.fpoly.iocare.service;

import java.util.List;

import com.fpoly.iocare.model.ObjClassification;

public interface IObjClassificationService {
	/*--Hiển thị tất cả phân loại đối tượng--*/
	List<ObjClassification> findAll();
}