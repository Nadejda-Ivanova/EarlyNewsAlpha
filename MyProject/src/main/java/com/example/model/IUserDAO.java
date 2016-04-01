package com.example.model;

import com.example.model.InvalidDAOException;
import com.example.model.User;

public interface IUserDAO {
	int createUser(User user) throws InvalidDAOException;

	
	void editUser(User user) throws InvalidDAOException;

	
	public void deleteUser(User user) throws InvalidDAOException;

	
	//metod za smeni booleana isAdmin
}
