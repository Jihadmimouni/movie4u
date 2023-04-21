package movie4u.models;

import java.io.File;
import java.time.LocalDate;

public class Producers extends Users {

	  public Producers(int ID,String name,String Email,String password,LocalDate birthdate,File image) {
		  super(ID,name,Email,password,birthdate,image);
	  }


	  
	 
}
