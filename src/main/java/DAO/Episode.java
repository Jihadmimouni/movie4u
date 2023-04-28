package DAO;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Episode {
	/**
	 * @param rs
	 * @return Episode
	 * @throws SQLException
	 * @throws IOException
	 */
	public static movie4u.models.Episode convert(ResultSet rs) throws SQLException, IOException {
		movie4u.models.Episode f=null;
		while (rs.next()) {
			ResultSet ls = Media.get_dao(rs.getInt("MEDIA_ID"));
			try {
				ls.next();
			} catch (Exception e) {
				ls = null;
			}
			String name = null, language = null, country = null, title = null;
			int year = 0, producerId = 0, imageId = 0, numero = 0;
			Date startDate = null;
			movie4u.models.Synopsis synopsis = null;
			File images = null;

			try {
				name = ls.getString("NAME");
			} catch (Exception e) {
				name = null;
			}

			try {
				year = ls.getInt("year");
			} catch (Exception e) {
				year = 0;
			}

			try {
				language = ls.getString("LANGUAGE");
			} catch (Exception e) {
				language = null;
			}

			try {
				country = ls.getString("COUNTRY");
			} catch (Exception e) {
				country = null;
			}

			try {
				producerId = ls.getInt("PRODUCER_ID");
			} catch (Exception e) {
				producerId = 0;
			}

			try {
				imageId = ls.getInt("IMAGE_ID");
				images = image.get_image(imageId);
			} catch (Exception e) {
				images = null;
			}

			try {
				title = ls.getString("TITLE");
			} catch (Exception e) {
				title = null;
			}

			try {
				startDate = ls.getDate("START_DATE");
			} catch (Exception e) {
				startDate = null;
			}

			try {
				numero = ls.getInt("NUMERO");
			} catch (Exception e) {
				numero = 0;
			}

			try {
				synopsis = DAO.Synopsis.get(rs.getInt("SYNOPSIS_ID"));
			} catch (Exception e) {
				synopsis = null;
			}
				f = new movie4u.models.Episode(name,
						year,
						language,
						country,
						producerId,
						images,
						title,
						startDate,
						numero,
						synopsis,
						null);

			f.setVideo_id(ls.getInt("video_ID"));
		}
		return f;
	}
	/**
	 * @param season_id
	 * @param Episode
	 * @throws SQLException
	 */
	public static void add(int season_id,movie4u.models.Episode f) throws SQLException {
		String sql="{call movie4u.add_episode('"+season_id+"'"+f.toString()+"')}";
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
