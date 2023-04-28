package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import movie4u.models.Comments;
import movie4u.models.Rating;

public class Admin {
 /**
 * @param id
 * @return
 * @throws SQLException
 */
public static boolean check(int id) throws SQLException {
	 Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.check_admin('"+id+"') from dual");
		rs.next();
		if (rs.getInt(1) != 1)
			return false;
		return true;
 }
 /**
 * @param media_id
 * @return Rating
 * @throws SQLException
 */
public static Rating get_rate(int media_id) throws SQLException {
	 Connection con = Cnx.getInstance();
	 java.sql.Statement cstmt = con.createStatement();
	 ResultSet rs = cstmt.executeQuery("select movie4u.get_average_rating('"+media_id+"') from dual");
	try{
	 rs.next();
	 return new Rating(rs.getInt("SCORE"));
	}catch (Exception e) {
		return new Rating(0);
	}
 }
	/**
	 * @param media_id
	 * @return	Comments
	 * @throws SQLException
	 */
	public static Comments get_comments(int media_id) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		List<String> l=new ArrayList<String>();
		ResultSet rs = cstmt.executeQuery("select movie4u.get_comments_by_media_id( '"+media_id+"' ) from dual");
		try {
		rs.next();
		rs = (ResultSet) rs.getObject(1);
		}
		catch (Exception e) {
			return new Comments(l,"");
		}
		while (rs.next())
			try {
				l.add(rs.getString("COMMENTS"));
			} catch (SQLException e) {
				continue;
			}
		cstmt = con.createStatement();
		rs = cstmt.executeQuery("select movie4u.get_media_name_id ('"+media_id+"' ) from dual");
		try {
		rs.next();
		return new Comments(l,rs.getString("NAME"));
	}catch (Exception e) {
		return new Comments(l,"");
	}
	}
 
}
