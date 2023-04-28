package DAO;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Season {
	/**
	 * @param rs
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public static movie4u.models.Season convert(ResultSet rs) throws SQLException, IOException {
		movie4u.models.Season f=null;
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
			int numero = 0;
			java.sql.Date startDate = null;
			movie4u.models.Synopsis synopsis = null;

			try {
				assert ls != null;
				name = ls.getString("NAME");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				year = ls.getInt("year");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				language = ls.getString("LANGUAGE");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				country = ls.getString("COUNTRY");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				producerId = ls.getInt("PRODUCER_ID");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				int imageId = ls.getInt("IMAGE_ID");
				images = image.get_image(imageId);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				numero = ls.getInt("NUMERO");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				startDate = ls.getDate("START_DATE");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				int synopsisId = rs.getInt("SYNOPSIS_ID");
				synopsis = DAO.Synopsis.get(synopsisId);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			f = new movie4u.models.Season(name, year, language, country, producerId, images, numero, startDate, synopsis);
			try {
			f.setID(ls.getInt("ID"));
		}
		catch (SQLException e) {
			System.out.println("no id found");
		}
		}
		return f;
	}
	/**
	 * @param series_id
	 * @param f
	 * @throws SQLException
	 */
	public static void add(int series_id,movie4u.models.Season f) throws SQLException {
		String sql="{call movie4u.add_season('"+series_id+"'"+f.toString()+"')}";
		Connection conn=Cnx.getInstance();
	     
    	PreparedStatement ps ;
    	try {
			ps=conn.prepareCall(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error here");
		}
	}
	/**
	 * @param id_season
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public static List<movie4u.models.Episode> get_episodes(int id_season) throws SQLException, IOException{
		List<movie4u.models.Episode> l=new ArrayList<movie4u.models.Episode>();
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.get_episode('"+id_season+"') from dual");
		try {
			rs.next();
			rs = (ResultSet) rs.getObject(1);
		} catch (SQLException e) {
			return l;
		}
		while (rs.next())
			try {
				l.add(Episode.convert(rs));
			} catch (SQLException e) {
				System.out.println("no episode found");
			}
		return l;
	}

}
