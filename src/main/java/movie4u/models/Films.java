package movie4u.models;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Films extends Media{

    private Synopsis Synoposis;
    private File video;
    private int duration;
    private int video_id;
    

    //you don't need an id when you first create the media it will be automatically assigned by the data base
	public Films(String name, int year, String language, String country, int producer_id, File image,
			Synopsis synoposis, Genre genre, File video, int duration) {
		super(name, year, language, country, producer_id, image,genre);
		Synoposis = synoposis;
		this.video = video;
		this.duration = duration;
	}
	public Synopsis getSynoposis() {
		return Synoposis;
	}
	public void setSynoposis(Synopsis synoposis) {
		Synoposis = synoposis;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
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
