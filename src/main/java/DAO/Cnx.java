package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Cnx {

		private static Connection connexion;

	    private final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	    private static String USER = "newuser";
		private static String PASS = "1234";
	   
		public static void setUSER(String uSER) {
			USER = uSER;
		}

		public static void setPASS(String pASS) {
			PASS = pASS;
		}
	    private Cnx() throws SQLException{

	        try{
	               Class.forName("oracle.jdbc.OracleDriver");
	        } catch (ClassNotFoundException e) {
	        	System.out.println("Oops , ERROR 404 !!!");
	            e.printStackTrace();
	        }

	        connexion= DriverManager.getConnection(DB_URL, USER, PASS);

	    }
	    
	    
	    

	    public static Connection getInstance(){
	        if (connexion == null)
	            try {
	                new Cnx();
	            }catch(Exception e){
	                System.out.println("--"+e.getMessage());
	            }
	        return connexion;
	    }
	}

