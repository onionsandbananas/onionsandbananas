package com.jpo.kd.biblioteka.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpo.kd.biblioteka.entity.Book;
import com.jpo.kd.biblioteka.entity.Borrow;
import com.jpo.kd.biblioteka.entity.User;

@Repository
public class UserDaoImp implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean authorize(String login, String password) {
		Session currentSession = sessionFactory.openSession();
		Query<User> theQuery = 
				currentSession.createQuery("from User where login='"+login+"' and password='"+password+"'", User.class);
		try {
			User user = theQuery.getSingleResult();
		}catch(Exception e) {
			currentSession.close();
			return false;
		}
		currentSession.close();
		return true;
	}

	@Override
	public List<Borrow> getHistory(int id) {
		Session currentSession = sessionFactory.openSession();
		Query<Borrow> theQuery = 
				currentSession.createQuery("from Borrow where userID="+id+"", Borrow.class);
		List<Borrow> borrow = theQuery.getResultList();
		currentSession.close();
		return borrow;
	}

	@Override
	public List<User> getAllUsers() {
		Session currentSession = sessionFactory.openSession();
		Query<User> theQuery = 
				currentSession.createQuery("from User", User.class);
		List<User> users = theQuery.getResultList();
		currentSession.close();
		return users;
	}

	@Override
	public int uiToId(int ui) {
		Session currentSession = sessionFactory.openSession();
		Query<User> theQuery = currentSession.createQuery("from User where ui="+ui, User.class);
		User user = theQuery.getSingleResult();
		currentSession.close();
		
		return user.getId();
	}

	@Override
	public User getUser(int ui) {
		Session currentSession = sessionFactory.openSession();
		Query<User> theQuery = 
				currentSession.createQuery("from User where ui="+ui, User.class);
		User user = theQuery.getSingleResult();
		currentSession.close();
		return user;
	}

	@Override
	public List<User> allUsersByRole() {
		Session currentSession = sessionFactory.openSession();
		Query<User> theQuery = 
				currentSession.createQuery("from User order by role", User.class);
		List<User> users = theQuery.getResultList();
		currentSession.close();
		return users;
	}
}
