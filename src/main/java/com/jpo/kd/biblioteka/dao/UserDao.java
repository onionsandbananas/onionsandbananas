package com.jpo.kd.biblioteka.dao;

import java.util.List;

import com.jpo.kd.biblioteka.entity.Book;
import com.jpo.kd.biblioteka.entity.Borrow;
import com.jpo.kd.biblioteka.entity.User;

public interface UserDao {
	
	public boolean authorize(String login, String password);
	
	public List<Borrow> getHistory(int id);
	
	/**
	 * 
	 * @return List<User>
	 */
	public List<User> getAllUsers();
	
	public int uiToId(int ui);
}
