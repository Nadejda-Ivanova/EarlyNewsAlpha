package com.example.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class VideoDAO extends AbstractDAO implements IVideoDAO{
	
	private static final String ADD_VIDEO = "INSERT INTO earlyedition.videos VALUES(null,?, ?, ?, ?)";
	private static final String GET_VIDEO = "SELECT * FROM earlyedition.videos where id=?";
	private static final String GET_VIDEO_ID_FROM_ARTICLE_ID = "SELECT id FROM earlyedition.videos WHERE article_id = ?";
	private static final String DELETE_VIDEO_BY_ID = "DELETE * FROM earlyedition.videos WHERE id = ?";

	
	
	public Video getVideoById(int id) throws InvalidDAOException {
		Video videoToReturn = null;
		
		try {
			PreparedStatement ps = getCon().prepareStatement(GET_VIDEO);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			result.next();
			
			String name=result.getString(2);
			LocalDateTime dateAdded = result.getTimestamp(3).toLocalDateTime();
			String path= result.getString(4);
			int articleId= result.getInt(5);
			ArticleDAO art= new ArticleDAO();
			Article iBelongTo= art.getArticleById(articleId);
			
			
			
			videoToReturn=new Video(name, path, iBelongTo,dateAdded);
			videoToReturn.setId(id);
			return videoToReturn;
			

			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new InvalidDAOException("Video with id " + id + " cannot be found . Try again later.");

		}
	}
	
	
		
	public int addVideo(Video video) throws InvalidDAOException{
		if (video!=null){
			try {
				
				
				PreparedStatement ps = getCon().prepareStatement(ADD_VIDEO,
						PreparedStatement.RETURN_GENERATED_KEYS);
				
				
				
				ps.setString(1, video.getName());
				
				Timestamp timeStamp =Timestamp.valueOf(video.getDateAdded());
				java.sql.Date date = new java.sql.Date(timeStamp.getTime());
				ps.setDate(2,date);
				ps.setString(3, video.getPath());
				int articleId= video.getiBelongTo().getId();
	
				ps.setInt(4, articleId);
				ps.executeUpdate();
				ResultSet result = ps.getGeneratedKeys();
				result.next();
				int id =result.getInt(1);
				video.setId(id);
						
				return id;


				
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new InvalidDAOException("Your video cannot be created right now. Sorry about that. ");
			}
		} else {
			throw new InvalidDAOException("This video is null. Try again.");
		}	
	
}
	

	@Override
	public void deleteVideo(Video video) throws InvalidDAOException {
		PreparedStatement ps;
		try {
			ps = getCon().prepareStatement(DELETE_VIDEO_BY_ID);
			ps.setInt(1, video.getId());
			ResultSet result = ps.executeQuery();
			result.next();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new InvalidDAOException("This video  cannot be removed right now . Try again later.");
		}
		
	}
	@Override
	public Video getVideoByArticleId(int articleId) throws InvalidDAOException {
		Video videoToReturn = null;
		
		try {
			PreparedStatement ps = getCon().prepareStatement(GET_VIDEO_ID_FROM_ARTICLE_ID);
			ps.setInt(1, articleId);
			ResultSet result = ps.executeQuery();
			result.next();
			
			
			
			
			
			int videoId= result.getInt(1);
			videoToReturn= this.getVideoById(videoId);
			
			
			
			
			return videoToReturn;
				
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new InvalidDAOException("Video for article with id " + articleId + " cannot be found . Try again later.");

		}
	}
}
