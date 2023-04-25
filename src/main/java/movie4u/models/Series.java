package movie4u.models;

import java.io.File;
import java.sql.SQLException;

import DAO.Convert;

public class Series extends Media{
	private int ID ;
	private Synopsis Synoposis;
	



	//you don't need an id when you first create the media it will be automatically assigned by the data base
	public Series(String name, int year, String language, String country, int producer_id, File image, 
			movie4u.models.Synopsis synopsis, movie4u.models.Genre genre) {
		super(name, year, language, country, producer_id, image,genre);
		//ID = iD;
		Synoposis = synopsis;
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
	return Synoposis;
}

public void setSynopsis(Synopsis synopsis) {
	Synoposis = synopsis;
}

public String toString() {
	try {
		return "'"+this.getName()+"','"+this.getYear()+"','"+this.getLanguage()+"','"+this.Synoposis.getText()+"','"+Convert.FileToBlob(this.Synoposis.getVideo())+"','"+Convert.FileToBlob(this.getImage())+"','"+this.getProducer_id()+"','"+this.getCountry()+"','"+DAO.Genre.get_id(this.getGenre())+"','"+this.Synoposis.istext+"'";
		
	} catch (SQLException e) {
		System.out.println("error at Serie.ToString() : "+ e );
		return "";
	}
 
}






}
