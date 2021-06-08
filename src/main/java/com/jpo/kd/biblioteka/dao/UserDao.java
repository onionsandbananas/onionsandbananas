package com.jpo.kd.biblioteka.dao;

public interface UserDao {
	
	public boolean authorize(String login, String password);
}
