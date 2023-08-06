package com.fpoly.iocare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.iocare.model.Aspiration;

@Repository
public interface IAspirationDAO extends JpaRepository<Aspiration, Integer>{

}
