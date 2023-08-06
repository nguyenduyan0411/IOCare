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
@Table(name = "Aspirations")
public class Aspiration {
    @Id
    @Column(name = "Aspirationid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aspirationId;
    
    @Column(name = "Aspirationdes")
    private String aspirationDes;
    
    @JsonIgnore
    @OneToMany(mappedBy = "aspirations")
    private List<Student> student = new ArrayList<>();
}
