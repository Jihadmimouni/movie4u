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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Home_producerCntrl implements Initializable {
	  @FXML
	    private AnchorPane ap;

	    @FXML
	    void add_media(ActionEvent event) throws IOException {
	    	 System.out.println("erdtfgh");
			 Stage s=new Stage();
	         Parent root = (  Parent)FXMLLoader.load(test.class.getResource("/Vue/Add_media.fxml"));
				 
				Scene scene = new Scene(root );
				s.setScene(scene);
				//s.setTitle(" PROD");
				s.show();
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

	    }

	    @FXML
	    void update(ActionEvent event) {

	    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
