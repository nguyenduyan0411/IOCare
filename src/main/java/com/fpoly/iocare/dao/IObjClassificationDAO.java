package com.fpoly.iocare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.iocare.model.ObjClassification;

@Repository
public interface IObjClassificationDAO extends JpaRepository<ObjClassification, Integer>{

}
