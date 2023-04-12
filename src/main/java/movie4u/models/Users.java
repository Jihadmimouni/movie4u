package movie4u.models; 

import java.time.LocalDate;

public class Users {
        private int ID ;
        private String name ;
        private String Email ;
        private String password ;
        private LocalDate birthdate ;
        
        
        public Users() {
        	super();
        }
        
        public Users(int ID,String name,String Email,String password,LocalDate birthdate) {
        	this.ID=ID;
        	this.name =name ;
        	this.birthdate=birthdate ;
        	this.Email=Email ;
        	this.password=password ;
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

		public LocalDate getBirthdate() {
			return birthdate;
		}

		public void setBirthdate(LocalDate birthdate) {
			this.birthdate = birthdate;
		}

		@Override
		public String toString() {
			return "Users [ID=" + ID + ", name=" + name + ", Email=" + Email + ", password=" + password + ", birthdate="
					+ birthdate + "]";
		}
        
}
