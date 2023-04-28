package DAO;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Synopsis {
	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public static movie4u.models.Synopsis get(int id) throws SQLException, IOException {
		 Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.get_synopsis('"+id+"') from dual");

		rs.next();
		rs = (ResultSet) rs.getObject(1);
		File video = null;
		String text = null;
		boolean isText = true;

		try {
			video = DAO.video.get(rs.getInt("VIDEO_ID"));
		} catch (Exception e) {
			System.out.println("Error getting video: " );
		}

		try {
			text = rs.getString("TEXT");
		} catch (Exception e) {
			System.out.println("Error getting text: " );
		}

		try {
			isText = Objects.equals(rs.getString("isText"), "TRUE");
		} catch (Exception e) {
			System.out.println("Error getting isText: " );
		}

		return new movie4u.models.Synopsis(video, text, isText);

	}

	}

