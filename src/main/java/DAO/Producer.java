package DAO;

import java.io.File;
import java.io.IOException;
import java.sql.*;
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
		Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.check_producer( '"+username+"' , '"+password+"' ) from dual");
		int k = 0;
		ResultSet ls, ks;
		Producers user=null;

		while (rs.next()) {
			try {
				k = rs.getInt(1);
			} catch (SQLException e) {
				k=0;
			}
			if (k == 1) {
				cstmt = con.createStatement();
				ls = cstmt.executeQuery("select movie4u.get_producer_log( '"+username+"' , '"+password+"' ) from dual");
				ls.next();
				try {
					ks = (ResultSet) ls.getObject(1);
				} catch (SQLException e) {
					ks=null;
				}
					ks.next();
					String name = null;
					String email = null;
					String passwords = null;
					Date birthdate = null;
					File images = null;
					int id = 0;

					try {
						name = ks.getString("NAME");
					} catch (Exception e) {
						System.out.println("error name producer");
					}

					try {
						email = ks.getString("EMAIL");
					} catch (Exception e) {
						System.out.println("error email producer");
					}

					try {
						passwords = ks.getString("PASSWORD");
					} catch (Exception e) {
						System.out.println("error password producer");
					}

					try {
						birthdate = ks.getDate("BIRTHDATE");
					} catch (Exception e) {
						System.out.println("error birthdate producer");
					}

					try {
						images = image.get_image(ks.getInt("IMAGE_ID"));
					} catch (Exception e) {
						System.out.println("error image producer");
					}

					try {
						id = ks.getInt("ID");
					} catch (Exception e) {
						System.out.println("error id producer");
					}

					user = new Producers(name, email, passwords, birthdate, images);
					user.setID(id);
				}

			}

		return user;
	}
	/**<h3>after deleting the Producer the App automatically close</h3>
	 * 
	 * @param name
	 * @throws SQLException
	 */
	public static void delete(String name)  {
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
	public static void insert(Producers user)  {
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
	public static void update(Producers user)  {
		String sql="{call movie4u.update_producer('"+user.getID()+"','"+user.toString()+"')}";
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
		 try {
			 rs.next();
		 	return new Rating(rs.getInt("SCORE"));
			 		 }catch(Exception e) {
			 			 return new Rating(0);
			 		 }
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
		try {
		rs = (ResultSet) rs.getObject(1);
		}catch(Exception e){
			return new Comments(l,"");
		}
		while (rs.next())
			try {
				l.add(rs.getString("COMMENTS"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		cstmt = con.createStatement();
		rs = cstmt.executeQuery("select movie4u.get_media_name_id ('"+media_id+"' ) from dual");
		try{
		rs.next();
		String name = rs.getString("NAME");
		return new Comments(l,name);
		}catch(Exception e){
			return new Comments(l,"");
		}
	} 
}
