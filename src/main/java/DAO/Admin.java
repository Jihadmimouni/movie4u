package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import movie4u.models.Comments;
import movie4u.models.Rating;

public class Admin {
 public static boolean check(int id) throws SQLException {
	 Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.check_admin('"+id+"') from dual");
		rs.next();
		if (rs.getInt(1) != 1)
			return false;
		return true;
 }
 public static Rating get_rate(int media_id) throws SQLException {
	 Connection con = Cnx.getInstance();
	 java.sql.Statement cstmt = con.createStatement();
	 ResultSet rs = cstmt.executeQuery("select movie4u.get_average_rating('"+media_id+"') from dual");
	 rs.next();
	 return new Rating(rs.getInt("SCORE"));
}
	public static Comments get_comments(int media_id) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		List<String> l=new ArrayList<String>();
		ResultSet rs = cstmt.executeQuery("select movie4u.get_comments_by_media_id( '"+media_id+"' ) from dual");
		rs.next();
		rs = (ResultSet) rs.getObject(1);
		while (rs.next())
			l.add(rs.getString("COMMENTS"));
		cstmt = con.createStatement();
		rs = cstmt.executeQuery("select movie4u.get_media_name_id ('"+media_id+"' ) from dual");
		rs.next();
		return new Comments(l,rs.getString("NAME"));
	} 
 
}
