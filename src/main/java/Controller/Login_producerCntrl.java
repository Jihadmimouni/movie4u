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
    	Connection c=CnxDB.getInstance();
    	 
    	// s=null;
    	// rs=null;
    	
    	String sql="select producer.id from producer where name like :1 and password like :2" ;
    	PreparedStatement s=c.prepareStatement(sql);
    	//int r=Integer.parseInt(name.getText()); 
    	//s.setInt(1,r);
    	s.setString(1,name.getText().toString());
    	s.setString(2,password.getText().toString());
    	ResultSet rs=s.executeQuery();
    	if(rs.next()) {
    		
    		Stage stage=new Stage();
    		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Home_producer.fxml"));
    		 Parent root=(Parent) loader.load();
    		 Home_producerCntrl controller=loader.getController();
    		 controller.MyFunction(name.getText().toString());
    		 
    		Scene scene=new Scene(root);
    		stage.setScene(scene);
    		stage.setTitle("home 1.1");
    		stage.show();
    		
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
    		
    	}
    	
    	 
    	 

  }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
