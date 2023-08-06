package com.fpoly.iocare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.iocare.dao.IListStudentDAO;
import com.fpoly.iocare.model.ListStudent;
import com.fpoly.iocare.service.IListStudentService;

@Service
public class ListStudentServiceImpl implements IListStudentService{
	@Autowired
	IListStudentDAO dao;

	/*--Tạo mới danh sách sinh viên tổng--*/
	@Override
	public ListStudent create(ListStudent student) {
		return dao.save(student);
	}

	/*--Kiểm tra id trong danh sách sinh viên tổng--*/
	@Override
	public boolean existsById(String studentId) {
		if(dao.existsById(studentId))
			return true;
		return false;
	}

	/*--Hiển thị tất cả danh sách sinh viên tổng--*/
	@Override
	public List<ListStudent> findAll() {
		return dao.findAll();
	}
	
	
}
