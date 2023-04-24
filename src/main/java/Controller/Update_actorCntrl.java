package Controller;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import DAO.Actor;
import DAO.Producer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import movie4u.models.Actors;
import movie4u.models.Producers;

public class Update_actorCntrl implements Initializable {
	 @FXML
	    private TextField name;
	 public static	LocalDate date ;
	 public static File f ;

	    @FXML
	    private TextField email;

	    @FXML
	    private TextField password;

	    @FXML
	    private TextField path_image;

	    @FXML
	    private DatePicker birthdate;

	    @FXML
	    void update(ActionEvent event) throws SQLException {

	    	
	    	if((path_image.getText().isEmpty()==true) || (birthdate.getValue().equals(date))) {
	    		Date bithdate=Date.valueOf(date);
	    		 Actors o =new Actors(name.getText(),email.getText(),password.getText(),bithdate,f);
	    		 Actor.update(o);
	    	 
	    	}
	    	else {
	    		 File f1=new File(path_image.getText());
	    		 Date bithdate=Date.valueOf(birthdate.getValue());
	    		 Actors o =new Actors(name.getText(),email.getText(),password.getText(),bithdate,f1);
	    		 Actor.update(o);
	    		
	    	}
	    	

	    }
	    public void name(String v) {
	    	name.setText(v);
	    	
	    }
	    
	    public void email(String v) {
	    	email.setText(v);
	    	
	    }
	    
	    
	    public void password(String v) {
	    	password.setText(v);
	    	 
	    }
	     

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
