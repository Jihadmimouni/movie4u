package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import movie4u.models.Actors;
import movie4u.models.Producers;

public class Actor {
	public static boolean check(String username, String password) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.check_actor('" + username + "','" + password + "') from dual");
		rs.next();
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
	/**<h1>after deleting the user the App automatically close</h1>
	 * 
	 * @param name
	 * @throws SQLException
	 */
	public static void delete(String name) throws SQLException {
		String sql="{call movie4u.DELETE_actor('"+name+"')}";
		Connection conn=Cnx.getInstance();
	     
    	PreparedStatement ps ;
    	try {
			ps=conn.prepareCall(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error here");
		}
		System.exit(0);
		
	}
	public static void insert(Actors user) throws SQLException {
		String sql="{call movie4u.add_actor('"+user.toString()+"')}";
		Connection conn=Cnx.getInstance();
	     
    	PreparedStatement ps ;
    	try {
			ps=conn.prepareCall(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error here");
		}
	
	}
	public static void update(Actors user) throws SQLException {
		String sql="{call movie4u.update_actor('"+user.getID()+"'"+user.toString()+"')}";
		Connection conn=Cnx.getInstance();
	     
    	PreparedStatement ps ;
    	try {
			ps=conn.prepareCall(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error here");
		}
	}	
	
	
	
	
	
	
	
	
	
	
}




