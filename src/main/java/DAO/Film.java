package DAO;

import java.io.File;
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
			String name = null;
			try {
				name = ls.getString("NAME");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			Integer year = null;
			try {
				year = ls.getInt("year");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			String language = null;
			try {
				language = ls.getString("LANGUAGE");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			String country = null;
			try {
				country = ls.getString("COUNTRY");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			Integer producerID = null;
			try {
				producerID = ls.getInt("PRODUCER_ID");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			File images = null;
			try {
				images = image.get_image(ls.getInt("IMAGE_ID"));
			} catch (SQLException e) {
				e.printStackTrace();
			}

			movie4u.models.Synopsis synopsis = null;
			try {
				synopsis = DAO.Synopsis.get(rs.getInt("SYNOPSIS_ID"));
			} catch (SQLException e) {
				e.printStackTrace();
			}

			movie4u.models.Genre genre = null;
			try {
				genre = Genre.get(rs.getInt("genre_id"));
			} catch (SQLException e) {
				e.printStackTrace();
			}

			Integer duration = null;
			try {
				duration = rs.getInt("duration");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			 f = new movie4u.models.Films(name, year, language, country, producerID, images, synopsis, genre, null, duration);
			try {
			f.setVideo_id(rs.getInt("VIDEO_ID"));
		}
		catch (SQLException e) {
			System.out.println("no video id");
		}
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
