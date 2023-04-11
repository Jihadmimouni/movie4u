package movie4u.models;

import java.time.LocalDate;

public class Actors extends Users {
	
	
	public Actors() {
		super();
	}
	
	
	 public Actors(int ID,String name,String Email,String password,LocalDate birthdate) {
		 super(ID,name,Email,password,birthdate);
	 }


	@Override
	public String toString() {
		return "Actors [getID()=" + getID() + ", getName()=" + getName() + ", getEmail()=" + getEmail()
				+ ", getPassword()=" + getPassword() + ", getBirthdate()=" + getBirthdate() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	 
	 
}
