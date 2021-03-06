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

import com.jpo.kd.biblioteka.dao.BookListDao;
import com.jpo.kd.biblioteka.dao.UserDao;
import com.jpo.kd.biblioteka.dao.WorkerDao;
import com.jpo.kd.biblioteka.entity.Book;
import com.jpo.kd.biblioteka.entity.Borrow;
import com.jpo.kd.biblioteka.entity.User;



@Controller
@RequestMapping("/worker")
public class WorkerController {
	
	  @Autowired
	  private UserDao userDao;
	  @Autowired
	  private BookListDao bookDao;
	  @Autowired
	  private WorkerDao workerDao;
	  
	  @RequestMapping("/panel")
	  public String workerPanel(Model theModel) {
		  //TODO system wypozyczen, przedluzanie daty
		
		 List<User> users = userDao.getAllUsers();
		
		 List<Book> bookList = bookDao.getBooks();
		
		 theModel.addAttribute("bBooks", bookDao.getBorrow());
		 theModel.addAttribute("users", users);
		 theModel.addAttribute("book", bookList);
		 return "workerPanel";
	}
	@RequestMapping("/checkUser")
	public String worekrPanel(Model theModel, @RequestParam int ui) {
		List<Borrow> borrow = userDao.getHistory(userDao.uiToId(ui));
			
			
		List<Book> bookList = new ArrayList<Book>();
		for(Borrow loopBorrow:borrow) {
			bookList.add(bookDao.getBook(loopBorrow.getBookID()));
		}
	
		theModel.addAttribute("book", bookList);
		theModel.addAttribute("borrow", borrow);
		theModel.addAttribute("ui", ui);
		return "userHistory";
	}
	
	@RequestMapping("/changeDate")
	public String changeDate(Model theModel, @RequestParam("newDate") String newDate,  @RequestParam("bookId") int bookId) {
	    if(!checkRegex(
	    		"^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$",
	    		newDate
	    		)) {
	    	theModel.addAttribute("errDate2","Z??y format daty");
	    }
	    if(!workerDao.updateDate(newDate, bookId)) {
	    	theModel.addAttribute("err2","B????d");
	    }
		return "workerPanel";
	}
	
	@RequestMapping("/save")
	public String save(Model theModel, 
			@RequestParam("bookid") int bookId,
			@RequestParam("ui") int ui,
			@RequestParam("date") String date) {
		System.out.println(bookId+" "+ui+" "+date);
		
	    if(!checkRegex(
	    		"^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$",
	    		date
	    		)) {
	    	theModel.addAttribute("errDate","Z??y format daty");
	    }
    
	    if(!checkRegex("[0-9]{4}", ui+"")) {
	    	theModel.addAttribute("errUI","Z??y format ui");
		}
	    
	    if(!checkRegex("[0-9]{3}", bookId+"")) {
	    	theModel.addAttribute("errId","Z??y format id ksi????ki");
		}
	    if(!workerDao.saveBorrow(bookId, ui, date)) {//TODO if error before occured, dont call it
	    	theModel.addAttribute("error", "B????d!");
	    }
		return workerPanel(theModel);
	}
	
	private boolean checkRegex(String regex, String word) {
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(word);
	    return matcher.find();
	}
	
}
