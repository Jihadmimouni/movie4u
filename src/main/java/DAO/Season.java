package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Season {
	public static movie4u.models.Season convert(ResultSet rs) throws SQLException, IOException {
		movie4u.models.Season f=null;
		while (rs.next()) {
			ResultSet ls = Media.get_dao(rs.getInt("MEDIA_ID"));
			f = new movie4u.models.Season(ls.getString("NAME"),ls.getInt("year"),ls.getString("LANGUAGE"),ls.getString("COUNTRY"),ls.getInt("PRODUCER_ID"),image.get_image(ls.getInt("IMAGE_ID")),ls.getInt("NUMERO"),ls.getDate("START_DATE"),DAO.Synopsis.get(rs.getInt("SYNOPSIS_ID")));
			f.setID(ls.getInt("ID"));
		}
		return f;
	}
	public static void add(int series_id,movie4u.models.Season f) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		cstmt.executeQuery("select movie4u.add_season('"+series_id+"'"+f.toString()+") from dual");
	}


}
