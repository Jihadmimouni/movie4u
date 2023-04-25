package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Episode {
	public static movie4u.models.Episode convert(ResultSet rs) throws SQLException, IOException {
		movie4u.models.Episode f=null;
		while (rs.next()) {
			ResultSet ls = Media.get_dao(rs.getInt("MEDIA_ID"));
			f = new movie4u.models.Episode(ls.getString("NAME"),ls.getInt("year"),ls.getString("LANGUAGE"),ls.getString("COUNTRY"),ls.getInt("PRODUCER_ID"),image.get_image(ls.getInt("IMAGE_ID")),ls.getString("TITLE"),ls.getDate("START_DATE"),ls.getInt("NUMERO"),DAO.Synopsis.get(rs.getInt("SYNOPSIS_ID")) ,null);
			f.setVideo_id(ls.getInt("video_ID"));
		}
		return f;
	}
	public static void add(int season_id,movie4u.models.Episode f) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		cstmt.executeQuery("select movie4u.add_episode('"+season_id+"'"+f.toString()+") from dual");
	}
	
	
}
