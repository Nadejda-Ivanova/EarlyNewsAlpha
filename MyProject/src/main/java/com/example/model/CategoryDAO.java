package com.example.model;

import static java.lang.Math.toIntExact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.model.InvalidDAOException;

public class CategoryDAO extends AbstractDAO implements ICategoryDAO {
	private static final String ADD_CATEGORY = "INSERT INTO earlyedition.category values(null, ?, 'dummy', ?,?,?)";
	private static final String GET_CATEGORY_NAME_BY_ID = "SELECT * FROM earlyedition.category WHERE id = ?";
	private static final String GET_CATEGORY_ID_BY_NAME = "SELECT * FROM earlyedition.category WHERE name = ?";
	private static final String GET_CATEGORIES = "SELECT * FROM earlyedition.category";
	
	public Category getCategoryById(int id){
		Category temp = new Category();
		try {
			PreparedStatement prep = getCon().prepareStatement(GET_CATEGORY_NAME_BY_ID);
			prep.setInt(1, id);
			ResultSet rs = prep.executeQuery();
			rs.next();
			buildCategory(rs, temp);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	
	public ArrayList<Category> getAllCategories(){
		ArrayList<Category> temp = new ArrayList<Category>();
		try {
			PreparedStatement prep = getCon().prepareStatement(GET_CATEGORIES);
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				Category cat = new Category();
				buildCategory(rs, cat);
				temp.add(cat);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}


	public void buildCategory(ResultSet rs, Category cat) throws SQLException {
		cat.setId(rs.getInt(1));
		cat.setName(rs.getString(2));
		if(rs.getInt(4) ==1){
			cat.setTop(true);
		}else{
			cat.setTop(false);
		}
		if(rs.getInt(5) ==1){
			cat.setMain(true);
		}else{
			cat.setMain(false);
		}
		cat.setSortOrder(rs.getInt(6));
	}	
	
	
	
	
	public int addCategory(Category category) {
		int row = 0;
		try {
			PreparedStatement prep = getCon().prepareStatement(ADD_CATEGORY, PreparedStatement.RETURN_GENERATED_KEYS);
			prep.setString(1, category.getName());
			if (category.isTop()) {
				prep.setInt(2, 1);
			} else {
				prep.setInt(2, 0);
			}
			if (category.isMain()) {
				prep.setInt(3, 1);
			} else {
				prep.setInt(3, 0);
			}
			prep.setInt(4, category.getSortOrder());
			prep.executeUpdate();
			ResultSet keys = prep.getGeneratedKeys();
			keys.next();
			row = toIntExact(keys.getLong(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public String getCategoryNameById(int categoryId) throws InvalidDAOException {
		PreparedStatement ps;
		try {
			ps = getCon().prepareStatement(GET_CATEGORY_NAME_BY_ID);
			ps.setInt(1, categoryId);
			ResultSet result = ps.executeQuery();
			result.next();
			String name = result.getString(2);
			return name;
		} catch (SQLException e) {

			e.printStackTrace();
			throw new InvalidDAOException("The category with id " + categoryId + " cannot be found . Try again later.");
		}

	}

	@Override
	public int getCategoryIdByName(String categoryName) throws InvalidDAOException {
		PreparedStatement ps;
		try {
			ps = getCon().prepareStatement(GET_CATEGORY_ID_BY_NAME);
			ps.setString(1, categoryName);
			ResultSet result = ps.executeQuery();
			result.next();
			int id = result.getInt(1);
			return id;
		} catch (SQLException e) {

			e.printStackTrace();
			throw new InvalidDAOException(
					"The category with this name " + categoryName + " cannot be found . Try again later.");
		}

	}

}
