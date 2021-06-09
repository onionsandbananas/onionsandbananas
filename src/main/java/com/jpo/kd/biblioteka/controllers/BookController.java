package com.jpo.kd.biblioteka.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpo.kd.biblioteka.dao.BookListDao;
import com.jpo.kd.biblioteka.entity.Book;

@Controller
@RequestMapping("/book_list")
public class BookController {
	  @Autowired
	  private BookListDao bookListDao;
	  
	  @RequestMapping("/all")
		public String listBooks(Model theModel) {	
			List<Book> books = bookListDao.getBooks();
			theModel.addAttribute("books", books);
			return "book_list";
		}
	  @RequestMapping("/search")
	  public String searchByTitle(Model theModel,@RequestParam String title) {
			List<Book> books = bookListDao.getBooksByTitle(title);
			theModel.addAttribute("books", books);
			return "book_list";	  
	  }
	  
	  @RequestMapping("/order")
	  public String order(Model theModel, @RequestParam String order) {
			List<Book> books = bookListDao.getByOrder(order);
			
			theModel.addAttribute("books", books);
			return "book_list";		  
	  }
}
