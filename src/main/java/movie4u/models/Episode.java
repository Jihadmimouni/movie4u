package movie4u.models;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import DAO.Convert;

public class Episode extends Media{
	private int ID;
	private String title;
	private Date Date;
	private Synopsis Synoposis;
	private File video;
	private int video_id;
	private int numero;
	
	
	@Override
	public int getID() {
		return ID;
	}
	
	@Override
	public void setID(int iD) {
		ID = iD;
	}
	public Episode(String name, int year, String language, String country, int producer_id, File image, 
			String title, java.sql.Date date,int number, movie4u.models.Synopsis synopsis, File video) {
		super(name, year, language, country, producer_id, image,new Genre(""));
	//	ID = iD;
		this.title = title;
		Date = date;
		Synoposis = synopsis;
		this.video =video;
		this.numero = number;
	}
	
	
	public Episode(String name, int year, String language, String country, int producer_id, File image, String title, java.sql.Date date, Synopsis synoposis, File video) {
		super(name, year, language, country, producer_id, image,new Genre(""));
		this.title = title;
		Date = date;
		Synoposis = synoposis;
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
		return Synoposis;
	}
	public void setSynopsis(Synopsis synopsis) {
		Synoposis = synopsis;
	}
	public File getVideo() throws SQLException, IOException {
		if(this.video==null)
			this.setVideo(DAO.video.get(this.video_id));
		
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
	
	public String toString() {
		try {
			return ",'"+this.getName()+"','"+this.getLanguage()+"','"+this.Synoposis.getText()+"','"+Convert.FileToBlob(this.Synoposis.getVideo())+"','"+Convert.FileToBlob(this.getImage())+"','"+this.getProducer_id()+"','"+this.getCountry()+"','"+this.Date+"','"+Convert.FileToBlob(this.getVideo())+"','"+this.Synoposis.istext+"'";
			//p_saison_id in number, p_name in varchar, p_language in varchar,p_synopsis_text in VARCHAR, p_synopsis_video in BLOB, p_image BLOB, p_producer_id in number,p_country in varchar,air_time date,p_video BLOB,istexts BOOLEAN
		} catch (SQLException | IOException e) {
			System.out.println("error at episode.ToString() : "+ e );
			return "";
		}
	 
	}
	
	
}
