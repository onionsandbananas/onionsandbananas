package com.jpo.kd.biblioteka.dao;

public interface AdminDao {
	public boolean deleteUser(int id);
	public boolean changeRole(int id, String role);
}
