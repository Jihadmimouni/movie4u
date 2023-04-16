package Controller;

import java.net.URL;

import java.time.LocalDate;
import java.util.ResourceBundle;

import Connect.DAOActor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import movie4u.models.Actors;

public class Create_account_actorCntrl implements Initializable {
	  @FXML
	    private TextField name;

	    @FXML
	    private TextField email;

	    @FXML
	    private DatePicker date;

	    @FXML
	    private PasswordField password;

	    @FXML
	    void create(ActionEvent event) {
	    	int s;
	    	LocalDate d1=date.getValue();
	    	String nom=name.getText();
	    	String Email=email.getText();
	    	String date=d1.toString();
	        String mot_de_passe=password.getText();
	    	
	    	Actors e=new Actors();
	    	e.setName(nom);
	    	e.setEmail(Email);
	    	e.setBirthdate(d1);
	    	e.setPassword(mot_de_passe);
	    	 
	    	
	     	s=DAOActor.save(e);
	    	if(s>0) {
	    		Alert al=new Alert(AlertType.INFORMATION);
	    		al.setTitle("add actor !!");
	    		al.setHeaderText("Information !");
	    		al.setContentText("BIEN AJOUTE !!!!!");
	    		al.showAndWait();
	    		/*i.clear();
	    		n.clear();
	        	p.clear();
	        	d.setValue(null);
	        	niv.setValue(null);*/
	    		
	    	}else {
	    		Alert al=new Alert(AlertType.ERROR);
	    		al.setTitle("add actor !!");
	    		al.setHeaderText("Information !");
	    		al.setContentText("NON  AJOUTE !!!!!");
	    		al.showAndWait();
	    		
	    	}

	    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
