package com.fpoly.iocare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.iocare.dao.IEmployeeDAO;
import com.fpoly.iocare.model.Employee;
import com.fpoly.iocare.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	@Autowired private IEmployeeDAO accDao;

	@Override
	public Employee findById(String username) {
		return accDao.findById(username).get();
	}
	
	@Override
	public Employee findByEmail(String email) {
		return accDao.findByEmail(email);
	}

	@Override
	public List<Employee> getAdministrators() {
		return accDao.getAdministrators();
	}

	@Override
	public List<Employee> findAll() {
		return accDao.findAll();
	}

	@Override
	public Employee create(Employee Employee) {
		return accDao.save(Employee);
	}

	@Override
	public Employee update(Employee Employee) {
		return accDao.save(Employee);
	}
	/*Summary*/

	@Override
	public Long getTotalEmployee() {
		return accDao.count();
	}
	@Override
	public boolean existsById(String id) {
		if(accDao.existsById(id)) 
			return true;
		return false;
	}

	
}
