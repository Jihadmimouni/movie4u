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
import Connect.DAOMedia;
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
    private TextField id_producer;

    @FXML
    private TextField id_image;
	@FXML
	    
	private TextField image_location;
	   @FXML
	    private Label L2;

	    @FXML
	    private Label L1;


    @FXML
    private TextField name_image;
    @FXML
    private TextField name_producer;
    

    @FXML
    void getId_producer(ActionEvent event) throws SQLException {
    	    Connection conn=CnxDB.getInstance();
	     
	    	String sql="select producer.id from producer where producer.name like :1";
	    	PreparedStatement ps ;
	    	ps=conn.prepareStatement(sql);
	    	
	        ps.setString(1,name_producer.getText());
	    
	    	
	    	ResultSet  o=ps.executeQuery();
	    	
	    	if(o.next()) {
	    		
	    		System.out.println("PRODUCER FOUND");
 
	    		 
	    		int a=o.getInt(1);
	    		String b=Integer.toString(a);
	    		 
	    		id_producer.setText(b);
	    	}
	    	else {
	    	
	    		System.out.println("NOT FOUND");
	     
	    	}
     
    }
    
 /*********************************************************/
   static public ObservableList<String> list =FXCollections.observableArrayList();

	    @FXML
	   void save_image(ActionEvent event) throws SQLException, FileNotFoundException {
	    	Connection conn=CnxDB.getInstance();
	    	ResultSet o=null , o1;
	    
	    	
	    	String sql3="select * from image";
	    	PreparedStatement ps3=conn.prepareStatement(sql3);
	        o1=ps3.executeQuery();
	        while(o1.next()) {
	        	list.add(o1.getString(3));
	        	
	        }
	    	long count= list.stream().filter(x->x==name_image.getText().toString()).count()  ;
	    	
	    	
	    	if(count==0) {
	    		System.out.println("mawjoidd eyyy ya 3am !!");
	    		L2.setText("Name Already Existed !!");
	    		
	    	}
	    	
	    	 
	    	else {
	    
	    	System.out.println("hayaaaa");
	    	String sql="insert into image(image,name) values(:1,:2)";
	    	PreparedStatement ps ,ps2;
	    	ps=conn.prepareStatement(sql);
	    	
	    	File f=new File(image_location.getText());
	    	FileInputStream f1=new FileInputStream(f);
	    	ps.setBlob(1, f1);
	    	ps.setString(2,name_image.getText());
	    	String c=name_image.getText();
	    	
	    	int s=ps.executeUpdate();
	    	
	    	if(s==0) {
	    		System.out.println("NOT INSERTED");
	    		
	    	}
	    	else {
	    		System.out.println("INSERTED IMAGE");
	    		String sql2="select image.id from image where image.name like :1";
	    		ps2=conn.prepareStatement(sql2);
	    	    
	    		 
	    		ps2.setString(1,c);
	    		o=ps2.executeQuery();
	    		o.next();
	    		int a=o.getInt(1);
	    		String b=Integer.toString(a);
	    		 
	    		id_image.setText(b);
	    		
	    
	    		
	    	}}

	    }
	    
	    @FXML
	    void save_media(ActionEvent event) {
	    	String a=id_producer.getText();
	    	int id_producer1=Integer.parseInt(a);
	    	String b=id_image.getText();
	    	int id_image1=Integer.parseInt(b);
	    	String c=year.getText();
	    	int year1=Integer.parseInt(c);
	    	
	    	Media e=new Media();
	    	e.setName(name_media.getText());
	    	e.setYear(year1);
	    	e.setLanguage(language.getText());
	    	e.setCountry(country.getText());
	    	e.setProducer_id(id_producer1);
	    	e.setImage_id(id_image1);
	    	
	    	int s=DAOMedia.save(e);
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
	    
	    /*****************************************************/
	    @FXML
	    void Film(ActionEvent event) {
	    	 
	    	

	    }

	    @FXML
	    void Serie(ActionEvent event) throws IOException {
	    	 
			 Stage s=new Stage();
	         Parent root = (  Parent)FXMLLoader.load(test.class.getResource("/Vue/Add_serie.fxml"));
				 
				Scene scene = new Scene(root );
				s.setScene(scene);
				 
				s.show();

	    }
	    
	    
	    
	    
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
