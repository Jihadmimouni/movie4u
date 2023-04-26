package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import movie4u.models.Films;

public class Film {
	/**
	 * @param result set
	 * @return	Film
	 * @throws SQLException
	 * @throws IOException
	 */
	public static Films convert(ResultSet rs) throws SQLException, IOException {
		Films f=null;
		while (rs.next()) {
			ResultSet ls = Media.get_dao(rs.getInt("MEDIA_ID"));
			f = new Films(ls.getString("NAME"),ls.getInt("year"),ls.getString("LANGUAGE"),ls.getString("COUNTRY"),ls.getInt("PRODUCER_ID"),image.get_image(ls.getInt("IMAGE_ID")),DAO.Synopsis.get(rs.getInt("SYNOPSIS_ID")),Genre.get(rs.getInt("genre_id")),null,rs.getInt("duration") );
			f.setVideo_id(rs.getInt("VIDEO_ID"));
		}
		return f;
	}
	/**
	 * @param film
	 * @throws SQLException
	 */
	public static void add(Films f) throws SQLException {
		String sql="{call movie4u.add_film('"+f.toString()+"')}";
		Connection conn=Cnx.getInstance();
	     
    	PreparedStatement ps ;
    	try {
			ps=conn.prepareCall(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error here");
		}
	}
	
	
}
