package com.fpoly.iocare.service;

import java.util.List;

import com.fpoly.iocare.model.Campaign;

public interface ICampaignService {
	/*--Xóa chiến dịch-*/
	public void deleteById(String id);
	
	/*--Tìm kiếm chiến dịch theo mã chiến dịch--*/
	Campaign findById(String id);
	
	/*--Hiển thị tất cả chiến dịch--*/
	List<Campaign> findAll();
	
	/*--Thêm mới chiến dịch--*/
	Campaign create(Campaign campain);
	
	/*--Kiểm tra mã chiến dịch có tồn tại hay chưa--*/
	boolean existsById(String id);

	Campaign update(Campaign campaign);
}
