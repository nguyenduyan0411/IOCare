package com.fpoly.iocare.rest.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.iocare.model.Campaign;
import com.fpoly.iocare.service.ICampaignService;
import com.fpoly.iocare.service.impl.CampaignServiceImpl;

@CrossOrigin("*")
@RestController
public class CampaignRestController {
	@Autowired
	ICampaignService campaignService = new CampaignServiceImpl();
	
	/*--Hiển thị tất cả chiến dịch--*/
	@GetMapping("/rest/campaign")
	public ResponseEntity<List<Campaign>> findAll(){
		return ResponseEntity.ok(campaignService.findAll());
	}
	
	/*--Hiển thị 1 chiến dịch dựa vào mã chiến dịch--*/
	@GetMapping("/rest/campaign/{campaignId}")
	public ResponseEntity<Campaign> findOne(@PathVariable("campaignId") String campaignId){
		if(campaignService.existsById(campaignId)) {
			return ResponseEntity.ok(campaignService.findById(campaignId));
		}
		return ResponseEntity.notFound().build();
	}
	
	/*--Tạo mới 1 chiến dịch--*/
	@PostMapping("/rest/campaign")
	public ResponseEntity<Campaign> post(@RequestBody Campaign campaign){
		if(campaignService.existsById(campaign.getCampaignId())) {
			return ResponseEntity.badRequest().build(); // 400 bad request
		}
		campaignService.create(campaign);
		return ResponseEntity.ok(campaign);
	}
	
	/*--Sửa 1 chiến dịch--*/
	@PutMapping("/rest/campaign/{campaignId}")
	public ResponseEntity<Campaign> updateCampain(@PathVariable("campaignId") String campaignId, @RequestBody Campaign updatedCampaign) {
	    if (campaignService.existsById(campaignId)) {
	        Campaign currentCampain = campaignService.findById(campaignId);
	        currentCampain.setCampaignId(updatedCampaign.getCampaignId()); // Cập nhật mã chiến dịch
	        currentCampain.setCampaignName(updatedCampaign.getCampaignName()); // Cập nhật tên chiến dịch

	        Campaign savedCampain = campaignService.update(currentCampain); // Lưu chiến dịch đã cập nhật

	        return ResponseEntity.ok(savedCampain);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}


	
	/*--Xóa chiến dịch--*/
	@DeleteMapping("/rest/campaign/{campaignId}")
	public ResponseEntity<Void> delete(@PathVariable("campaignId") String campaignId){
		if(campaignService.existsById(campaignId)) {
			campaignService.deleteById(campaignId);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
