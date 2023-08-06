package com.fpoly.iocare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fpoly.iocare.model.Authority;
import com.fpoly.iocare.model.Employee;
import com.fpoly.iocare.model.Semester;


@Repository
public interface IAuthorityDAO extends JpaRepository<Authority, Integer>{
	
	@Query("Select Distinct a From Authority a where a.employee IN ?1")
	List<Authority> authoritiesOf(List<Employee> accounts);

	@Query("Select a From Authority a where a.employee.id like ?1")
	List<Authority> getOneByRole(String username);

	@Transactional
	@Modifying
	@Query("Delete from Authority where id = ?1")
	void deleteById(String username);
	
}
