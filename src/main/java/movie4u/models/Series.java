package movie4u.models;

import java.io.File;

public class Series extends Media{
	private int ID ;
	private Synopsis Synopsis;
	private Genre Genre;
	



	//you don't need an id when you first create the media it will be automatically assigned by the data base
	public Series(String name, int year, String language, String country, int producer_id, File image, int iD,
			movie4u.models.Synopsis synopsis, movie4u.models.Genre genre) {
		super(name, year, language, country, producer_id, image);
		ID = iD;
		Synopsis = synopsis;
		Genre = genre;
	}
@Override
public int getID() {
	return ID;
}
@Override
public void setID(int iD) {
	ID = iD;
}

public Synopsis getSynopsis() {
	return Synopsis;
}

public void setSynopsis(Synopsis synopsis) {
	Synopsis = synopsis;
}

public Genre getGenre() {
	return Genre;
}

public void setGenre(Genre genre) {
	Genre = genre;
}



  
}
