package com.fpoly.iocare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Liststudent")
public class ListStudent {
	@Id
	@Column(name = "Studentid")
	private String studentId;
	
	@Column(name = "Fullname")
	private String fullname;
	
	@Column(name = "Block")
	private String block;
	
	@Column(name = "Nearestcourse")
	private Double nearestCourse;
	
	@Column(name = "Initialadmissioncourse")
	private String initialAdmissionCourse;
	
	@Column(name = "Statuscode")
	private String statusCode;
	
	@Column(name = "Currentsemester")
	private Integer currentSemester;
	
	@Column(name = "Fieldofstudy")
	private String fieldOfStudy;
	
	@Column(name = "Major")
	private String major;
	
	@Column(name = "Majorid")
	private String majorId;
}
