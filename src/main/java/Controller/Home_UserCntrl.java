package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Application.test;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import movie4u.models.Users;

public class Home_UserCntrl implements Initializable {

    @FXML
    void edit(ActionEvent event) throws IOException {
    	System.out.println("profile");
		 Stage s=new Stage();
        Parent root = (  Parent)FXMLLoader.load(test.class.getResource("/Vue/User_profile.fxml"));
			Scene scene = new Scene(root );
			s.setScene(scene);
			s.show();
    }

    @FXML
    void log_out(ActionEvent event) throws IOException {
    	 System.out.println("return to welcome page ");
		 Stage s=new Stage();
         Parent root = (  Parent)FXMLLoader.load(test.class.getResource("/Vue/Welcome.fxml"));
			Scene scene = new Scene(root );
			s.setScene(scene);
			s.show();
    }

    @FXML
    void profile(ActionEvent event) {
              
    }

    @FXML
    void quit(ActionEvent event) {

    }

    @FXML
    void searchFilm(ActionEvent event) {

    }

    @FXML
    void searchSerie(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	void  getUser(String name , String email ,String pswrd , LocalDate date , File img) {

	}
    
    
}
