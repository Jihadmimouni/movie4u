package movie4u.models;

import java.io.File;
import java.sql.Date;

public class Actors extends Users {
	

	 public Actors(String name,String Email,String password,Date birthdate,File image) {
		 super(name,Email,password,birthdate,image);
	 }


	@Override
	public String toString() {
		return "Actors [getID()=" + getID() + ", getName()=" + getName() + ", getEmail()=" + getEmail()
				+ ", getPassword()=" + getPassword() + ", getBirthdate()=" + getBirthdate() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	 
	 
}
