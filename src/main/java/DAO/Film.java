package DAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import movie4u.models.Films;

public class Film {
	public static Films convert(ResultSet rs) throws SQLException, IOException {
		Films f=null;
		while (rs.next()) {
			ResultSet ls = Media.get(rs.getInt("MEDIA_ID"));
			f = new Films(ls.getString("NAME"),ls.getInt("year"),ls.getString("LANGUAGE"),ls.getString("COUNTRY"),ls.getInt("PRODUCER_ID"),image.get_image(ls.getInt("IMAGE_ID")),DAO.Synopsis.get(rs.getInt("SYNOPSIS_ID")),Genre.get(rs.getInt("genre_id")),null,rs.getInt("duration") );
			f.setVideo_id(rs.getInt("VIDEO_ID"));
		}
		return f;
	}
	public static void add(Films f) {
		
	}
	
	
	
}
