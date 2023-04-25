package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Connect.CnxDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class Media_playerCntrl implements Initializable  {

    @FXML
    private MediaView mediaView;

    @FXML
    private Button pauseButton;

    @FXML
    private Button playButton;

    @FXML
    private Button resretButton;
    
    private File file ;
    private MediaPlayer mediaPlayer;
    private Media media ;
    

   

	@Override
	public void initialize(URL location, ResourceBundle resources) {	
	/*	// Establish a database connection using JDBC
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##projet", "projet1");
			// Create a statement to execute a SELECT query
			PreparedStatement stmt;
			
				stmt = conn.prepareStatement("SELECT video FROM video WHERE id = ? ");
			

			int id = 1;
			
			stmt.setInt(1, id );
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
			    Blob blob = rs.getBlob("video");
			    InputStream is = blob.getBinaryStream();
			   
			   // OutputStream os = new FileOutputStream("video.mp4");
			   // byte[] buffer = new byte[4096];
			    //int bytesRead = -1;
			   // file.write(os.getBytes());
			 //   String s = fonction(blob);
			   // FileOutputStream os = new FileOutputStream("movie.mp4");
			 //   os.read(s.getBytes());
			    file = fonction(blob);
			//    file.deleteOnExit();*/
		      //  file = 
				media=new Media(file.toURI().toString());
				mediaPlayer = new MediaPlayer(media);
				mediaView.setMediaPlayer(mediaPlayer);
			   //while ((bytesRead = is.read(buffer)) != -1) {
			    //   os.write(buffer, 0, bytesRead);
			   // }
			    
			    /*os.close();
			    is.close();
			    os.flush();
			    os.close();*/
		//	}

			// Close the database connection
		//	conn.close();

			
			
	/*	} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		
		
		
	}
	
	 @FXML
	    void pauseMedia(ActionEvent event) {
                mediaPlayer.pause();
	    }

	    @FXML
	    void playMedia(ActionEvent event) {
                mediaPlayer.play();
	    }

	    @FXML
	    void resetMedia(ActionEvent event) {
	    	
	    	if(mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
	    		 mediaPlayer.seek(Duration.seconds(0.0));
	    	}
             
	    }
	    
	 void   Setmedia() {
		 
	 }
	    
	/*    public static File fonction(Blob blob) throws SQLException, IOException {
		    System.out.println("Read "+ blob.length() + " bytes ");
		    byte [] array = blob.getBytes( 1, ( int ) blob.length() );
		    File file = File.createTempFile("video", ".mp4", new File("."));
		    FileOutputStream out = new FileOutputStream( file );
		    out.write( array );
		    out.close();
		    file.deleteOnExit();
		    return file;
	}*/

}