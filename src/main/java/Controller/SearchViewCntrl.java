package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import movie4u.models.Users;

public class SearchViewCntrl {

    @FXML
    private TextField searchActor;

    @FXML
    private TextField searchGenre;

    @FXML
    private TextField searchProducer;

    @FXML
    private TextField searchname;

    @FXML
    void SearchbyActor(ActionEvent event) {
           
    }

    @FXML
    void SearchbyGenre(ActionEvent event) {

    }

    @FXML
    void SearchbyName(ActionEvent event) {
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

    @FXML
    void SearchbyProducer(ActionEvent event) {

    }

}
