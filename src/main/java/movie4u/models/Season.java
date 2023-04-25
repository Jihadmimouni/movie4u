package movie4u.models;

import java.sql.Date;
import java.sql.SQLException;

import DAO.Convert;

import java.io.File;
public class Season extends Media{
	private int iD;
	private int numero;
	private Date start_date;
	private Synopsis Synoposis;
	
	public Season(String name, int year, String language, String country, int producer_id, File image,
			int numero, Date start_date, movie4u.models.Synopsis synopsis) {
		super(name, year, language, country, producer_id, image,new Genre(""));
		//this.setID(id);
		this.setNumero(numero);
		this.setStart_date(start_date);
		setSynopsis(synopsis);
	}
	@Override
	public int getID() {
		return iD;
	}
	@Override
	public void setID(int id) {
		this.iD = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Synopsis getSynopsis() {
		return Synoposis;
	}
	public void setSynopsis(Synopsis synopsis) {
		Synoposis = synopsis;
	}
	
	public String toString() {
		try {
			return ",'"+this.getName()+"','"+this.getLanguage()+"','"+this.Synoposis.getText()+"','"+Convert.FileToBlob(this.Synoposis.getVideo())+"','"+Convert.FileToBlob(this.getImage())+"','"+this.getProducer_id()+"','"+this.getCountry()+"','"+this.start_date+"','"+this.Synoposis.istext+"'";
			
		} catch (SQLException e) {
			System.out.println("error at Season.ToString() : "+ e );
			return "";
		}
	 
	}
	
}
