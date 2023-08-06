package com.fpoly.iocare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.iocare.model.ListStudent;

public interface IListStudentDAO extends JpaRepository<ListStudent, String>{

}
