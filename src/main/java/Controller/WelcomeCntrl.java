package Controller;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import Application.test;
 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WelcomeCntrl implements Initializable {
	 @FXML
	    void actor(ActionEvent event) throws IOException {
		 System.out.println("erdtfgh");
		 Stage s=new Stage();
         Parent root = (  Parent)FXMLLoader.load(test.class.getResource("/Vue/Login_actor.fxml"));
			 
			Scene scene = new Scene(root );
			s.setScene(scene);
			//s.setTitle(" PROD");
			s.show();
	    }

	    @FXML
	    void producer(ActionEvent event) throws IOException   {
	    	   Stage s=new Stage();
	           Parent root = (  Parent)FXMLLoader.load(test.class.getResource("/Vue/Login_producer.fxml"));
				 
				Scene scene = new Scene(root );
				s.setScene(scene);
				s.setTitle(" PROD");
				s.show();
	    }

	    @FXML
	    void user(ActionEvent event) throws IOException {
	    	 Stage s=new Stage();
	           Parent root = (  Parent)FXMLLoader.load(test.class.getResource("/Vue/Login_user.fxml"));
				 
				Scene scene = new Scene(root );
				s.setScene(scene);
			//	s.setTitle(" PROD");
				s.show();
	    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

}

}
