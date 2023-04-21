package movie4u.models;

import java.io.File;
import java.time.LocalDate;

public class Actors extends Users {
	

	 public Actors(int ID,String name,String Email,String password,LocalDate birthdate,File image) {
		 super(ID,name,Email,password,birthdate,image);
	 }


	@Override
	public String toString() {
		return "Actors [getID()=" + getID() + ", getName()=" + getName() + ", getEmail()=" + getEmail()
				+ ", getPassword()=" + getPassword() + ", getBirthdate()=" + getBirthdate() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	 
	 
}
