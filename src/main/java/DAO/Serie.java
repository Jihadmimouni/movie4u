package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import movie4u.models.Series;

public class Serie {
	public static Series convert(ResultSet rs) throws SQLException, IOException {
		Series f=null;
		while (rs.next()) {
			ResultSet ls = Media.get_dao(rs.getInt("MEDIA_ID"));
			f = new Series(ls.getString("NAME"),ls.getInt("year"),ls.getString("LANGUAGE"),ls.getString("COUNTRY"),ls.getInt("PRODUCER_ID"),image.get_image(ls.getInt("IMAGE_ID")),DAO.Synopsis.get(rs.getInt("SYNOPSIS_ID")),Genre.get(rs.getInt("genre_id")) );
		}
		return f;
	}
	public static void add(Series f) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		cstmt.executeQuery("select movie4u.get_synopsis("+f.toString()+") from dual");
	}
}
