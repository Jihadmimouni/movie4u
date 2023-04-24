package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ResourceBundle;

import Application.test;
import Connect.CnxDB;
import DAO.Producer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import movie4u.models.Producers;

public class Home_producerCntrl implements Initializable {
	 
	 @FXML
	    private Label L1;


	    @FXML
	    private Label username;
	  @FXML
	    private AnchorPane ap;

	    @FXML
	    void add_media(ActionEvent event) throws IOException {
	    	 System.out.println("erdtfgh");
	    	 Stage stage=new Stage();
    		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Add_media.fxml"));
    		 Parent root=(Parent) loader.load();
    		 Add_mediaCntrl controller=loader.getController();
    		 controller.getName_producer(username.getText().toString());
    		 
    		Scene scene=new Scene(root);
    		stage.setScene(scene);
    		stage.setTitle("home 1.1");
    		stage.show();
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
			/* Stage s=new Stage();
	         Parent root = (  Parent)FXMLLoader.load(test.class.getResource("/Vue/Add_media.fxml"));
				 
				Scene scene = new Scene(root );
				s.setScene(scene);
				//s.setTitle(" PROD");
				s.show();*/
	    }

	    @FXML
	    void consult_episode_opinion(ActionEvent event) {

	    }

	    @FXML
	    void consult_film_opinion(ActionEvent event) {

	    }

	    @FXML
	    void consult_season_opinion(ActionEvent event) {

	    }

	    @FXML
	    void consult_serie_opinion(ActionEvent event) {

	    }

	    @FXML
	    void quit(ActionEvent event) {
	    	System.exit(0);

	    }

	    @FXML
	    void update(ActionEvent event) throws SQLException, IOException {
	    	/// System.out.println("erdtfgh");
	    	System.out.println("rrrrr"); 
	    	 Stage stage=new Stage();
    		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Update_producer.fxml"));
    		 Parent root=(Parent) loader.load();
    		 Update_producerCntrl controller=loader.getController();
    		 Producers o=Producer.get(username.getText(),L1.getText());    		
    		 
    		 
    		 controller.name(o.getName());
    		 controller.email(o.getEmail());
    		 controller.password(o.getPassword());
    		 controller.date=o.getBirthdate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    		 controller.f=o.getImage();
    		 
    		 
    		Scene scene=new Scene(root);
    		stage.setScene(scene);
    		stage.setTitle("home 1.1");
    		stage.show();

	    }
	    
		public void MyFunction(String a) {
			username.setText(a);
		}
		public void Myfunction2(String v) {
			L1.setText(v);
		}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
