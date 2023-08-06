package com.fpoly.iocare.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Importeddata")
public class ImportedData implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Importedfilename")
	private String importedFileName;
	
	@ManyToOne
	@JoinColumn(name = "Semesterid")
	private Semester semester;
	
	@Column(name = "Importeddate")
	private LocalDate importedDate = LocalDate.now();
	
	@ManyToOne
	@JoinColumn(name = "Employeeid")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "Campaignid")
	private Campaign campaign;
	
	@JsonIgnore
	@OneToMany(mappedBy = "imported")
	private List<Student> students = new ArrayList<>();
}
