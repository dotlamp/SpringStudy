package com.dotlamp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {

	@GetMapping("/user/accessError")
	public void accessDenied(Authentication auth, Model model) {

		log.info("access Denied : " + auth);

		model.addAttribute("msg", "Access Denied");
	}

	@GetMapping("/user/login")
	public void loginInput(String error, String logout, Model model) {

		log.info("error: " + error);
		log.info("logout: " + logout);

		if (error != null) {
			model.addAttribute("error", "Login Error Check Your Account");
		}

		if (logout != null) {
			model.addAttribute("logout", "Logout!!");
		}
	}

	@GetMapping("/user/logout")
	public void logoutGET() {
		log.info("custom logout");
	}

	@PostMapping("/user/logout")
	public void logoutPost() {
		log.info("post custom logout");
	}
	
	@GetMapping("/sample/all")
	public void all() {
		
	}
	@GetMapping("/sample/admin")
	public void admin2() {
		
	}
	@PostMapping("/sample/admin")
	public void admin() {
		
	}
	@PostMapping("/sample/member")
	public void member() {
		
	}

}
