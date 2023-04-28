package DAO;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import movie4u.models.Comments;
import movie4u.models.Notification;
import movie4u.models.Rating;
import movie4u.models.Users;

public class User {
	/**
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public static boolean check(String username, String password) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.check_user('" + username + "','" + password + "') from dual");
		rs.next();
		if (rs.getInt(1) != 1)
			return false;
		return true;
	}

	/**
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public static Users get(String username, String password) throws SQLException, IOException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.check_user( '"+username+"' , '"+password+"' ) from dual");
		int k = 0;
		ResultSet ls, ks;
		Users user=null;

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

				user = new Users(name, email, passwords, birthdate, images);
				user.setID(id);
			}

		}

		return user;
	}
	/**<h1>after deleting the user the App automatically close</h1>
	 * 
	 * @param name
	 * @throws SQLException
	 */
	/**
	 * @param name
	 * @throws SQLException
	 */
	public static void delete(String name) throws SQLException {
		Connection conn=Cnx.getInstance();
    	String sql="{call movie4u.select movie4u.DELETE_USER('"+name+"')}";
    	PreparedStatement ps ;
    	try {
			ps=conn.prepareCall(sql);
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
	public static void insert(Users user) throws SQLException {
		Connection conn=Cnx.getInstance();
	     
    	String sql="{call movie4u.insert_user("+user.toString()+")}";
    	PreparedStatement ps ;
    	try {
			ps=conn.prepareCall(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error here");
		}
	}
	
	/**
	 * @param user
	 * @throws SQLException
	 */
	public static void update(Users user) throws SQLException {
		Connection conn=Cnx.getInstance();
	     
    	String sql="{call movie4u.update_user('"+user.getID()+"'"+user.toString()+")}";
    	PreparedStatement ps ;
    	try {
			ps=conn.prepareCall(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error here");
		}
	}
	
	
	/**
	 * @param user_id
	 * @param media_id
	 * @param comments
	 * @throws SQLException
	 */
	public static void add_comment(int user_id,int media_id,Comments comments) throws SQLException {
		Connection conn=Cnx.getInstance();
		for(String comment :comments.getComments()) {
    	String sql="{call movie4u.update_user('"+user_id+"','"+media_id+"','"+comment+"')}";
    	PreparedStatement ps ;
    	try {
			ps=conn.prepareCall(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error here");
		}
		}
	}
	/**
	 * @param user_id
	 * @param media_id
	 * @return
	 * @throws SQLException
	 */
	public static Comments get_comments(int user_id,int media_id) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		List<String> l=new ArrayList<String>();
		ResultSet rs = cstmt.executeQuery("select movie4u.get_comment( '"+user_id+"','"+media_id+"' ) from dual");
		try{rs.next();}
		catch(Exception e) {
			return new Comments(l,"");
		}
		try {
			rs = (ResultSet) rs.getObject(1);}
		catch(Exception e) {
			return new Comments(l,"");
		}
		while (rs.next()) {
			try {
				l.add(rs.getString("COMMENTS"));
			} catch (Exception e) {
				System.out.println("error here");
			}
		}
		cstmt = con.createStatement();
		rs = cstmt.executeQuery("select movie4u.get_media_name_id ('"+media_id+"' ) from dual");
		try {
		rs.next();
		return new Comments(l,rs.getString("NAME"));
	}
		catch(Exception e) {
			return new Comments(l,"");
		}
	}
	
	/**
	 * @param user_id
	 * @param media_id
	 * @param rate
	 * @throws SQLException
	 */
	public static void add_rating(int user_id,int media_id,Rating rate) throws SQLException {
		Connection conn=Cnx.getInstance();
	     
    	String sql="{call movie4u.add_rating('"+user_id+"','"+media_id+"','"+rate.getScore()+"')}";
    	PreparedStatement ps ;
    	try {
			ps=conn.prepareCall(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error here");
		}
	}
	/**
	 * @param user_id
	 * @return
	 * @throws SQLException
	 */
	public static List<Notification> get_notification(int user_id) throws SQLException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		List<Notification> l=new ArrayList<Notification>();
		ResultSet rs = cstmt.executeQuery("select movie4u.get_notification( '"+user_id+"' ) from dual");
		try {
			rs.next();
			rs = (ResultSet) rs.getObject(1);
		}
		catch(Exception e) {
			return l;
		}
		while (rs.next())
			cstmt = con.createStatement();
			ResultSet ks= cstmt.executeQuery("select movie4u.get_media_name_id ('"+rs.getString("MEDIA_ID")+"' ) from dual");
			try {
				ks.next();
				l.add(new Notification(rs.getString("MESSAGE"), ks.getString(1)));
			}
			catch(Exception e) {
				return l;
			}
		return l;
	}
	
	
}
