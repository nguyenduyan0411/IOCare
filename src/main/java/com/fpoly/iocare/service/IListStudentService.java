package com.fpoly.iocare.service;

import java.util.List;

import com.fpoly.iocare.model.ListStudent;


public interface IListStudentService {
	/*--Thêm mới student--*/
	ListStudent create(ListStudent student);

	/*--Kiểm tra mã student có tồn tại hay chưa--*/
	boolean existsById(String studentId);
	
	/*--Lấy tất cả sinh viên--*/
	List<ListStudent> findAll();
}
