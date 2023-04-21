package movie4u.models;

import java.util.ArrayList;
import java.util.List;

public class Favorite {
	List<Media> favorite;

	public List<Media> getFavorite() {
		return favorite;
	}

	public void addFavorite(Media favorite) {
		this.favorite.add(favorite) ;
	}

	/**
	 * 
	 */
	public Favorite() {
		this.favorite = new ArrayList<Media>();
	}
	
	
}
