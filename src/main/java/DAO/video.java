package DAO;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class video {
	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public static File get(int id) throws SQLException, IOException {
		 Connection con = Cnx.getInstance();
		 java.sql.Statement cstmt = con.createStatement();
		 ResultSet rs = cstmt.executeQuery("select movie4u.get_video('"+id+"') from dual");
		 rs.next();
		 rs = (ResultSet) rs.getObject(1);
		 return Convert.toFile(rs.getBlob("video"));
	}
}
