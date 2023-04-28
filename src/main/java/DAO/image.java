package DAO;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class image {
	/**
	 * @param id
	 * @return	File
	 * @throws SQLException
	 * @throws IOException
	 */
	public static File get_image(int id) throws SQLException, IOException {
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.get_image( '"+id+"' ) from dual");
		try {
			rs.next();
		} catch (SQLException e) {
			return null;
		}
		try {
		ResultSet ls =(ResultSet) rs.getObject(1);
		ls.next();
		return Convert.toFile(ls.getBlob("IMAGE"));
	}
		catch (SQLException e) {
			return null;
		}
	}
}
