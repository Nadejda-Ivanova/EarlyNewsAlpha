package com.example.model;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.model.InvalidDAOException;





public class ImageDAO extends AbstractDAO implements IImageDAO {

	private static final String CREATE_NEW_IMAGE_SQL = "INSERT INTO earlyedition.images VALUES (null, ?,?, ?,?,?);";
	private static final String GET_IMAGE = "SELECT * FROM earlyedition.images where id=?";
	private static final String DELETE_IMAGE_BY_ID = "DELETE * FROM earlyedition.images WHERE id = ?";
	private static final String GET_IMAGE_ID_FOR_LIST = "SELECT id FROM earlyedition.images WHERE articles_id = ?";
	private static final String CREATE_DUMMY = "INSERT INTO earlyedition.images VALUES(null, 'dummy entry',now(), 0,1,'dummy entry')";
	private static final String UPDATE_DUMMY = "UPDATE earlyedition.images SET name=?, articles_id=?, path=? where id=?";

	
	
	public void updateDummyPicture(Image image) throws InvalidDAOException{
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_DUMMY);
			ps.setString(1, image.getName());
			ps.setInt(2, image.getiBelongTo().getId());
			ps.setString(3, image.getPath());
			ps.setInt(4, image.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidDAOException("Image update failed", e);
		}
		
	}
	
	
	
	public int createDummyImage() throws InvalidDAOException{
		int rownumber = 0;
		try {
			PreparedStatement ps = getCon().prepareStatement(CREATE_DUMMY, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			rownumber = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidDAOException("Failed to insert dummy picture", e);
		}
		return rownumber;
	}
	
		
	public Image getImageById(int id) throws InvalidDAOException {
		Image imageToReturn = null;
		
		try {
			PreparedStatement ps = getCon().prepareStatement(GET_IMAGE);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			result.next();
			int imageToReturnId=result.getInt(1);
			String name=result.getString(2);
			
			LocalDateTime dateAdded = result.getTimestamp(3).toLocalDateTime();
			boolean isThumbnail= result.getBoolean(4);
			int articleId= result.getInt(5);
			ArticleDAO art= new ArticleDAO();
			Article iBelongTo= art.getArticleById(articleId);
			String path = result.getString(6);
			
			
			imageToReturn=new Image(name,path, isThumbnail, iBelongTo, dateAdded);
			imageToReturn.setId(id);
			return imageToReturn;
			

			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new InvalidDAOException("Image with id " + id + " cannot be found . Try again later.");

		}
	}

	public int addImage(Image image) throws InvalidDAOException {
		if (image!=null){
			try {
				
				
				PreparedStatement ps = getCon().prepareStatement(CREATE_NEW_IMAGE_SQL,
						PreparedStatement.RETURN_GENERATED_KEYS);
				
				
				
				ps.setString(1, image.getName());
				Timestamp timeStamp =Timestamp.valueOf(image.getDateAdded());
				java.sql.Date date = new java.sql.Date(timeStamp.getTime());
				ps.setDate(2,date);
				
				ps.setBoolean(3, image.isThumbnail());
				int articleId= image.getiBelongTo().getId();
				ps.setInt(4, articleId);
				ps.setString(5, image.getPath());
				
				
				ResultSet result = ps.getGeneratedKeys();
				int id =result.getInt(1);
				
				image.setId(id);
				ps.executeUpdate();
				result.next();
				
				return id;


				
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new InvalidDAOException("Your image cannot be created right now. Sorry about that. ");
			}
		} else {
			throw new InvalidDAOException("This image is null. Try again.");
		}
}
	@Override
	public List<Image> getAllImagesByArticleId(int articleId) throws InvalidDAOException {
		List <Image>images=new ArrayList<Image>();
		
		try {
			PreparedStatement ps = getCon().prepareStatement(GET_IMAGE_ID_FOR_LIST);
			
			ps.setInt(1, articleId);
			ResultSet result = ps.executeQuery();
			
			while(result.next()){
				images.add(this.getImageById(result.getInt(1)));
				
			}
			
			return images;
			

			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new InvalidDAOException("No images for article with this id " + articleId + " can be found . Try again later.");

		}
	}
	
	@Override
	public void deleteImage(Image image) throws InvalidDAOException {
		PreparedStatement ps;
		try {
			ps = getCon().prepareStatement(DELETE_IMAGE_BY_ID);
			ps.setInt(1, image.getId());
			ResultSet result = ps.executeQuery();
			result.next();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new InvalidDAOException("This image  cannot be removed right now . Try again later.");
		}
	}
	
	public ImageDAO(){
		File picsFolder = new File("C:\\pics");
		if (!picsFolder.exists()) {
			picsFolder.mkdir();
		}

	}
	
}
