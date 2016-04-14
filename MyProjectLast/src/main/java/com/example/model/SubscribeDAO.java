package com.example.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.SessionAttributes;


public class SubscribeDAO extends AbstractDAO{

	private static final String ADD_SUBSCRIPTION = "INSERT INTO earlyedition.subcribe VALUES(null, ?, 0)";
	private static final String DELETE_SUBSCRIPTION = "DELETE FROM earlyedition.subcribe where email=?";

	public int addSubscription(Subscribe subscribe) throws InvalidDAOException{
		int id=0;
		try {
			PreparedStatement prep = getCon().prepareStatement(ADD_SUBSCRIPTION,
					PreparedStatement.RETURN_GENERATED_KEYS);
			prep.setString(1, subscribe.getEmail());
			prep.execute();
			ResultSet keys = prep.getGeneratedKeys();
			keys.next();	
			id=keys.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidDAOException("Subscription was not added");
		}
		return id;
	}
	
	public void deleteSubscriptionByEmail(String email) throws InvalidDAOException{
		try {
			PreparedStatement prep = getCon().prepareStatement(DELETE_SUBSCRIPTION);
			prep.setString(1, email);
			prep.execute();
			} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidDAOException("Database error cannot unsubscribe, try again");
		}
	}
}
