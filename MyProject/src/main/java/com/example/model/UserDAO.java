package com.example.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.InvalidDAOException;
import com.example.model.User;

public class UserDAO extends AbstractDAO implements IUserDAO{
	private static final String CREATE_NEW_USER_SQL = "INSERT INTO users VALUES (null, ?, ?,?,?);";
	private static final String UPDATE_USER_SQL = "UPDATE users SET name = ?, password = ?,email=?,isAdmin=? WHERE id = ?;";
	private static final String DELETE_USER_BY_ID = "DELETE * FROM users WHERE id = ?";

	@Override
	public int createUser(User user) throws InvalidDAOException {
		if (user!=null){
			try {
				
				
				PreparedStatement ps = getCon().prepareStatement(CREATE_NEW_USER_SQL,
						PreparedStatement.RETURN_GENERATED_KEYS);
				
				
				ps.setString(1, user.getName());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getEmail());
				ps.setBoolean(4, user.isAdmin());
				ResultSet result = ps.getGeneratedKeys();
				int id =result.getInt(1);
				
				user.setId(id);
				ps.executeUpdate();
				result.next();
				
				return id;


				
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new InvalidDAOException("You user cannot be created right now. Sorry about that. ");
			}
		} else {
			throw new InvalidDAOException("This user is null. Try again.");
		}
	}

	@Override
	public void editUser(User user) throws InvalidDAOException {
		if(user!=null){
			try {
				PreparedStatement ps = getCon().prepareStatement(UPDATE_USER_SQL);
		
				ps.setString(1, user.getName());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getEmail());
				ps.setBoolean(4, user.isAdmin());
				ps.setInt(5, user.getId());
				
				ps.executeUpdate();

				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new InvalidDAOException("Your user cannot be edited right now. Sorry about that");
			}
		}
		else {
			throw new InvalidDAOException("Your user is null.Try again.");
		}

		
	}

	@Override
	public void deleteUser(User user) throws InvalidDAOException {
		PreparedStatement ps;
		try {
			ps = getCon().prepareStatement(DELETE_USER_BY_ID);
			ps.setInt(1, user.getId());
			ResultSet result = ps.executeQuery();
			result.next();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new InvalidDAOException("This user  cannot be removed right now . Try again later.");
		}
	}

}
