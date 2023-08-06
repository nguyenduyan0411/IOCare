package com.fpoly.iocare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.iocare.dao.ICampaignDAO;
import com.fpoly.iocare.model.Campaign;
import com.fpoly.iocare.service.ICampaignService;

@Service
public class CampaignServiceImpl implements ICampaignService{
	
	@Autowired
	ICampaignDAO dao;
	
	/*--Xóa chiến dịch--*/
	@Override
	public void deleteById(String id) {
		dao.deleteById(id);	
	}
	
	/*--Tìm kiếm chiến dịch theo mã chiến dịch--*/
	@Override
	public Campaign findById(String id) {
		return dao.findById(id).get();
	}
	
	/*--Thêm mới chiến dịch--*/
	@Override
	public Campaign create(Campaign campaign) {
		return dao.save(campaign);
	}
	
	/*--Kiểm tra mã chiến dịch có tồn tại hay chưa--*/
	@Override
	public boolean existsById(String id) {
		if(dao.existsById(id)) 
			return true;
		return false;
	}
	
	/*--Hiển thị tất cả học kỳ--*/
	@Override
	public List<Campaign> findAll() {
		return dao.findAll();
	}
	
	@Override
	public Campaign update(Campaign currentCampaign) {
	    String currentCampaignId = currentCampaign.getCampaignId(); // Lấy mã chiến dịch hiện tại từ đối tượng cập nhật
	    String newCampaignId = currentCampaign.getCampaignId(); // Lấy mã chiến dịch mới từ đối tượng cập nhật

	    if (!currentCampaignId.equals(newCampaignId)) {
	        // Nếu mã chiến dịch được cập nhật, thực hiện kiểm tra mã chiến dịch mới
	        if (existsById(newCampaignId)) {
	            // Mã chiến dịch mới đã tồn tại, xử lý lỗi hoặc thông báo cho người dùng
	            throw new IllegalArgumentException("Mã chiến dịch đã tồn tại");
	        }
	        // Cập nhật mã chiến dịch mới
	        currentCampaign.setCampaignId(newCampaignId);
	    }

	    return dao.save(currentCampaign);
	}







}
