package com.jpo.kd.biblioteka.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpo.kd.biblioteka.entity.Book;

@Repository
public class BookListDaoImp implements BookListDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Book> getBooks() {
		Session currentSession = sessionFactory.openSession();
		Query<Book> theQuery = 
				currentSession.createQuery("from Book", Book.class);
		List<Book> books = theQuery.getResultList();
		return books;
	}

	@Override
	public List<Book> getBooksByTitle(String title) {
		Session currentSession = sessionFactory.openSession();
		Query<Book> theQuery = 
				currentSession.createQuery("from Book where title like'%"+title+"%'", Book.class);
		List<Book> books = theQuery.getResultList();
		return books;
	}

	@Override
	public List<Book> getByOrder(String order) {
		Session currentSession = sessionFactory.openSession();
		Query<Book> theQuery = 
				currentSession.createQuery("from Book order by "+order, Book.class);
		List<Book> books = theQuery.getResultList();
		return books;
	}

}
