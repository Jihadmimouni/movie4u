package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import movie4u.models.Comments;
import movie4u.models.Users;

public class User {
	public static boolean check(String username, String password) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.check_user('" + username + "','" + password + "') from dual");
		if (rs.getInt(1) != 1)
			return false;
		return true;
	}

	public static Users get(String username, String password) throws SQLException, IOException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.check_user( '"+username+"' , '"+password+"' ) from dual");
		int k = 0;
		ResultSet ls, ks;
		Users user=null;

		while (rs.next()) {
			k = rs.getInt(1);
			if (k == 1) {
				cstmt = con.createStatement();
				ls = cstmt.executeQuery("select movie4u.get_user_log( '"+username+"' , '"+password+"' ) from dual");
				ls.next();
				ks = (ResultSet) ls.getObject(1);
				while (ks.next()) {
					user=new Users(ks.getString("NAME"),ks.getString("EMAIL"),ks.getString("PASSWORD"),ks.getDate("BIRTHDATE"),image.get_image(ks.getInt("IMAGE_ID")));
					user.setID(ks.getInt("ID"));
				}

			}

		}
		return user;
	}
	/**<h1>after deleting the user the App automatically close</h1>
	 * 
	 * @param name
	 * @throws SQLException
	 */
	public static void delete(String name) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		cstmt.executeQuery("select movie4u.DELETE_USER('"+name+"') from dual");
		System.exit(0);
		
	}
	
	public static void insert(Users user) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		cstmt.executeQuery("select movie4u.insert_user("+user.toString()+") from dual");
	}
	
	public static void update(Users user) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		cstmt.executeQuery("select movie4u.update_user('"+user.getID()+"'"+user.toString()+") from dual");
	}
	
	
	public static void add_comment(int user_id,int media_id,Comments comments) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		for(String comment :comments.getComments()) 	
			cstmt.executeQuery("select movie4u.update_user('"+user_id+"','"+media_id+"','"+comment+"') from dual");
	
	}
	public static Comments get_comments(int user_id,int media_id) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		List<String> l=new ArrayList<String>();
		ResultSet rs = cstmt.executeQuery("select movie4u.get_comment( '"+user_id+"','"+media_id+"' ) from dual");
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
