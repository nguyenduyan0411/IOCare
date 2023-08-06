package com.fpoly.iocare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.iocare.dao.IImportedDataDAO;
import com.fpoly.iocare.model.ImportedData;
import com.fpoly.iocare.service.IImportedDataService;

@Service
public class ImportedDataServiceImpl implements IImportedDataService{

	@Autowired
	IImportedDataDAO dao;
	
	@Override
	public ImportedData create(ImportedData importedData) {
		ImportedData imp = new ImportedData();
		imp.setImportedFileName(importedData.getImportedFileName());
		imp.setSemester(importedData.getSemester());
		imp.setCampaign(importedData.getCampaign());
		imp.setEmployee(importedData.getEmployee());
		return dao.save(imp);
	}

	@Override
	public boolean existsById(Integer id) {
		if(dao.existsById(id))
			return true;
		return false;
	}

	@Override
	public List<ImportedData> findAll() {
		return dao.findAll();
	}

}
