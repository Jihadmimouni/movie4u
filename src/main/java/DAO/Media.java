package DAO;

import java.io.IOException;
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
	public static List<movie4u.models.Media> get_name(String name) throws SQLException, IOException{
		List<movie4u.models.Media> l= new ArrayList<movie4u.models.Media>();
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.get_media_name('"+name+"') from dual");
		rs = (ResultSet) rs.getObject(1);
		while (rs.next()) {
			if (rs.getString("TYPE")=="SERIE") {
				cstmt = con.createStatement();
				ResultSet ls = cstmt.executeQuery("select movie4u.get_serie('"+rs.getInt("id")+"') from dual");
				ls =(ResultSet) ls.getObject(1);
				l.add(Serie.convert(ls));
			}
			else if (rs.getString("TYPE")=="FILM") {
				cstmt = con.createStatement();
				ResultSet ls = cstmt.executeQuery("select movie4u.get_FILM('"+rs.getInt("id")+"') from dual");
				ls =(ResultSet) ls.getObject(1);
				l.add(Film.convert(ls));
			}
			else {
				continue;
			}
		}
		
		
		return l;
	}
	
	public static List<movie4u.models.Media> get_actor_name(String name) throws SQLException, IOException{
		List<movie4u.models.Media> l= new ArrayList<movie4u.models.Media>();
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet ks = cstmt.executeQuery("select movie4u.get_media_actor('"+name+"') from dual");
		ks = (ResultSet) ks.getObject(1);
		
		while (ks.next()){
			cstmt = con.createStatement();
			ResultSet rs = cstmt.executeQuery("select movie4u.get_media_id('"+ks.getInt("MEDIA_ID")+"') from dual");
			rs = (ResultSet) ks.getObject(1);
		while (rs.next()) {
			if (rs.getString("TYPE")=="SERIE") {
				cstmt = con.createStatement();
				ResultSet ls = cstmt.executeQuery("select movie4u.get_serie('"+rs.getInt("ID")+"') from dual");
				ls =(ResultSet) ls.getObject(1);
				l.add(Serie.convert(ls));
			}
			else if (rs.getString("TYPE")=="FILM") {
				cstmt = con.createStatement();
				ResultSet ls = cstmt.executeQuery("select movie4u.get_FILM('"+rs.getInt("id")+"') from dual");
				ls =(ResultSet) ls.getObject(1);
				l.add(Film.convert(ls));
			}
			else {
				continue;
			}
		}
		
	}
		return l;
	}

	
	
	
	
	
	
	
	
	
}
