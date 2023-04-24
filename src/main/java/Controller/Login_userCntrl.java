package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Application.test;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import movie4u.models.Users;

public class Login_userCntrl implements Initializable {
	 @FXML
	    private TextField name;

	    @FXML
	    private PasswordField password;

	    @FXML
	    void create_account(ActionEvent event) throws IOException {
	    	System.out.println("creation ");
	    	Stage s=new Stage();
	        Parent root = (  Parent)FXMLLoader.load(test.class.getResource("/Vue/Create_account_user.fxml"));
			 
			Scene scene = new Scene(root );
			s.setScene(scene);
			s.setTitle("CREATE ACCOUNT");
			s.show();

	    }

	    @FXML
	    void log_in(ActionEvent event) throws IOException, SQLException {
	    	System.out.println("Logging in ... ");
	    	
	    	
	    if (DAO.User.check(name.getText().toString(),password.getText().toString())) {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Home_User.fxml"));
	    	Parent root = loader.load();
           //Parent root = (  Parent)FXMLLoader.load(test.class.getResource("/Vue/Home_User.fxml"));
				Scene scene = new Scene(root );
				
				
				Users user = DAO.User.get(name.getText().toString(),password.getText().toString());
				
				 Home_UserCntrl userCntrl = loader.getController();
				userCntrl.user = user ;
				
				userCntrl.welcome(user.getName(), user.getImage());
				Stage s=new Stage();
				s.setScene(scene);
				s.setTitle("CREATE ACCOUNT");
				s.show();       
	    		
	    	}
	    	
	   	else {
	    		Alert al=new Alert(AlertType.ERROR);
	    		al.setTitle("Erreur 404");
	    		al.setContentText("incorrect password or username");
	    		al.showAndWait();
	    	}
	    	
	    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
