package Controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import movie4u.models.Films;
import movie4u.models.Genre;
import movie4u.models.Media;
import movie4u.models.Role;
import movie4u.models.Synopsis;

public class Add_filmCntrl implements Initializable {
	public static Media media3 ;
	  @FXML
	    private TextField path_synopsis;

	    @FXML
	    private TextField duration;

	    @FXML
	    private TextField path_video;

	    @FXML
	    private TextArea text;

	    @FXML
	    private ComboBox<String> genre;
	    @FXML
	    private TextField name_actor;

	    @FXML
	    private ComboBox<String> role_actor;
	    
	    public static List<Role> roles=new ArrayList<>();
	    public ObservableList<String> l = FXCollections.observableArrayList("Comedy", "Romantic", "Action", "Historic",
				"Dramatic", "Science-fiction");
	    public ObservableList<String> l2 = FXCollections.observableArrayList("Principal","Secondary","Guest");
		 
	    @FXML
	    void save_role(ActionEvent event) {
	    	 Role role=new Role(name_actor.getText().toString(),genre.getValue().toString());
	    	 roles.add(role);
	    	 name_actor.clear();

	    }


	     

	    @FXML
	    void save_film(ActionEvent event) {
	    	int s =17;
	    	Synopsis syn=new Synopsis(text.getText().toString());
	    	Genre type=new Genre(genre.getValue());
	    	File f=new File(path_video.getText());
	    	String p=duration.getText();
	    	int durationn=Integer.parseInt(p);
	    	Films film=new Films(media3.getName(),media3.getYear(),media3.getLanguage(),media3.getCountry(),media3.getProducer_id(),media3.getImage(),syn,type,f,durationn);
	    	System.out.println(roles.size());
            
	    	 if(s>0) {
	     		
	     		
	     		Alert al=new Alert(AlertType.INFORMATION);
	     		al.setTitle("add film !!");
	     		al.setHeaderText("Information !");
	     		al.setContentText("BIEN AJOUTE !!!!!");
	     		al.showAndWait();
	     		 
	     		
	     	}else {
	     		Alert al=new Alert(AlertType.ERROR);
	     		al.setTitle("add film !!");
	     		al.setHeaderText("Information !");
	     		al.setContentText("NON  AJOUTE !!!!!");
	     		al.showAndWait();
	     		
	     	}
	 	    
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		genre.setItems(l);
		role_actor.setItems(l2);

	}

}
