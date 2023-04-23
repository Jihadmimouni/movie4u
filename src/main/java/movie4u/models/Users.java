package movie4u.models; 

import java.io.File;
import java.sql.Date;
import java.time.LocalDate;

public class Users {
        private int ID ;
        private String name ;
        private String Email ;
        private String password ;
        private Date birthdate ;
        private File image;
        
        public File getImage() {
			return image;
		}

		public void setImage(File image) {
			this.image = image;
		}

        
        public Users(String name,String Email,String password,Date birthdate,File image) {
        	this.name =name ;
        	this.birthdate=birthdate ;
        	this.Email=Email ;
        	this.password=password ;
        	this.image=image;
        	}

		public int getID() {
			return ID;
		}

		public void setID(int iD) {
			ID = iD;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Date getBirthdate() {
			return birthdate;
		}

		public void setBirthdate(Date birthdate) {
			this.birthdate = birthdate;
		}

		@Override
		public String toString() {
			return "Users [ID=" + ID + ", name=" + name + ", Email=" + Email + ", password=" + password + ", birthdate="
					+ birthdate + "]";
		}
        
}
