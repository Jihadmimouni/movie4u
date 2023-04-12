package movie4u.models;

public class Notification {
        private int ID ;
        private String message ;
        private int users_id;
        private int media_id ;
        
        
        public Notification() {
        	super();
        }
        
        
        public Notification(int ID, String message, int users_id, int media_id) {
        	this.ID=ID;
        	this.media_id=media_id ;
        	this.message=message ;
        	this.users_id=users_id;
        }


		public int getID() {
			return ID;
		}


		public void setID(int iD) {
			ID = iD;
		}


		public String getMessage() {
			return message;
		}


		public void setMessage(String message) {
			this.message = message;
		}


		public int getUsers_id() {
			return users_id;
		}


		public void setUsers_id(int users_id) {
			this.users_id = users_id;
		}


		public int getMedia_id() {
			return media_id;
		}


		public void setMedia_id(int media_id) {
			this.media_id = media_id;
		}


		@Override
		public String toString() {
			return "Notification [ID=" + ID + ", message=" + message + ", users_id=" + users_id + ", media_id="
					+ media_id + "]";
		}
        
        
}
