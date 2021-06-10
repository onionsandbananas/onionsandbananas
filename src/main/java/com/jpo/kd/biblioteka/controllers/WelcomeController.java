package com.jpo.kd.biblioteka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpo.kd.biblioteka.dao.UserDao;

@Controller
public class WelcomeController {
	
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/")
	public String login() {
		return "login";
	}
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	@RequestMapping("/login_check")
	public String login_check(@ModelAttribute("login") String login, @ModelAttribute("password") String password) {
		
		if(userDao.authorize(login, password)) {
			return "welcome";
		}
		return "login";
	}
	
}
