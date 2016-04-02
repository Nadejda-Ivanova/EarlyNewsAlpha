package com.example.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class VideoDAO extends AbstractDAO {
	private static final String ADD_VIDEO = "INSERT INTO earlyedition.videos VALUES(?, ?, ?, ?)";
	private static final String GET_VIDEO = "SELECT * FROM earlyedition.videos where id=?";

	
	
	public Video getVideoById(int id) {
		Video video = new Video();
		try {
			PreparedStatement prep = getCon().prepareStatement(GET_VIDEO);
			prep.setInt(1, id);
			ResultSet rs = prep.executeQuery();
			rs.next();

			video.setId(id);
			video.setName(rs.getString(2));
			video.setAddedOn(rs.getTimestamp(3).toLocalDateTime());
			ImageDAO daoIMG = new ImageDAO();
			video.setImage(daoIMG.getImageById(rs.getInt(4)));
				} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return video;
	}
	
	
		
	public int addVideo(Video video) throws InvalidDAOException{
		java.sql.Timestamp stampTime = Timestamp.valueOf(LocalDateTime.now());
		int id = 0;
		try {
			PreparedStatement prep = getCon().prepareStatement(ADD_VIDEO, PreparedStatement.RETURN_GENERATED_KEYS);
			prep.setInt(1, video.getId());
			prep.setString(2, video.getName());
			prep.setTimestamp(3, stampTime);
			prep.setInt(4, video.getImage().getId());
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
