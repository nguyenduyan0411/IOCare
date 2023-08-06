package com.fpoly.iocare.service;

import java.util.List;

import com.fpoly.iocare.model.HistoryStudent;
import com.fpoly.iocare.model.Student;

public interface IHistoryStudentService {
	/*--Thêm mới lịch sử sinh viên--*/
	HistoryStudent create(HistoryStudent historyStudent);
	
	/*--Lấy tất cả lịch sử sinh viên--*/
	List<HistoryStudent> findAll ();
	
	HistoryStudent findById (Integer id);
	
	List<HistoryStudent> findByEmployeeId (String employeeId);
	
	/*--Cập nhật lịch sử sinh viên--*/
	HistoryStudent update(HistoryStudent historyStudent);
	
	List<HistoryStudent> getAll();
}
