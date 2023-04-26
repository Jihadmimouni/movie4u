package DAO;

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
			f = new movie4u.models.Season(ls.getString("NAME"),ls.getInt("year"),ls.getString("LANGUAGE"),ls.getString("COUNTRY"),ls.getInt("PRODUCER_ID"),image.get_image(ls.getInt("IMAGE_ID")),ls.getInt("NUMERO"),ls.getDate("START_DATE"),DAO.Synopsis.get(rs.getInt("SYNOPSIS_ID")));
			f.setID(ls.getInt("ID"));
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
		rs.next();
		rs = (ResultSet) rs.getObject(1);
		while (rs.next())
			l.add(Episode.convert(rs));
		return l;
	}

}
