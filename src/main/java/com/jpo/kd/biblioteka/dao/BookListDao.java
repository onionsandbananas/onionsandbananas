package com.jpo.kd.biblioteka.dao;

import java.util.List;

import com.jpo.kd.biblioteka.entity.Book;
import com.jpo.kd.biblioteka.entity.Borrow;


public interface BookListDao {
	public List<Book> getBooks();

	public List<Book> getBooksByTitle(String title);

	public List<Book> getByOrder(String order);
	
	public Book getBook(int id);
	
	public List<Borrow> getBorrow();
}
