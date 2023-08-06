package com.fpoly.iocare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.iocare.model.ImportedData;

public interface IImportedDataDAO extends JpaRepository<ImportedData, Integer>{

}
