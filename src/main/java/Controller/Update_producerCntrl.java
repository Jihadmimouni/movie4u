package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Update_producerCntrl implements Initializable {

    @FXML
    private TextField name;  

    @FXML
    private TextField email;

    @FXML
    private TextField path_image;

    @FXML
    private PasswordField password;

    

    @FXML
    void update(ActionEvent event) {

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
    	System.out.println("pssstt");
    }
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
