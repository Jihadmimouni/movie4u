package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import movie4u.models.Media;
import movie4u.models.Season;
import movie4u.models.Synopsis;

public class Add_seasonCntrl implements Initializable {
	public static Media media1 ;
	 @FXML
	    private DatePicker date_start;

	    @FXML
	    private TextField numero;

	    @FXML
	    private TextField path_video;

	    @FXML
	    private TextArea text;

	    @FXML
	    void save_season(ActionEvent event) {
	    int s=18 ;
	    	
	    Synopsis syn=new Synopsis(text.getText());
	    LocalDate a= date_start.getValue();
	    Date date_strt=Date.valueOf(a);
	    String num=numero.getText();
	    int numero=Integer.parseInt(num);
	    
	    Season season=new Season(media1.getName(),media1.getYear(),media1.getLanguage(),media1.getCountry(),media1.getProducer_id(),media1.getImage(),numero,date_strt,syn);
	    if(s>0) {
    		
    		
    		Alert al=new Alert(AlertType.INFORMATION);
    		al.setTitle("add season !!");
    		al.setHeaderText("Information !");
    		al.setContentText("BIEN AJOUTE !!!!!");
    		al.showAndWait();
    		 
    		
    	}else {
    		Alert al=new Alert(AlertType.ERROR);
    		al.setTitle("add season !!");
    		al.setHeaderText("Information !");
    		al.setContentText("NON  AJOUTE !!!!!");
    		al.showAndWait();
    		
    	}
	    

	    }
	    @FXML
	    void add_episode(ActionEvent event) throws IOException {
	    	 System.out.println("erdtfgh");
	    	 Stage stage=new Stage();
	    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Add_episode.fxml"));
	    	 Parent root=(Parent) loader.load();
	    	 Add_episodeCntrl controller=loader.getController();
	    	 controller.media2=media1;
	    	 
	    	Scene scene=new Scene(root);
	    	stage.setScene(scene);
	    	stage.setTitle("home 1.1");
	    	stage.show();
	    	 
	    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
