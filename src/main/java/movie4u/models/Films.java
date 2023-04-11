package movie4u.models;

public class Films {
      private int ID ;
      private int media_id ;
      private int duration ;
      private int genre_id ;
      private int video_id ;
      private int synopsis_id ;
      
      
      public Films(){
    	  super();
      }
      
      public Films(int ID,int media_id,int duration,int genre_id,int video_id,int synopsis_id) {
    	  this.ID=ID ;
    	  this.duration=duration;
    	  this.genre_id=genre_id;
    	  this.media_id=media_id;
    	  this.synopsis_id=synopsis_id;
    	  this.video_id=video_id;
      }

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getMedia_id() {
		return media_id;
	}

	public void setMedia_id(int media_id) {
		this.media_id = media_id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}

	public int getVideo_id() {
		return video_id;
	}

	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}

	public int getSynopsis_id() {
		return synopsis_id;
	}

	public void setSynopsis_id(int synopsis_id) {
		this.synopsis_id = synopsis_id;
	}

	@Override
	public String toString() {
		return "Films [ID=" + ID + ", media_id=" + media_id + ", duration=" + duration + ", genre_id=" + genre_id
				+ ", video_id=" + video_id + ", synopsis_id=" + synopsis_id + "]";
	}
      
      
}
