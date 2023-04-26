package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Media {
	
	/**
	 * @param id
	 * @return List<Media>
	 * @throws SQLException
	 */
	public static ResultSet get_dao(int id ) throws SQLException {
	Connection con = Cnx.getInstance();
	java.sql.Statement cstmt = con.createStatement();
	ResultSet rs = cstmt.executeQuery("select movie4u.get_media_id('"+id+"') from dual");
	rs.next();
	rs = (ResultSet) rs.getObject(1);
	return rs;
	}
	/**
	 * @param name
	 * @return List<Media>
	 * @throws SQLException
	 * @throws IOException
	 */
	public static List<movie4u.models.Media> get_byname(String name) throws SQLException, IOException{
		List<movie4u.models.Media> l= new ArrayList<movie4u.models.Media>();
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.get_media_name('"+name+"') from dual");
		rs.next();
		rs = (ResultSet) rs.getObject(1);
		while (rs.next()) {
			if (rs.getString("TYPE")=="SERIE") {
				cstmt = con.createStatement();
				ResultSet ls = cstmt.executeQuery("select movie4u.get_serie('"+rs.getInt("id")+"') from dual");
				ls.next();
				ls =(ResultSet) ls.getObject(1);
				l.add(Serie.convert(ls));
			}
			else if (rs.getString("TYPE")=="FILM") {
				cstmt = con.createStatement();
				ResultSet ls = cstmt.executeQuery("select movie4u.get_FILM('"+rs.getInt("id")+"') from dual");
				ls.next();
				ls =(ResultSet) ls.getObject(1);
				l.add(Film.convert(ls));
			}
			else {
				continue;
			}
		}
		
		
		return l;
	}
	
	/**
	 * @param name
	 * @return List<Media>	
	 * @throws SQLException
	 * @throws IOException
	 */
	public static List<movie4u.models.Media> get_BYactor_name(String name) throws SQLException, IOException{
		List<movie4u.models.Media> l= new ArrayList<movie4u.models.Media>();
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet ks = cstmt.executeQuery("select movie4u.get_media_actor('"+name+"') from dual");
		ks.next();
		ks = (ResultSet) ks.getObject(1);
		
		while (ks.next()){
			cstmt = con.createStatement();
			ResultSet rs = cstmt.executeQuery("select movie4u.get_media_id('"+ks.getInt("MEDIA_ID")+"') from dual");
			rs.next();
			rs = (ResultSet) ks.getObject(1);
		while (rs.next()) {
			if (rs.getString("TYPE")=="SERIE") {
				cstmt = con.createStatement();
				ResultSet ls = cstmt.executeQuery("select movie4u.get_serie('"+rs.getInt("ID")+"') from dual");
				ls.next();
				ls =(ResultSet) ls.getObject(1);
				l.add(Serie.convert(ls));
			}
			else if (rs.getString("TYPE")=="FILM") {
				cstmt = con.createStatement();
				ResultSet ls = cstmt.executeQuery("select movie4u.get_FILM('"+rs.getInt("id")+"') from dual");
				ls.next();
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

	/**
	 * @param name
	 * @return List<Media>
	 * @throws SQLException
	 * @throws IOException
	 */
	public static List<movie4u.models.Media> get_byproducer_name(String name) throws SQLException, IOException{
		List<movie4u.models.Media> l= new ArrayList<movie4u.models.Media>();
		Connection con = Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet rs = cstmt.executeQuery("select movie4u.get_media_producer('"+name+"') from dual");
		rs.next();
		rs = (ResultSet) rs.getObject(1);
		while (rs.next()) {
			if (rs.getString("TYPE")=="SERIE") {
				cstmt = con.createStatement();
				ResultSet ls = cstmt.executeQuery("select movie4u.get_serie('"+rs.getInt("id")+"') from dual");
				ls.next();
				ls =(ResultSet) ls.getObject(1);
				l.add(Serie.convert(ls));
			}
			else if (rs.getString("TYPE")=="FILM") {
				cstmt = con.createStatement();
				ResultSet ls = cstmt.executeQuery("select movie4u.get_FILM('"+rs.getInt("id")+"') from dual");
				ls.next();
				ls =(ResultSet) ls.getObject(1);
				l.add(Film.convert(ls));
			}
			else {
				continue;
			}
		}
		
		
		return l;
	}
	
	/**
	 * @param genre
	 * @return List<Media>
	 * @throws SQLException
	 * @throws IOException
	 */
	public static List<movie4u.models.Media> get_bygenre(String genre) throws SQLException, IOException{
		List<movie4u.models.Media> l= new ArrayList<movie4u.models.Media>();
		Connection con=Cnx.getInstance();
		java.sql.Statement cstmt = con.createStatement();
		ResultSet ls = cstmt.executeQuery("select movie4u.get_serie_genre('"+Genre.get_id(new movie4u.models.Genre(genre))+"') from dual");
		ls.next();
		ls =(ResultSet) ls.getObject(1);
		while(ls.next())
			l.add(Serie.convert(ls));
		cstmt = con.createStatement();
		ls = cstmt.executeQuery("select movie4u.get_film_genre('"+Genre.get_id(new movie4u.models.Genre(genre))+"') from dual");
		ls.next();
		ls =(ResultSet) ls.getObject(1);
		while(ls.next())	
			l.add(Film.convert(ls));
		
		
		return l;
	}
	
	
	
	
	
	
	
}
