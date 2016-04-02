package com.example.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ImageDAO extends AbstractDAO {

	private static final String ADD_IMAGE = "INSERT INTO earlyedition.image VALUES(?, ?, ?, ?, ?)";
	private static final String GET_IMAGE = "SELECT * FROM earlyedition.image where id=?";

	public Image getImageById(int id) {
		Image temp = new Image();
		try {
			PreparedStatement prep = getCon().prepareStatement(GET_IMAGE);
			prep.setInt(1, id);
			ResultSet rs = prep.executeQuery();
			rs.next();

			temp.setArtId(id);
			temp.setName(rs.getString(2));
			temp.setDateAdded(rs.getTimestamp(3).toLocalDateTime());
			if (rs.getInt(4) == 1) {
				temp.setThumbnail(true);
			} else {
				temp.setThumbnail(false);
			}
			temp.setArtId(rs.getInt(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	public int addImage(Image image) throws InvalidDAOException {
		java.sql.Timestamp stampTime = Timestamp.valueOf(LocalDateTime.now());
		int id = 0;
		try {
			PreparedStatement prep = getCon().prepareStatement(ADD_IMAGE, PreparedStatement.RETURN_GENERATED_KEYS);
			prep.setInt(1, image.getId());
			prep.setString(2, image.getName());
			prep.setTimestamp(3, stampTime);

			if (image.isThumbnail()) {
				prep.setInt(4, 1);
			} else {
				prep.setInt(4, 0);
			}
			prep.setInt(5, image.getArtId());
			prep.executeUpdate();
			ResultSet keys = prep.getGeneratedKeys();
			keys.next();
			id = keys.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidDAOException("Database Error try agail later", e);
		}
		return id;
	}

}
