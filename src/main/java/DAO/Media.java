package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Media {
	
	public static ResultSet get_dao(int id ) throws SQLException {
	Connection con = Cnx.getInstance();
	java.sql.Statement cstmt = con.createStatement();
	ResultSet rs = cstmt.executeQuery("select movie4u.get_media_id('"+id+"') from dual");
	rs = (ResultSet) rs.getObject(1);
	return rs;
	}
	public static List<movie4u.models.Media> get_name(String name){
		List<movie4u.models.Media> l= new ArrayList<movie4u.models.Media>();
		
		
		
		
		
		
		
		
		
		
		return l;
	}
}
