package com.fpoly.iocare.rest.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.json.JSONFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

@CrossOrigin("*")
@RestController
public class SecurityRestController {
	
	//Xác thực đăng nhập
	@GetMapping("security/authenticated")
	public Boolean authenticated(){
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 System.out.println(authentication.isAuthenticated());
        return authentication.isAuthenticated();
	}
	
	//Xác thực quyền ADMIN
	@GetMapping("security/admin")
	public Boolean adminSecurity(){
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.isAuthenticated();
	}
	
	//Xác thực quyền USER1
	@GetMapping("security/user1")
	public Boolean user1Security(){
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 System.out.println(authentication.isAuthenticated());
        return authentication.isAuthenticated();
	}
	
	//Xác thực quyền USER2
	@GetMapping("security/user2")
	public Boolean user2Security(){
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 System.out.println(authentication.isAuthenticated());
        return authentication.isAuthenticated();
	}
}
