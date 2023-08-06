package com.fpoly.iocare.service;

import java.util.List;

import com.fpoly.iocare.model.Semester;

public interface ISemesterService {
	/*--Xóa học kỳ--*/
	public void deleteById(String id);
	
	/*--Tìm kiếm học kỳ theo mã học kỳ--*/
	Semester findById(String id);
	
	/*--Hiển thị tất cả học kỳ--*/
	List<Semester> findAll();
	
	/*--Thêm mới học kỳ--*/
	Semester create(Semester semester);
	
	/*--Kiểm tra mã học kỳ có tồn tại hay chưa--*/
	boolean existsById(String id);
	
	// Update hoc ky
	Semester update(Semester semester);
}
