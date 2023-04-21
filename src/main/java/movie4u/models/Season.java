package movie4u.models;

import java.sql.Date;
import java.io.File;
public class Season extends Media{
	private int iD;
	private int numero;
	private Date start_date;
	private Synopsis Synopsis;
	/**
	 * @param name
	 * @param year
	 * @param language
	 * @param country
	 * @param producer_id
	 * @param image
	 * @param id
	 * @param numero
	 * @param start_date
	 * @param synopsis
	 */
	public Season(String name, int year, String language, String country, int producer_id, File image, int id,
			int numero, Date start_date, movie4u.models.Synopsis synopsis) {
		super(name, year, language, country, producer_id, image);
		this.setID(id);
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
		return Synopsis;
	}
	public void setSynopsis(Synopsis synopsis) {
		Synopsis = synopsis;
	}
	
}
