package movie4u.models;

import java.io.File;

public class Films extends Media{

    private Synopsis Synoposis;
    private Genre genre;
    private File video;
    private int duration;
    private int video_id;
    

    //you don't need an id when you first create the media it will be automatically assigned by the data base
	public Films(String name, int year, String language, String country, int producer_id, File image,
			Synopsis synoposis, Genre genre, File video, int duration) {
		super(name, year, language, country, producer_id, image);
		Synoposis = synoposis;
		this.genre = genre;
		this.video = video;
		this.duration = duration;
	}
	public Synopsis getSynoposis() {
		return Synoposis;
	}
	public void setSynoposis(Synopsis synoposis) {
		Synoposis = synoposis;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
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
