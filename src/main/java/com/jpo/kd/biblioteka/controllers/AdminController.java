package com.jpo.kd.biblioteka.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpo.kd.biblioteka.dao.AdminDao;
import com.jpo.kd.biblioteka.dao.UserDao;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/panel")
	public String adminPanel(Model theModel) {
		
		theModel.addAttribute("users", userDao.getAllUsers());
		return "adminPanel";
	}
	@RequestMapping("/changeRole")
	public String changeRole(
			Model theModel, 
			@RequestParam("changeRole") String newRole,
			@RequestParam("id") int userID) {
		
		if(!checkRegex("[0-9]{4}", userID+"")) {
			theModel.addAttribute("errId", "bad id format");
		}
		
		if(!adminDao.changeRole(userID, newRole)) {
			theModel.addAttribute("error", "Błąd!");
		}
		theModel.addAttribute("users", userDao.getAllUsers());
		return "adminPanel";
	}
	
	private boolean checkRegex(String regex, String word) {
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(word);
	    return matcher.find();
	}
	
}
