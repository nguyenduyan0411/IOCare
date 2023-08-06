package com.fpoly.iocare.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "Campaigns")
public class Campaign implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Campaignid")
	private String campaignId;
	
	@Column(name = "Campaignname")
	private String campaignName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "campaign")
	private List<JoinCampaigns> joinCampains = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "campaign")
	private List<ImportedData> importedDatas = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "campaign")
	private List<Student> students = new ArrayList<>();
}
