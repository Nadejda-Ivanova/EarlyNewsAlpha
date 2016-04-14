package com.example.model;

import static java.lang.Math.toIntExact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.model.InvalidDAOException;




public class CategoryDAO extends AbstractDAO implements ICategoryDAO {
	private static final String ADD_CATEGORY = "INSERT INTO earlyedition.categories values(null, ?, 'dummy', ?,?,?)";
	private static final String GET_CATEGORY_NAME_BY_ID = "SELECT * FROM earlyedition.categories WHERE id = ?";
	private static final String GET_CATEGORY_ID_BY_NAME = "SELECT * FROM earlyedition.categories WHERE name = ?";
	private static final String GET_CATEGORIES = "SELECT * FROM earlyedition.categories";

	public Category getCategoryById(int id) throws InvalidDAOException {
		Category temp = new Category();
		try {
			PreparedStatement prep = getCon().prepareStatement(GET_CATEGORY_NAME_BY_ID);
			prep.setInt(1, id);
			ResultSet rs = prep.executeQuery();
			rs.next();
			buildCategory(rs, temp);
		} catch (SQLException e) {

			e.printStackTrace();

		}
		return temp;
	}

	public ArrayList<Category> getAllCategories() throws InvalidDAOException {
		ArrayList<Category> temp = new ArrayList<Category>();
		try {
			PreparedStatement prep = getCon().prepareStatement(GET_CATEGORIES);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				Category cat = new Category();
				buildCategory(rs, cat);
				temp.add(cat);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidDAOException("There are no categories to show. Try again later.");
		}
		return temp;
	}

	public void buildCategory(ResultSet rs, Category cat) throws InvalidDAOException {
		try {
			cat.setId(rs.getInt(1));

			cat.setName(rs.getString(2));
			if (rs.getInt(4) == 1) {
				cat.setTop(true);
			} else {
				cat.setTop(false);
			}
			if (rs.getInt(5) == 1) {
				cat.setMain(true);
			} else {
				cat.setMain(false);
			}
			cat.setSortOrder(rs.getInt(6));
		} catch (SQLException e) {

			e.printStackTrace();
			throw new InvalidDAOException("You cannot build category now. Try again later.");
		}

	}

	public int addCategory(Category category) throws InvalidDAOException {
		if (category != null) {
			try {

				PreparedStatement ps = getCon().prepareStatement(ADD_CATEGORY, PreparedStatement.RETURN_GENERATED_KEYS);

				ps.setString(1, category.getName());
//				ps.setString(2, category.getDescription());
				ps.setBoolean(2, category.isTop());
				ps.setBoolean(3, category.isMain());
				ps.setInt(4, category.getSortOrder());
				ps.executeUpdate();
				ResultSet result = ps.getGeneratedKeys();
				result.next();
				int id = result.getInt(1);
				category.setId(id);
			
			

				return id;

			} catch (SQLException e) {

				e.printStackTrace();
				throw new InvalidDAOException("You category cannot be created right now. Sorry about that. ");
			}
		} else {
			throw new InvalidDAOException("This user is null. Try again.");
		}
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
