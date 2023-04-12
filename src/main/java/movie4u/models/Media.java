package movie4u.models;

public class Media {
         private int ID ;
         private String name ;
         private int year ;
         private String language ;
         private String country ;
         private int producer_id ;
         private int image_id ;
         
         
         public Media() {
        	 super();
         }
         
         public Media(int ID , String name ,int year, String language, String country, int producer_id, int image_id) {
        	 this.country=country;
        	 this.ID=ID ;
        	 this.image_id= image_id;
        	 this.language=language;
        	 this.name=name;
        	 this.producer_id=producer_id;
        	 this.year=year;
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

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public int getProducer_id() {
			return producer_id;
		}

		public void setProducer_id(int producer_id) {
			this.producer_id = producer_id;
		}

		public int getImage_id() {
			return image_id;
		}

		public void setImage_id(int image_id) {
			this.image_id = image_id;
		}

		@Override
		public String toString() {
			return "Media [ID=" + ID + ", name=" + name + ", year=" + year + ", language=" + language + ", country="
					+ country + ", producer_id=" + producer_id + ", image_id=" + image_id + "]";
		}
         
         
}
