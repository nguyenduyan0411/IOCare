package com.fpoly.iocare.service;

import java.util.List;

import com.fpoly.iocare.model.ImportedData;

public interface IImportedDataService {
	/*--Thêm mới importedData--*/
	ImportedData create(ImportedData importedData);
	
	/*--Kiểm tra mã importedData có tồn tại hay chưa--*/
	boolean existsById(Integer id);
	
	/*--Lấy tất cả importedData--*/
	List<ImportedData> findAll();
}
