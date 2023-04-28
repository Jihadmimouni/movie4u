package DAO;

import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import movie4u.models.Series;

public class Serie {
	/**
	 * @param rs
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public static Series convert(ResultSet rs) throws SQLException, IOException {
		Series f=null;
		while (rs.next()) {
			ResultSet ls = Media.get_dao(rs.getInt("MEDIA_ID"));
			try {
				ls.next();
			} catch (Exception e) {
				ls = null;
			}
			String name = null;
			int year = 0;
			String language = null;
			String country = null;
			int producerId = 0;
			File images = null;
			movie4u.models.Synopsis synopsis = null;
			movie4u.models.Genre genre = null;

			try {
				name = ls.getString("NAME");
			} catch (SQLException e) {
				// handle the exception
			}

			try {
				year = ls.getInt("year");
			} catch (SQLException e) {
				// handle the exception
			}

			try {
				language = ls.getString("LANGUAGE");
			} catch (SQLException e) {
				// handle the exception
			}

			try {
				country = ls.getString("COUNTRY");
			} catch (SQLException e) {
				// handle the exception
			}

			try {
				producerId = ls.getInt("PRODUCER_ID");
			} catch (SQLException e) {
				// handle the exception
			}

			try {
				int imageId = ls.getInt("IMAGE_ID");
				images = image.get_image(imageId);
			} catch (SQLException e) {
				// handle the exception
			}

			try {
				int synopsisId = rs.getInt("SYNOPSIS_ID");
				synopsis = DAO.Synopsis.get(synopsisId);
			} catch (SQLException e) {
				// handle the exception
			}

			try {
				int genreId = rs.getInt("genre_id");
				genre = Genre.get(genreId);
			} catch (SQLException e) {
				// handle the exception
			}

			f = new Series(name, year, language, country, producerId, images, synopsis, genre);
			try {
			f.setID(rs.getInt("ID"));
		}
			catch (Exception e) {
			System.out.println("no id found");
			}
		}
		return f;
	}
	/**
	 * @param f
	 * @throws SQLException
	 */
	public static void add(Series f) throws SQLException {
		String sql="{call movie4u.add_serie("+f.toString()+"')}";
		Connection conn=Cnx.getInstance();
	     
    	try {
    		CallableStatement statement = conn.prepareCall(sql);    
    		statement.setBlob(1, Convert.FileToBlob(f.getSynopsis().getVideo()));
    		statement.setBlob(2, Convert.FileToBlob(f.getSynopsis().getVideo()));
    		statement.execute(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error here");
		}
	}
	/**
	 * @param id_serie
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public static List<movie4u.models.Season> get_seasons(int id_serie) throws SQLException, IOException{
		List<movie4u.models.Season> l=new ArrayList<movie4u.models.Season>();
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.get_season('"+id_serie+"') from dual");
		try {
			rs.next();
			rs = (ResultSet) rs.getObject(1);
		}
		catch (Exception e) {
			return l;
		}
		while (rs.next())
			try {
			l.add(Season.convert(rs));
			}
			catch (Exception e) {
				System.out.println("no season found");
			}
		return l;
	}
	
	
	
}
