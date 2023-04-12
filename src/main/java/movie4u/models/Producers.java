package movie4u.models;

import java.time.LocalDate;

public class Producers extends Users {
      
	  public Producers() {
		  super();
	  }
	  
	  public Producers(int ID,String name,String Email,String password,LocalDate birthdate) {
		  super(ID,name,Email,password,birthdate);
	  }

	@Override
	public String toString() {
		return "Producers [getID()=" + getID() + ", getName()=" + getName() + ", getEmail()=" + getEmail()
				+ ", getPassword()=" + getPassword() + ", getBirthdate()=" + getBirthdate() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	  
	  
	 
}
