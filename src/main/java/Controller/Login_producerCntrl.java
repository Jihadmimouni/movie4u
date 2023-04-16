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


public class Login_producerCntrl implements Initializable {
    @FXML
    void ceee(ActionEvent event) throws IOException {
    	System.out.println("creation ");
    	Stage s=new Stage();
        Parent root = (  Parent)FXMLLoader.load(test.class.getResource("/Vue/Create_account_producer.fxml"));
		 
		Scene scene = new Scene(root );
		s.setScene(scene);
		s.setTitle("CREATE ACCOUNT");
		s.show();

   }

    @FXML
    void connect(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
