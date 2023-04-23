package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Add_rolesCntrl implements Initializable {
	  @FXML
	    private TextField name;

	    @FXML
	    private ComboBox<String> role;

	    @FXML
	    void save_role(ActionEvent event) {
	    	System.out.println("rrrrr"); 

	    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
