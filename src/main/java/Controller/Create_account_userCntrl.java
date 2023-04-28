package Controller;


import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import DAO.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import movie4u.models.Users;

public class Create_account_userCntrl implements Initializable {
	@FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private DatePicker date;

    @FXML
    private PasswordField password;
    @FXML
    private PasswordField imagefile;
    @FXML
    private Label L1;

    @FXML
    private Label L2;
    

    @FXML
    void create(ActionEvent event) throws SQLException {
   
    	
    	int length =password.getText().length();
    	
    	if( length>=8) {
    	int s = 0;
    	 LocalDate d1=date.getValue();
    	String nom=name.getText();
    	String Email=email.getText();
    	Date d=Date.valueOf(d1);
        String mot_de_passe=password.getText();
        File imageFile;
        try {
        	imageFile = new File(imagefile.getText().toString());
        }
        catch(Exception e){
        	imageFile = null;
        }
    	Users e=new Users(nom,Email, mot_de_passe,d,imageFile);
    	
    	 
    	

			DAO.User.insert(e);

     	if(User.check(nom, mot_de_passe)) {
    		Alert al=new Alert(AlertType.INFORMATION);
    		al.setTitle("add producer !!");
    		al.setHeaderText("Information !");
    		al.setContentText("Well Added !!!!!");
    		al.showAndWait();
    		 
    		
    	}else {
    		Alert al=new Alert(AlertType.ERROR);
    		al.setTitle("add producer !!");
    		al.setHeaderText("Information !");
    		al.setContentText("NOT Added !!!!!");
    		al.showAndWait();
    		
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
