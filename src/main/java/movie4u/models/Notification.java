package movie4u.models;

public class Notification {
        private String message ;
        private String media_name ;
    
		public Notification(String message, String media_name) {
			this.message = message;
			this.setMedia_name(media_name);
		}


	

		public String getMessage() {
			return message;
		}


		public void setMessage(String message) {
			this.message = message;
		}




		public String getMedia_name() {
			return media_name;
		}




		public void setMedia_name(String media_name) {
			this.media_name = media_name;
		}

}
