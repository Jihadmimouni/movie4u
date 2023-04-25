package Controller;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Application.test;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import movie4u.models.Users;


public class Home_UserCntrl implements Initializable {
	
	public static Users user ;
	  @FXML
	    private ImageView imageuser;

	    @FXML
	    private Button searchbtn;

	    @FXML
	    private Label wlcmtxt;
	    @FXML
	    private AnchorPane homeuserform;



    @FXML
    void log_out(ActionEvent event) throws IOException {
    	 System.out.println("return to welcome page ");
		 Stage s=new Stage();
         Parent root = (  Parent)FXMLLoader.load(test.class.getResource("/Vue/Welcome.fxml"));
			Scene scene = new Scene(root );
			s.setScene(scene);
			s.show();
    }

    @FXML
    void profile(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/User_profile.fxml"));
    	Parent root = loader.load();
    	User_profileCntrl Userprofile = loader.getController();
    	Userprofile.displayINFO(user) ;
    }

    @FXML
    void quit(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) throws IOException {
    	System.out.println("search ..");
    	
    	if(event.getSource()==searchbtn) {
    	//	homeuserform.setVisible(false);
    		Stage s=new Stage();
            Parent root = (  Parent)FXMLLoader.load(test.class.getResource("/Vue/SearchView.fxml"));
    		 
    		Scene scene = new Scene(root );
    		s.setScene(scene);
    		s.setTitle("SEARCH");
    		s.show();
    	}
    	
    }
    
    @FXML
    void news(ActionEvent event) {

    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
    void welcome(String usename , File image) {
    	wlcmtxt.setText("Welcome "+"username ");
    	Image img = new Image(image.toString());
    	imageuser = new ImageView(img);
    	
    }
}

