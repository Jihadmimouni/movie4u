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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import Application.test;
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
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import movie4u.models.Media;

public class Add_mediaCntrl implements Initializable {
	@FXML
    private TextField name_producer;

    @FXML
    private MenuButton type_media;

    @FXML
    private TextField name_media;

    @FXML
    private TextField year;

    @FXML
    private TextField language;

    @FXML
    private TextField country;
 
    
	@FXML
	    
	private TextField image_location;
	
	public static Media e1 ;
	 
 
   static public ObservableList<String> list =FXCollections.observableArrayList();
  
	    @FXML
	    void save_media(ActionEvent event) throws SQLException {
	    	int s=15;
	    	Connection conn=CnxDB.getInstance();
		     
	    	String sql="select producer.id from producer where producer.name like :1";
	    	PreparedStatement ps ;
	    	ps=conn.prepareStatement(sql);
	    	
	        ps.setString(1,name_producer.getText());
	    
	    	
	    	ResultSet  o=ps.executeQuery();
	    	o.next();
	    	 
    		int a=o.getInt(1);
    		 
    		int id_producer=a;
	    	
    		File f=new File(image_location.getText());
	    	 
	    	String c=year.getText();
	    	int year1=Integer.parseInt(c);
	    	
	    	 Media e =new Media(name_media.getText(), year1, language.getText(), country.getText(), id_producer, f);
	    	 
	    	e1=new Media(name_media.getText(), year1, language.getText(), country.getText(), id_producer, f);
	    	//int s=DAOMedia.save(e);
	    	if(s>0) {
	    		
	    		
	    		Alert al=new Alert(AlertType.INFORMATION);
	    		al.setTitle("add Media !!");
	    		al.setHeaderText("Information !");
	    		al.setContentText("BIEN AJOUTE !!!!!");
	    		al.showAndWait();
	    		 
	    		
	    	}else {
	    		Alert al=new Alert(AlertType.ERROR);
	    		al.setTitle("add Media !!");
	    		al.setHeaderText("Information !");
	    		al.setContentText("NON  AJOUTE !!!!!");
	    		al.showAndWait();
	    		
	    	}
	    	 
	    	

	    }
	    
	    /**
	     * @throws IOException ***************************************************/
	    @FXML
	    void Film(ActionEvent event) throws IOException {
	    	Stage stage=new Stage();
   		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Add_film.fxml"));
   		 Parent root=(Parent) loader.load();
   		 Add_filmCntrl controller=loader.getController();
   		 controller.media3=e1;
   		System.out.println("rrrrr"); 
   		 
   		Scene scene=new Scene(root);
   		stage.setScene(scene);
   		stage.setTitle("home 1.1");
   		stage.show();
	    	 
	    	

	    }

	    @FXML
	    void Serie(ActionEvent event) throws IOException {

    		Stage stage=new Stage();
    		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/Add_serie.fxml"));
    		 Parent root=(Parent) loader.load();
    		 Add_serieCntrl controller=loader.getController();
    		 controller.media=e1;
    		 
    		 
    		Scene scene=new Scene(root);
    		stage.setScene(scene);
    		stage.setTitle("home 1.1");
    		stage.show();
	    	 

	    }
	    
	 public  String getName_producer(String a) {
		name_producer.setText(a);
		return a;
		 
	 }  
	    
	    
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
