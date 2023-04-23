package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Actor {
	public static boolean login(String username,String password) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs=cstmt.executeQuery("select movie4u.check_actor('"+username+"','"+password+"') from dual");
		if (rs.getInt(1)!=1) 
			return false;
		Cnx.setUSER(username);
		Cnx.setPASS(password);
		return true;
	}
}
