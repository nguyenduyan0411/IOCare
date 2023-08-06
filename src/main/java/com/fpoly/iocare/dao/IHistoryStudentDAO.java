package com.fpoly.iocare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fpoly.iocare.model.HistoryStudent;



public interface IHistoryStudentDAO extends JpaRepository<HistoryStudent, Integer>{

	/*--Lấy tất cả sinh viên đã được phân công nhân sự--*/
	@Query(value = "select * from Historystudent where EmployeeId = ?1", nativeQuery = true)
	List<HistoryStudent> findByEmployeeId(String employeeId);

}
