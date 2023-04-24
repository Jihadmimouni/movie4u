package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Synopsis {
	public static movie4u.models.Synopsis get(int id) throws SQLException, IOException {
		 Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.get_synopsis('"+id+"') from dual");
		rs = (ResultSet) rs.getObject(1);
		return new movie4u.models.Synopsis(video.get(rs.getInt("VIDEO_ID")), rs.getString("TEXT"), rs.getBoolean("isText"));
		}

	}

