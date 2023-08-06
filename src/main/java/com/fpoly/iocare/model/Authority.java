package com.fpoly.iocare.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = "employee")
@Table(name = "Authorities")
public class Authority implements Serializable{
	@Id
	@Column(name = "Authorityid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer authorityId;
	
	@ManyToOne
	@JoinColumn(name = "employeeid", referencedColumnName = "EmployeeId") 
	private Employee employee;
	 
	@ManyToOne
	@JoinColumn(name = "roleid", referencedColumnName = "RoleId")
	private Role role;
	
}
