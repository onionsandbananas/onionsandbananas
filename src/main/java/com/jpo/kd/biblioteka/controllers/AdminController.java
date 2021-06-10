package com.jpo.kd.biblioteka.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpo.kd.biblioteka.dao.AdminDao;
import com.jpo.kd.biblioteka.dao.UserDao;
import com.jpo.kd.biblioteka.entity.User;

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
	
	@RequestMapping("/usersByRole")
	public String usersByRole(Model theModel) {
		theModel.addAttribute("users", userDao.allUsersByRole());
		return "adminPanel";
	}
	
	@RequestMapping("/changeRole")
	public String changeRole(
			Model theModel, 
			@RequestParam("changeRole") String newRole,
			@RequestParam("id") int userID) {
		
		if(!checkId(userID)) {
			theModel.addAttribute("errId", "bad id format");
		}
		
		if(!adminDao.changeRole(userID, newRole)) {
			theModel.addAttribute("error", "Błąd!");
		}
		theModel.addAttribute("users", userDao.getAllUsers());
		return "adminPanel";
	}
	@RequestMapping("/deleteUser")
	public String deleteUser(Model theModel, @RequestParam("id") int userID) {
		if(!checkId(userID)) {
			theModel.addAttribute("errId2", "bad id format");
		}
		if(!adminDao.deleteUser(userID)) {
			theModel.addAttribute("error2", "Błąd!");
		}
		return "adminPanel";
	}
	@RequestMapping("getUser")
	public String getUser(Model theModel, @RequestParam("ui") int ui) {
		User user = userDao.getUser(ui);
		List<User> list = new ArrayList<User>();
		list.add(user);
		theModel.addAttribute("users", list);
		return "adminPanel";
	}
	
	private boolean checkRegex(String regex, String word) {
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(word);
	    return matcher.find();
	}
	private boolean checkId(int userID) {
		return checkRegex("^[1-9]([0-9]{1,4}$)|^[1-9]{1,4}$", userID+"");
	}
	
}
