package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Genre {
	/**
	 * @param id
	 * @return Genre
	 * @throws SQLException
	 */
	public static movie4u.models.Genre get(int id) throws SQLException{
		 Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.get_genre('"+id+"') from dual");
		rs.next();
		rs = (ResultSet) rs.getObject(1);
		return new movie4u.models.Genre(rs.getString("name"));
	}
	/**
	 * @param Genre
	 * @return	id
	 * @throws SQLException
	 */
	public static int get_id(movie4u.models.Genre g) throws SQLException {
		 Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.get_genre_id('"+g.getName()+"') from dual"); 
		rs.next();
		return rs.getInt(1);	
	}
}
