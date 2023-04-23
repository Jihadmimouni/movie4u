package Controller;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import movie4u.models.Films;
import movie4u.models.Series;

public class SearchViewCntrl {

    @FXML
    private TextField searchbar;

    @FXML
    void Search(ActionEvent event) {
    	System.out.println("Search ...");
    	searchbar.getText().toString();
    	//if (UserDao.exists(name,password)) {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/ResultView.fxml"));
    	Parent root = loader.load();
		Scene scene = new Scene(root );
			
			
		List<Films> film = new ArrayList<>() ;
		List<Series> series = new ArrayList<>() ;
		
			 Home_UserCntrl userCntrl = loader.getController();
			userCntrl.user = user ;
			
			userCntrl.welcome(user.getName(), user.getImage());
			Stage s=new Stage();
			s.setScene(scene);
			s.setTitle("CREATE ACCOUNT");
			s.show();       
    }

}

