package movie4u.models;

import java.io.File;

public class Synopsis {
	File video;
	String text;
	boolean istext;
	public Synopsis(String text) {
		this.istext = true;
		this.text = text;
		this.video = null;
	}
	public Synopsis(File video) {
		this.istext = false;
		this.video = video;
		this.text = null;
	}
	
//leave this one don't use it its created for the data base 
	public Synopsis(File video, String text, boolean istext) {
		super();
		this.video = video;
		this.text = text;
		this.istext = istext;
	}
	public File getVideo() {
		return video;
	}
	public void setVideo(File video) {
		this.video = video;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean Istext() {
		return istext;
	}
	public void setIstext(boolean istext) {
		this.istext = istext;
	}
	
	

}
