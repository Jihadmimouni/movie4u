package Controller;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import movie4u.models.Episode;
import movie4u.models.Media;
import movie4u.models.Synopsis;

public class Add_episodeCntrl implements Initializable {
	 @FXML
	    private AnchorPane ppps;

	public static Media media2 ;
	@FXML
    private DatePicker broadcast_date;
	
	 @FXML
	    private TextField title;
 
	    @FXML
	    private TextField path_video;

	    @FXML
	    private TextField path_synopsis_video;

	    @FXML
	    private TextArea text;

	    @FXML
	    void save_episode(ActionEvent event) {
	    	/////System.out.println("pssstt");
	    	
	    	int s =16;
	    	LocalDate l=broadcast_date.getValue();
	    	Date date_broadcast=Date.valueOf(l);
	    	Synopsis syn=new Synopsis(text.getText().toString());
	    	File f=new File(path_video.getText().toString());
	    	Episode episode=new Episode(media2.getName(),media2.getYear(),media2.getLanguage(),media2.getCountry(),media2.getProducer_id(),media2.getImage(),title.getText().toString(),date_broadcast,syn,f);
  
	    	 if(s>0) {
	     		
	     		
	     		Alert al=new Alert(AlertType.INFORMATION);
	     		al.setTitle("add episode !!");
	     		al.setHeaderText("Information !");
	     		al.setContentText("BIEN AJOUTE !!!!!");
	     		al.showAndWait();
	     		 
	     		
	     	}else {
	     		Alert al=new Alert(AlertType.ERROR);
	     		al.setTitle("add episode !!");
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
