package com.jpo.kd.biblioteka.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpo.kd.biblioteka.entity.Book;
import com.jpo.kd.biblioteka.entity.User;

@Repository
public class WorkerDaoImp implements WorkerDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public boolean updateDate(String newDate, int bookId) {
		Session currentSession = sessionFactory.openSession();
		try {
		currentSession.beginTransaction();
		currentSession.createQuery("update Borrow set date='"+newDate+"' where bookID="+bookId).executeUpdate();
		}catch(Exception e) {
			currentSession.getTransaction().commit();
			currentSession.close();
			return false;
		}
		currentSession.getTransaction().commit();
		currentSession.close();

		return true;
	}
	
	@Override
	@Transactional
	public boolean saveBorrow(int bookId, int ui, String date) {
		Session currentSession = sessionFactory.openSession();
		try {
		currentSession.beginTransaction();
		currentSession.createQuery("update Book set accesible=false where accesible=true and id="+bookId).executeUpdate();
		
		Query<User> query = currentSession.createQuery("from User where ui="+ui, User.class);
		User user = query.getSingleResult();
		
		currentSession.createSQLQuery("insert into borrow (bookID, userID, status, date) VALUES ("+
				bookId+","+
				user.getId()+","+
				"'wypożyczone do'"+","+
				"'"+date+"')").executeUpdate();
		}catch(Exception e) {
			currentSession.getTransaction().commit();
			currentSession.close();
			return false;
		}
		currentSession.getTransaction().commit();
		currentSession.close();

		return true;
	}
	
}
