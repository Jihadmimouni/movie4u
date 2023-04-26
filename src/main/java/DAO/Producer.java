package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import movie4u.models.Comments;
import movie4u.models.Producers;
import movie4u.models.Rating;

public class Producer {
	/**
	 * @param username
	 * @param password
	 * @return boolean
	 * @throws SQLException
	 */
	public static boolean check(String username, String password) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.check_producer('" + username + "','" + password + "') from dual");
		rs.next();
		if (rs.getInt(1) != 1)
			return false;
		return true;
	}

	/**
	 * @param username
	 * @param password
	 * @return Producer
	 * @throws SQLException
	 * @throws IOException
	 */
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
	/**<h3>after deleting the Producer the App automatically close</h3>
	 * 
	 * @param name
	 * @throws SQLException
	 */
	public static void delete(String name) throws SQLException {
		String sql="{call movie4u.DELETE_producer('"+name+"')}";
		Connection conn=Cnx.getInstance();
	     
    	try {
			conn.prepareCall(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error here");
		}
		System.exit(0);
		
	}
	/**
	 * @param user
	 * @throws SQLException
	 */
	public static void insert(Producers user) throws SQLException {
		String sql="{call movie4u.add_producer('"+user.toString()+"')}";
		Connection conn=Cnx.getInstance();
	     
    	try {
			conn.prepareCall(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error here");
		}
	
	}
	/**
	 * @param user
	 * @throws SQLException
	 */
	public static void update(Producers user) throws SQLException {
		String sql="{call movie4u.update_producer('"+user.getID()+"'"+user.toString()+"')}";
		Connection conn=Cnx.getInstance();
	     
    	try {
			conn.prepareCall(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error here");
		}
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
		 rs.next();
		 return new Rating(rs.getInt("SCORE"));
	}
	/**
	 * @param media_id
	 * @return Comments
	 * @throws SQLException
	 */
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
