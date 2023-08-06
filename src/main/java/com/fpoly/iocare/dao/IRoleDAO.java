package com.fpoly.iocare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.iocare.model.Employee;
import com.fpoly.iocare.model.Role;
import com.fpoly.iocare.model.Semester;

@Repository
public interface IRoleDAO extends JpaRepository<Role, String>{

}
