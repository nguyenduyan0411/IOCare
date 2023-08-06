package com.fpoly.iocare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.iocare.model.Campaign;

@Repository
public interface ICampaignDAO extends JpaRepository<Campaign, String>{

}
