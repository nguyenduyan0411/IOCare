package com.fpoly.iocare.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Reasonfees")
public class ReasonFee {
    @Id
    @Column(name = "Reasonfeeid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reasonFeeId;
    
    @Column(name = "Reasonfeename")
    private String reasonFeeName;
    
    @JsonIgnore
    @OneToMany(mappedBy = "reasonFee")
    private List<JoinCampaigns> joinCampains  = new ArrayList<>();
}
