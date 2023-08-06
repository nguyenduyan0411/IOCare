package com.fpoly.iocare.model;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JoinCampaigns")
public class JoinCampaigns {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "JoinCampainsid")
	private Integer joinCampainsId;
	
	@ManyToOne
	@JoinColumn(name = "Campaignid")
	private Campaign campaign;
	
	@ManyToOne
	@JoinColumn(name = "Studentid")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "Studyingstatusid")
	private StudyingStatus studyingStatus;
	
	@ManyToOne
	@JoinColumn(name = "Semesterid")
	private Semester semester;
	
	@ManyToOne
	@JoinColumn(name = "ReasonAbsenteeismid")
	private ReasonAbsenteeism reasonAbsenteeisms;
	
	@ManyToOne
	@JoinColumn(name = "ReasonFeeId")
	private ReasonFee reasonFee;
}
