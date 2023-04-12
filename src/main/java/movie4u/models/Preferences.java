package movie4u.models;

public class Preferences {
 private int ID ;
 private int Users_id ;
 private int genre_id ;
 
 
 public Preferences () {
	 super();
 }
	public Preferences(int ID ,int Users_id ,int genre_id) {
		this.ID=ID ;
		this.genre_id=genre_id ;
		this.Users_id=Users_id ;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getUsers_id() {
		return Users_id;
	}
	public void setUsers_id(int users_id) {
		Users_id = users_id;
	}
	public int getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}
	@Override
	public String toString() {
		return "Preferences [ID=" + ID + ", Users_id=" + Users_id + ", genre_id=" + genre_id + "]";
	}
	
	
}
