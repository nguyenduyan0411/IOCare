package com.fpoly.iocare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.iocare.dao.IListStudentDAO;
import com.fpoly.iocare.dao.IObjClassificationDAO;
import com.fpoly.iocare.dao.ISemesterDAO;
import com.fpoly.iocare.dao.IStudentDAO;
import com.fpoly.iocare.model.ListStudent;
import com.fpoly.iocare.model.ObjClassification;
import com.fpoly.iocare.model.Student;
import com.fpoly.iocare.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	IStudentDAO dao;
	
	@Autowired
	IListStudentDAO listStudentDao;
	
	@Autowired
	IObjClassificationDAO objDao;
	
	@Autowired
	ISemesterDAO semesterDao;

	@Override
	public Student create(Student student) {
		ListStudent listStudent = listStudentDao.findById(student.getStudentId()).get();
		student.setStudentName(listStudent.getFullname());
		ObjClassification obj = objDao.findById(1).get();	
		student.setObjClassifications(obj);
		return dao.save(student);
	}

	@Override
	public boolean existsById(String id) {
		if(dao.existsById(id))
			return true;
		return false;
	}

	/*--Hiển thị tất cả sinh viên--*/
	@Override
	public List<Student> findAll(String importFileName) {
		return dao.findAll(importFileName);
	}

	/*--Cập nhật student (phân công nhân sự)--*/
	@Override
	public Student update(Student student) {
		return dao.save(student);
	}

	@Override
	public List<Student> findNotNull() {
		return dao.findNotNull();
	}
	
	/*--Hiển thị tất cả sinh viên đã được phân công nhân sự--*/
	@Override
	public List<Student> findByEmployeeId(String employeeId) {
		return dao.findByEmployeeId(employeeId);
	}
	
}
