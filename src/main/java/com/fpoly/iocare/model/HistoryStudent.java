package com.fpoly.iocare.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Historystudent")
public class HistoryStudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Historystudentid")
	private Integer historyStudentId;

	@ManyToOne
	@JoinColumn(name = "Studentid")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "Semesterid")
	private Semester semester;

	@ManyToOne
	@JoinColumn(name = "Campaignid")
	private Campaign campaign;

	@ManyToOne
	@JoinColumn(name = "Employeeid")
	private Employee employee;

	@Column(name = "Takecaretime")
	private LocalDate takeCareTime = LocalDate.now();

	@Column(name = "Reason")
	private String reason;

}