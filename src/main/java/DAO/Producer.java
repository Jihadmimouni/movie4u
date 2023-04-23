package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import movie4u.models.Producers;

public class Producer {
	public static boolean check(String username, String password) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.check_producer('" + username + "','" + password + "') from dual");
		if (rs.getInt(1) != 1)
			return false;
		return true;
	}

	public static Producers get(String username, String password) throws SQLException, IOException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.check_producer( '"+username+"' , '"+password+"' ) from dual");
		int k = 0;
		ResultSet ls, ks;
		Producers user=null;

		while (rs.next()) {
			k = rs.getInt(1);
			if (k == 1) {
				cstmt = con.createStatement();
				ls = cstmt.executeQuery("select movie4u.get_producer_log( '"+username+"' , '"+password+"' ) from dual");
				ls.next();
				ks = (ResultSet) ls.getObject(1);
				while (ks.next()) {
					user=new Producers(ks.getString("NAME"),ks.getString("EMAIL"),ks.getString("PASSWORD"),ks.getDate("BIRTHDATE"),image.get_image(ks.getInt("IMAGE_ID")));
					user.setID(ks.getInt("ID"));
				}

			}

		}
		return user;
	}
	public static void delete(String name) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		cstmt.executeQuery("select movie4u.DELETE_producer('"+name+"') from dual");
		System.exit(0);
		
	}
}
