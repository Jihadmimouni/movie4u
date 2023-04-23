package movie4u.models;

import java.io.File;
import java.sql.Date;

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
	public Episode(String name, int year, String language, String country, int producer_id, File image, int iD,
			String title, java.sql.Date date, movie4u.models.Synopsis synopsis, File video) {
		super(name, year, language, country, producer_id, image);
		ID = iD;
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
	public File getVideo() {
		return video;
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
