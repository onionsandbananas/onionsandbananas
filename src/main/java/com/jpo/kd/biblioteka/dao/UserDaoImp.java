package com.jpo.kd.biblioteka.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpo.kd.biblioteka.entity.Book;
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
			 return false;
		}
		return true;
	}
}
