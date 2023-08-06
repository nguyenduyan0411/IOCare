package com.fpoly.iocare.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employees")
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Employeeid")
	private String employeeId;
	
	@Column(name = "Employeepassword")
	private String employeePassword;
	
	@Column(name = "Employeename")
	private String employeeName;
	
	@Column(name = "Employeeemail")
	private String employeeEmail;
	
	@Column(name = "Employeephone")
	private String employeePhone;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<Student> students  = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<ImportedData> importedDatas  = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
	List<Authority> authorities;
	
}
