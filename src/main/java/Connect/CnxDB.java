package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CnxDB {
	private static Connection connexion;

    private final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String USER = "test1";
    private final String PASS = "test1";

    private CnxDB() throws SQLException{

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
                new CnxDB();
            }catch(Exception e){
                System.out.println("--"+e.getMessage());
            }
        return connexion;
    }
}
