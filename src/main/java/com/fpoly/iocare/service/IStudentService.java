package com.fpoly.iocare.service;

import java.util.List;

import com.fpoly.iocare.model.Student;

public interface IStudentService {
	/*--Thêm mới student--*/
	Student create(Student student);

	/*--Kiểm tra mã student có tồn tại hay chưa--*/
	boolean existsById(String studentId);
	
	/*--Lấy tất cả sinh viên--*/
	List<Student> findAll(String importFileName);
	
	List<Student> findNotNull();
	
	/*--Lấy tất cả sinh viên đã được phân công nhân sự--*/
	List<Student> findByEmployeeId(String employeeId);
	
	/*--Cập nhật student (phân công nhân sự)--*/
	Student update(Student student);
}
