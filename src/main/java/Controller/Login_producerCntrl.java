package Controller;

import java.io.IOException;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class Login_producerCntrl implements Initializable {
	 

	  @FXML
	    private TextField name;

	    @FXML
	    private PasswordField password;
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
    void connect(ActionEvent event) throws IOException, SQLException {
    	System.out.println("home");
    	String s = name.getText().toString();
    	String s2 = password.getText().toString();
    	if(Producer.check(s, s2)) {
    		
    		Stage stage=new Stage();
    		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Home_producer.fxml"));
    		 Parent root=(Parent) loader.load();
    		 Home_producerCntrl controller=loader.getController();
    		 controller.MyFunction(name.getText().toString());
    		 controller.Myfunction2(password.getText());
    		 
    		 
    		Scene scene=new Scene(root);
    		stage.setScene(scene);
    		stage.setTitle("home 1.1");
    		stage.show();
    		System.out.println("pssstt");
    		//l.setText("Connecte");
    		/*Stage stage=new Stage();
    		Parent root = (  Parent)FXMLLoader.load(test.class.getResource("/Vue/Home_producer.fxml"));
    		Scene scene=new Scene(root);
    		stage.setScene(scene);
    		stage.setTitle("home 1.1");
    		stage.show();*/
    		
    		
    	}
    	else {
    	//	l.setText("NON tyrrr mabldek");
    		Alert al=new Alert(AlertType.ERROR);
    		al.setTitle("erreur !!!");
    		al.setContentText("password or username ERROR!!");
    		al.showAndWait();
    		System.out.println("rrrrr"); 
    		
    	}
    	
    	 
    	 

  }
 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	 
	}

}
