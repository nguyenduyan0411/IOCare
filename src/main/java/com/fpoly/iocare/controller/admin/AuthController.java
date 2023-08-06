package com.fpoly.iocare.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.iocare.dao.IEmployeeDAO;

@Controller
@RequestMapping("security")
public class AuthController {

	@Autowired
	IEmployeeDAO dao;
	
	@GetMapping("login/form")
	public String loginForm(Model model) {
		model.addAttribute("message", "Vui lòng đăng nhập!");
		return "admin/sign-in";
	}
	
	@GetMapping("login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message", "Đăng nhập thành công!");
		return "admin/index";
	}
	
	@GetMapping("login/error")
	public String loginError(Model model) {
		model.addAttribute("message", "Nhập sai Username hoặc Passwword!!");
		return "admin/sign-in";
	}
	
	@GetMapping("unauthorized")
	public String unauthorized(Model model) {
		model.addAttribute("message", "Không có quyền truy cập!");
		return "admin/sign-in";
	}
	
	@GetMapping("logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message", "Bạn đã đăng xuất!");
		return "admin/sign-in";
	}
	
}
