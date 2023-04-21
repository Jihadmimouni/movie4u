package Controller;




import java.io.IOException;

import Application.test;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class Home_UserCntrl {

    @FXML
    void edit(ActionEvent event) throws IOException {
    	 System.out.println("profile");
		 Stage s=new Stage();
         Parent root = (  Parent)FXMLLoader.load(test.class.getResource("/Vue/User_profile.fxml"));
			Scene scene = new Scene(root );
			s.setScene(scene);
			s.show();
    }

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
    void quit(ActionEvent event) {
                       
    }

    @FXML
    void serie(ActionEvent event) {
                   
    }
    @FXML
    void film(ActionEvent event) {

    }


}
