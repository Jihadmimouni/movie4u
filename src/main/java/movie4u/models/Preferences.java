package movie4u.models;

import java.util.ArrayList;
import java.util.List;

public class Preferences {
 private List<Genre> genre;

 public Preferences() {
	 this.genre = new ArrayList<Genre>();
 }
 
 public void addGenre(Genre genre) {
	 this.genre.add(genre);
 }
 public List<Genre> getGenre(){
	 return this.genre;
 }
 
 
 
 
 
}
