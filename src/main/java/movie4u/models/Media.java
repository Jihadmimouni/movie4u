package movie4u.models;

import java.io.File;

public class Media {
         private int ID ;
         private String name ;
         private int year ;
         private String language ;
         private String country ;
         private int producer_id;
         private File image;
         private String Type;

         
         public Media(String name ,int year, String language, String country, int producer_id, File image) {
        	 this.country=country;
        	 this.image= image;
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

		public File getImage() {
			return image;
		}

		public void setImage_id(File image_id) {
			this.image = image_id;
		}

		public String getType() {
			return Type;
		}

		public void setType(String type) {
			Type = type;
		}

         
         
}
