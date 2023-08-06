package com.fpoly.iocare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.iocare.dao.ISemesterDAO;
import com.fpoly.iocare.model.Semester;
import com.fpoly.iocare.service.ISemesterService;

@Service
public class SemesterServiceImpl implements ISemesterService{
	
	@Autowired
	ISemesterDAO dao;

	/*--Thêm mới học kỳ--*/
	@Override
	public Semester create(Semester semester) {
		return dao.save(semester);
	}

	/*--Kiểm tra mã học kỳ có tồn tại hay chưa--*/
	@Override
	public boolean existsById(String id) {
		if(dao.existsById(id)) 
			return true;
		return false;
	}

	/*--Hiển thị tất cả học kỳ--*/
	@Override
	public List<Semester> findAll() {
		return dao.findAll();
	}

	/*--Tìm kiếm học kỳ theo mã học kỳ--*/
	@Override
	public Semester findById(String id) {
		return dao.findById(id).get();
	}

	/*--Xóa học kỳ--*/
	@Override
	public void deleteById(String id) {
		dao.deleteById(id);
	}
	/*--Update hoc ky--*/
	@Override
	public Semester update(Semester semester) {
		return dao.save(semester);
	}
}
