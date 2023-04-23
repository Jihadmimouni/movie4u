package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import movie4u.models.Actors;
import movie4u.models.Users;

public class Actor {
	public static boolean check(String username, String password) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.check_actor('" + username + "','" + password + "') from dual");
		if (rs.getInt(1) != 1)
			return false;
		return true;
	}

	public static Actors get(String username, String password) throws SQLException, IOException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.check_actor( '"+username+"' , '"+password+"' ) from dual");
		int k = 0;
		ResultSet ls, ks;
		Actors user=null;

		while (rs.next()) {
			k = rs.getInt(1);
			if (k == 1) {
				cstmt = con.createStatement();
				ls = cstmt.executeQuery("select movie4u.get_actor_log( '"+username+"' , '"+password+"' ) from dual");
				ls.next();
				ks = (ResultSet) ls.getObject(1);
				while (ks.next()) {
					user=new Actors(ks.getString("NAME"),ks.getString("EMAIL"),ks.getString("PASSWORD"),ks.getDate("BIRTHDATE"),image.get_image(ks.getInt("IMAGE_ID")));
					user.setID(ks.getInt("ID"));
				}

			}

		}
		return user;
	}
	
	public static void delete(String name) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		cstmt.executeQuery("select movie4u.DELETE_actor('"+name+"') from dual");
		System.exit(0);
		
	}
	
	public static void insert(Actors user) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		cstmt.executeQuery("select movie4u.add_actor("+user.toString()+") from dual");
	}
	
	public static void update(Actors user) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		cstmt.executeQuery("select movie4u.update_actor('"+user.getID()+"'"+user.toString()+") from dual");
	}
	
	
}




