package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Media {
	
	public static ResultSet get(int id ) throws SQLException {
	Connection con = Cnx.getInstance();
	java.sql.Statement cstmt = con.createStatement();
	ResultSet rs = cstmt.executeQuery("select movie4u.get_media_id('"+id+"') from dual");
	rs = (ResultSet) rs.getObject(1);
	return rs;
	}
	
}
