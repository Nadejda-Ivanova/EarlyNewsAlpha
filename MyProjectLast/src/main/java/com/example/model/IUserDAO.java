package com.example.model;

import com.example.model.InvalidDAOException;



public interface IUserDAO {
	int createUser(User user) throws InvalidDAOException;

	
	void editUser(User user) throws InvalidDAOException;

	
	public void deleteUser(User user) throws InvalidDAOException;

	
	void switchIsAdminPosition(User user, boolean isAdmin) throws InvalidDAOException;


	User authenticate(User user) throws InvalidDAOException;
}
