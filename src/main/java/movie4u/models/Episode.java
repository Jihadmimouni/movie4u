package movie4u.models;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class Episode extends Media{
	private int ID;
	private String title;
	private Date Date;
	private Synopsis Synopsis;
	private File video;
	private int video_id;
	
	
	@Override
	public int getID() {
		return ID;
	}
	
	@Override
	public void setID(int iD) {
		ID = iD;
	}
	public Episode(String name, int year, String language, String country, int producer_id, File image, 
			String title, java.sql.Date date, movie4u.models.Synopsis synopsis, File video,Genre genre) {
		super(name, year, language, country, producer_id, image,genre);
	//	ID = iD;
		this.title = title;
		Date = date;
		Synopsis = synopsis;
		this.video = video;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public Synopsis getSynopsis() {
		return Synopsis;
	}
	public void setSynopsis(Synopsis synopsis) {
		Synopsis = synopsis;
	}
	public File getVideo() throws SQLException, IOException {
		if(this.video==null) {
			this.setVideo(DAO.video.get(this.video_id));
		}
		return this.video;
		}
	public void setVideo(File video) {
		this.video = video;
	}

	public int getVideo_id() {
		return video_id;
	}

	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}
	
	
	
	
}
