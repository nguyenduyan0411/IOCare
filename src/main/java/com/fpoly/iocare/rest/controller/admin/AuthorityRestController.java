package com.fpoly.iocare.rest.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.iocare.model.Authority;
import com.fpoly.iocare.service.IAuthorityService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
public class AuthorityRestController {
	@Autowired
	IAuthorityService authorityService;
	
	@GetMapping
	public List<Authority> findAll(@RequestParam("admin") Optional<Boolean> admin){
		//nếu admin không chứa giá trị nào thì phương thức orElse() sẽ trả về giá trị mặc định là false.
		if(admin.orElse(false)) {
			System.out.println("Khong bi bo qua");
			return authorityService.findAuthoritiesOfAdministrators();
		}
		System.out.println("Admin khong chứa giá trị, if đã bị bỏ qua");
		return authorityService.findAll();
	}
	
	@PostMapping
	public Authority post(@RequestBody Authority authority) {
		return authorityService.create(authority);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		authorityService.delete(id);
	}
}
