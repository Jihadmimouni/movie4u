package Controller;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import DAO.Producer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import movie4u.models.Producers;

public class Update_producerCntrl implements Initializable {
	@FXML
 private TextField password;
 public static	LocalDate date ;
 public static File f ;
    @FXML
    private TextField name;  

    @FXML
    private TextField email;

    @FXML
    private TextField path_image;

    
    @FXML
    private DatePicker birthdate;


    

    @FXML
    void update(ActionEvent event) throws SQLException {
    	
    	
    	if((path_image.getText().isEmpty()==true) || (birthdate.getValue().equals(date))) {
    		Date bithdate=Date.valueOf(date);
    		 Producers o =new Producers(name.getText(),email.getText(),password.getText(),bithdate,f);
    		 Producer.update(o);
    	 
    	}
    	else {
    		 File f1=new File(path_image.getText());
    		 Date bithdate=Date.valueOf(birthdate.getValue());
    		 Producers o =new Producers(name.getText(),email.getText(),password.getText(),bithdate,f1);
    		 Producer.update(o);
    		
    	}
    	
    	

    }
    public void name(String v) {
    	name.setText(v);
    	
    }
    
    public void email(String v) {
    	email.setText(v);
    	
    }
    public void path_image(String v) {
    	path_image.setText(v);
    }
    
    public void password(String v) {
    	password.setText(v);
    	 
    }
     
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
