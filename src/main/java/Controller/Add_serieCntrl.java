package Controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Connect.CnxDB;
 
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import movie4u.models.Genre;
import movie4u.models.Media;
import movie4u.models.Series;
import movie4u.models.Synopsis;

public class Add_serieCntrl implements Initializable {
	 @FXML
	    private TextField L2;

	  @FXML
	    private TextArea text;
 
  
	@FXML
	private TextField path_video;
 
 

	@FXML
	private ComboBox<String> genre;
	 
	public static Media media ;
	
	

	public ObservableList<String> l = FXCollections.observableArrayList("Comedy", "Romantic", "Action", "Historic",
			"Dramatic", "Science-fiction");
	 

 

	@FXML
	void save_serie(ActionEvent event) throws SQLException {
		 int s =12;
		 File f=new File(path_video.getText().toString());
		 Synopsis syn1=new Synopsis(f);
		 Synopsis syn2=new Synopsis(text.getText());
		 String v =genre.getValue().toString();
		 Genre type=new Genre(v);
		 Series serie =new Series(media.getName(),media.getYear(),media.getLanguage(),media.getCountry(),media.getProducer_id(),media.getImage(),syn1,type);
	
		 
		 

		if (s > 0) {
			 
			Alert al = new Alert(AlertType.INFORMATION);
			al.setTitle("add Serie !!");
			al.setHeaderText("Information !");
			al.setContentText("BIEN AJOUTE !!!!!");
			al.showAndWait();

		} else {
			Alert al = new Alert(AlertType.ERROR);
			al.setTitle("add Serie !!");
			al.setHeaderText("Information !");
			al.setContentText("NON  AJOUTE !!!!!");
			al.showAndWait();

		}

	}
 public void m(String v) {
	 L2.setText(v);
 }
 
 @FXML
 void add_season(ActionEvent event) throws IOException {
	 System.out.println("erdtfgh");
	 Stage stage=new Stage();
	 FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Add_season.fxml"));
	 Parent root=(Parent) loader.load();
	 Add_seasonCntrl controller=loader.getController();
	 controller.media1=media ;
	 
	Scene scene=new Scene(root);
	stage.setScene(scene);
	stage.setTitle("home 1.1");
	stage.show();
	 

 }
 
 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		genre.setItems(l);

	}

}
