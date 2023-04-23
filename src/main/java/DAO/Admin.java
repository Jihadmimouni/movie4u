package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
 public static boolean check(int id) throws SQLException {
	 Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.check_admin('"+id+"') from dual");
		if (rs.getInt(1) != 1)
			return false;
		return true;
 }
}
