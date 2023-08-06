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
@Table(name = "Students")
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Studentid")
	private String studentId;
	
	@ManyToOne
	@JoinColumn(name = "Semesterid")
	private Semester semester;
	
	@ManyToOne
	@JoinColumn(name = "Campaignid")
	private Campaign campaign;
	
	@Column(name = "Subjectid")
	private String subjectId;
	
	@Column(name = "Studentname")
	private String studentName;
	
	@Column(name = "Totalfee")
	private Double totalFee;
	
	@Column(name = "Major")
	private String major;
	
	
	@ManyToOne
	@JoinColumn(name = "Employeeid")
	private Employee employee;
	
	@Column(name = "Takecaretime")
	private LocalDate takeCareTime;
	
	@Column(name = "Reason")
	private String reason;
	

	@ManyToOne
	@JoinColumn(name = "Aspirationid")
	private Aspiration aspirations;
	

	@ManyToOne
	@JoinColumn(name = "Objclassificationid")
	private ObjClassification objClassifications;
	

	@ManyToOne
	@JoinColumn(name = "Riskclassificationid")
	private RiskClassification riskClassifications;
	
	@Column(name = "Descriptiondetailsid")
	private String DescriptionDetailsId;
	
	@ManyToOne
	@JoinColumn(name = "Importedfilename")
	private ImportedData imported;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student")
	List<JoinCampaigns> joinCampaigns = new ArrayList<>();
}
