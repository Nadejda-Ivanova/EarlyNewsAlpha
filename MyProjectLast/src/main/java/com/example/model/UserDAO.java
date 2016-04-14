package com.example.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.InvalidDAOException;
import com.example.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.InvalidDAOException;



public class UserDAO extends AbstractDAO implements IUserDAO {
	private static final String CHECK_USER = "SELECT * FROM earlyedition.users where name=? and password=?";
	private static final String CREATE_NEW_USER_SQL = "INSERT INTO earlyedition.users VALUES (null, ?, ?,?,?);";
	private static final String UPDATE_USER_SQL = "UPDATE earlyedition.users SET name = ?, password = ?,email=?,isAdmin=? WHERE id = ?;";
	private static final String DELETE_USER_BY_ID = "DELETE * FROM earlyedition.users WHERE id = ?";
	private static final String SWITCH_ADMIN_SQL = "UPDATE earlyedition.users SET isAdmin=? WHERE id = ?;";
	
	@Override
	public User authenticate(User user) throws InvalidDAOException {
		User temp = null;
		try {
			PreparedStatement prep = getCon().prepareStatement(CHECK_USER);
			prep.setString(1, user.getName());
			prep.setString(2, user.getPassword());
			ResultSet rs = prep.executeQuery();
			rs.next();
			temp = new User();
			temp.setId(rs.getInt(1));
			temp.setName(rs.getString(2));
			temp.setPassword(rs.getString(3));
			temp.setEmail(rs.getString(4));
			if (rs.getInt(5) == 1) {
				temp.setAdmin(true);
			} else {
				temp.setAdmin(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidDAOException("User not found. Check your user name and password", e);
		}

		return temp;

	}

	@Override
	public int createUser(User user) throws InvalidDAOException {
		if (user != null) {
			try {

				PreparedStatement ps = getCon().prepareStatement(CREATE_NEW_USER_SQL,
						PreparedStatement.RETURN_GENERATED_KEYS);

				ps.setString(1, user.getName());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getEmail());
				ps.setBoolean(4, user.isAdmin());
				ps.executeUpdate();
				ResultSet result = ps.getGeneratedKeys();
				result.next();
				int id = result.getInt(1);
				user.setId(id);
				return id;

			} catch (SQLException e) {

				e.printStackTrace();
				throw new InvalidDAOException("You user cannot be created right now. Sorry about that. ", e);
			}
		} else {
			throw new InvalidDAOException("This user is null. Try again.");
		}
	}

	@Override
	public void editUser(User user) throws InvalidDAOException {
		if (user != null) {
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
		} else {
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
	
	@Override
	public void switchIsAdminPosition(User user, boolean isAdmin) throws InvalidDAOException {
		if(user!=null){
			try {
				PreparedStatement ps = getCon().prepareStatement(SWITCH_ADMIN_SQL);
		
				ps.setBoolean(1, isAdmin);
				ps.setInt(2, user.getId());
				
				ps.executeUpdate();

				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new InvalidDAOException("Your user's position cannot be switched right now. Sorry about that");
			}
		}
		else {
			throw new InvalidDAOException("Your user is null.Try again.");
		}

		
	}

}
