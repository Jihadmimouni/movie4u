package movie4u.models;

public class Series {
   private int ID ;
   private int media_id ;
  private int synopsis_id ;
  private int genre_id ;
  
  public Series() {
	  super();
  }
  
  public Series (int ID,int media_id,int synopsis_id,int genre_id) {
	  this.ID=ID ;
	  this.media_id=media_id;
	  this.synopsis_id=synopsis_id;
	  this.genre_id=genre_id;
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

public int getSynopsis_id() {
	return synopsis_id;
}

public void setSynopsis_id(int synopsis_id) {
	this.synopsis_id = synopsis_id;
}

public int getGenre_id() {
	return genre_id;
}

public void setGenre_id(int genre_id) {
	this.genre_id = genre_id;
}

@Override
public String toString() {
	return "Series [ID=" + ID + ", media_id=" + media_id + ", synopsis_id=" + synopsis_id + ", genre_id=" + genre_id
			+ "]";
}
  
  
}
