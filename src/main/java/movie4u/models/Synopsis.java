package movie4u.models;

import java.io.File;

public class Synopsis {
	File video;
	String text;
	boolean istext;
	public Synopsis(String text,boolean istext) {
		this.istext = istext;
		this.text = text;
		this.video = null;
	}
	public Synopsis(File video,boolean istext) {
		this.istext = istext;
		this.video = video;
		this.text = null;
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
