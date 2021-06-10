package com.jpo.kd.biblioteka.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpo.kd.biblioteka.dao.BookListDao;
import com.jpo.kd.biblioteka.dao.UserDao;
import com.jpo.kd.biblioteka.entity.Book;
import com.jpo.kd.biblioteka.entity.Borrow;

@Controller
public class UserController {
	  @Autowired
	  private UserDao userDao;
	  @Autowired
	  private BookListDao bookDao;
	  
	  @RequestMapping("/userHistory")
		public String listBooks(Model theModel) {	
			List<Borrow> borrow = userDao.getHistory(1);//TODO session, different users etc
			
			List<Book> bookList = new ArrayList<Book>();
			
			for(Borrow loopBorrow:borrow) {
				bookList.add(bookDao.getBook(loopBorrow.getBookID()));
				
			}
			
			theModel.addAttribute("book", bookList);
			theModel.addAttribute("borrow", borrow);
			return "userHistory";
		}
}
