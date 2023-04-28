package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
	try {

	rs.next();
	rs = (ResultSet) rs.getObject(1);
	return rs;
	}
	catch (Exception e) {
		return null;
	}
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
		try {
		rs.next();
		rs = (ResultSet) rs.getObject(1);
		}
		catch (Exception e) {
			return l;
		}
		while (rs.next()) {
			String type;
			try {
				type = rs.getString("TYPE");
			} catch (SQLException e) {
				continue;
			}
			if (Objects.equals(type, "SERIE")) {
				cstmt = con.createStatement();
				ResultSet ls = cstmt.executeQuery("select movie4u.get_serie('" + rs.getInt("id") + "') from dual");
				ls.next();
				ls = (ResultSet) ls.getObject(1);
				l.add(Serie.convert(ls));
			} else if (Objects.equals(type, "FILM")) {
				cstmt = con.createStatement();
				ResultSet ls = cstmt.executeQuery("select movie4u.get_FILM('" + rs.getInt("id") + "') from dual");
				ls.next();
				ls = (ResultSet) ls.getObject(1);
				l.add(Film.convert(ls));
			} else {
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
		try {
			ks.next();
			ks = (ResultSet) ks.getObject(1);
		}
		catch (Exception e) {
			return l;
		}
		while (ks.next()){
			cstmt = con.createStatement();
			ResultSet rs = cstmt.executeQuery("select movie4u.get_media_id('"+ks.getInt("MEDIA_ID")+"') from dual");
			try {
				rs.next();
				rs = (ResultSet) rs.getObject(1);
			}
			catch (Exception e) {
				continue;
			}
		while (rs.next()) {
			String type;
			try {
				type = rs.getString("TYPE");
			} catch (SQLException e) {
				continue;
			}
			if (Objects.equals(type, "SERIE")) {
				cstmt = con.createStatement();
				ResultSet ls = cstmt.executeQuery("select movie4u.get_serie('"+rs.getInt("ID")+"') from dual");
				try {
				ls.next();
				ls =(ResultSet) ls.getObject(1);
				}
				catch (Exception e) {
					continue;
				}
				l.add(Serie.convert(ls));
			}
			else if (Objects.equals(type, "FILM")) {
				cstmt = con.createStatement();
				ResultSet ls = cstmt.executeQuery("select movie4u.get_FILM('"+rs.getInt("id")+"') from dual");
				try {
				ls.next();
				ls =(ResultSet) ls.getObject(1);
				}
				catch (Exception e) {
					continue;
				}
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
		try {
			rs.next();
			rs = (ResultSet) rs.getObject(1);
		}
		catch (Exception e) {
			return l;
		}
		while (rs.next()) {
			String type;
			try {
				type = rs.getString("TYPE");
			} catch (SQLException e) {
				continue;
			}
			if (Objects.equals(type, "SERIE")) {
				cstmt = con.createStatement();
				ResultSet ls = cstmt.executeQuery("select movie4u.get_serie('" + rs.getInt("id") + "') from dual");
				ls.next();
				ls = (ResultSet) ls.getObject(1);
				l.add(Serie.convert(ls));
			} else if (Objects.equals(type, "FILM")) {
				cstmt = con.createStatement();
				ResultSet ls = cstmt.executeQuery("select movie4u.get_FILM('" + rs.getInt("id") + "') from dual");
				ls.next();
				ls = (ResultSet) ls.getObject(1);
				l.add(Film.convert(ls));
			} else {
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
		try {
			ls.next();
			ls =(ResultSet) ls.getObject(1);
		}
		catch (Exception e) {
			return l;
		}
		while(ls.next())
			l.add(Serie.convert(ls));
		cstmt = con.createStatement();
		ls = cstmt.executeQuery("select movie4u.get_film_genre('"+Genre.get_id(new movie4u.models.Genre(genre))+"') from dual");
		try {
			ls.next();
			ls =(ResultSet) ls.getObject(1);
		}
		catch (Exception e) {
			return l;
		}
		while(ls.next())	
			l.add(Film.convert(ls));
		
		
		return l;
	}
	
	
	
	
	
	
	
}
