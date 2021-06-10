package com.jpo.kd.biblioteka.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpo.kd.biblioteka.entity.User;

@Repository
public class AdminDaoImp implements AdminDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean deleteUser(int id) {
		Session currentSession = sessionFactory.openSession();
		try {
		currentSession.beginTransaction();
		currentSession.createQuery("delete from User where id="+id).executeUpdate();
		
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
	public boolean changeRole(int id, String role) {
		Session currentSession = sessionFactory.openSession();
		try {
		currentSession.beginTransaction();
		currentSession.createQuery("update User set role='"+role+"' where id="+id).executeUpdate();
		
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
