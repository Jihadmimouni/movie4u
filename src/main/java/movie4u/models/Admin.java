package movie4u.models;

public class Admin {
       private int users_id ;
       private int ID ;
       
       
       
       public Admin() {
    	   super();
       }
       
       public Admin(int users_id ,int ID ) {
    	   this.ID =ID; 
    		this.users_id=users_id;	   
       
       }

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return "Admin [users_id=" + users_id + ", ID=" + ID + "]";
	}
       
       
}
