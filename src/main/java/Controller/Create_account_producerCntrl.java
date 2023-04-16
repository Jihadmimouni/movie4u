package Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Connect.DAOProducer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import movie4u.models.Producers;

public class Create_account_producerCntrl implements Initializable {
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
    	
    	Producers e=new Producers();
    	e.setName(nom);
    	e.setEmail(Email);
    	e.setBirthdate(d1);
    	e.setPassword(mot_de_passe);
    	 
    	
    	s=DAOProducer.save(e);
    	if(s>0) {
    		Alert al=new Alert(AlertType.INFORMATION);
    		al.setTitle("add producer !!");
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
    		al.setTitle("add producer !!");
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
