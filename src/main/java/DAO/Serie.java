package DAO;

import java.io.IOException;
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
			f = new Series(ls.getString("NAME"),ls.getInt("year"),ls.getString("LANGUAGE"),ls.getString("COUNTRY"),ls.getInt("PRODUCER_ID"),image.get_image(ls.getInt("IMAGE_ID")),DAO.Synopsis.get(rs.getInt("SYNOPSIS_ID")),Genre.get(rs.getInt("genre_id")) );
			f.setID(rs.getInt("ID"));
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
	     
    	PreparedStatement ps ;
    	try {
			ps=conn.prepareCall(sql);
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
		rs.next();
		rs = (ResultSet) rs.getObject(1);
		while (rs.next())
			l.add(Season.convert(rs));
		return l;
	}
	
	
	
}
