package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ResourceBundle;

import DAO.Actor;
import DAO.Producer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import movie4u.models.Actors;
import movie4u.models.Producers;

public class Home_actorCntrl implements Initializable {
	 @FXML
	    private Label username;

	    @FXML
	    private Label L1;

	    @FXML
	    void update(ActionEvent event) throws IOException, SQLException {
	    	 
	    	 Stage stage=new Stage();
   		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Update_actor.fxml"));
   		 Parent root=(Parent) loader.load();
   		 Update_actorCntrl controller=loader.getController();
   		 Actors o=Actor.get(username.getText(),L1.getText());    		
   		 
   		 
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
	    @FXML
	    void quit(ActionEvent event) {
        System.exit(0);
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
