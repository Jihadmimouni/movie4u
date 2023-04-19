package movie4u.models;

public class Synopsis {
	int id , video_id ;
	String text, synopsis_title ;
	public Synopsis(int id, int video_id, String text, String synopsis_title) {
		super();
		this.id = id;
		this.video_id = video_id;
		this.text = text;
		this.synopsis_title = synopsis_title;
	}
	public Synopsis() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVideo_id() {
		return video_id;
	}
	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSynopsis_title() {
		return synopsis_title;
	}
	public void setSynopsis_title(String synopsis_title) {
		this.synopsis_title = synopsis_title;
	}
	@Override
	public String toString() {
		return "Synopsis [id=" + id + ", video_id=" + video_id + ", text=" + text + ", synopsis_title=" + synopsis_title
				+ "]";
	}
	

}
