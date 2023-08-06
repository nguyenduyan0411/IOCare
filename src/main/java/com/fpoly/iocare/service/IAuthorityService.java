package com.fpoly.iocare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fpoly.iocare.model.Authority;


@Service
public interface IAuthorityService {
	List<Authority> findAuthoritiesOfAdministrators();

	List<Authority> findAll();

	Authority create(Authority auth);

	void delete(Integer id);

	void deleteById(String id);

	Long getTotalCustomer();

	List<Authority> getOneByRole(String username);

}
