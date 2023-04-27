package Controller;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Connect.CnxDB;
 
import DAO.Actor;
import DAO.Producer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import movie4u.models.Actors;
import movie4u.models.Producers;

public class Create_account_actorCntrl implements Initializable {
	  @FXML
	    private TextField name;

	    @FXML
	    private TextField email;

	    @FXML
	    private DatePicker date;

	    
	    @FXML
	    private Label L1;

	    @FXML
	    private Label L2;

	    @FXML
	    private TextField path_image;

	    @FXML
	    private TextField password;
	    
	    
	    

	    @FXML
	    void create(ActionEvent event) throws SQLException {
	    	
	    	 
	    	int length =password.getText().length();
	    	
	    	if((Actor.check(name.getText(),password.getText())==false) && (length>=8)) {
	    	 
	    		 
	    	int s = 0;
	    	LocalDate d1=date.getValue();
	    	String nom=name.getText();
	    	String Email=email.getText();
	    	String date=d1.toString();
	        String mot_de_passe=password.getText();
	        File f=(File) Control.catchnull(new File(path_image.getText()));
	        Date d=Date.valueOf(d1);
	        
	        Actors p=new Actors(nom,Email,mot_de_passe,d,f);
	        Actor.insert(p);
	    	
	    	
	    	if(s>0) {
	    		Alert al=new Alert(AlertType.INFORMATION);
	    		al.setTitle("add actor !!");
	    		al.setHeaderText("Information !");
	    		al.setContentText("Well Added !!!!!");
	    		al.showAndWait();
	    		 
	    		
	    	}else {
	    		Alert al=new Alert(AlertType.ERROR);
	    		al.setTitle("add actor !!");
	    		al.setHeaderText("Information !");
	    		al.setContentText("NOT Added !!!!!");
	    		al.showAndWait();
	    		
	    	}
	    	}
	    	else {
	    		if(Actor.check(name.getText(),password.getText())==false) {
	    		L1.setText("Name already existed");
	    		name.clear();
	    		}
	    		
	    	}
	    	if(length<8) {
	    		L2.setText("Length password must be more than 8 characters ");
	    		password.clear();
	    	}

	    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
