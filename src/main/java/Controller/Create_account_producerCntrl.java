package Controller;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Connect.CnxDB;
import DAO.Producer;
//import Connect.DAOProducer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import movie4u.models.Producers;

public class Create_account_producerCntrl implements Initializable {
	  @FXML
	    private TextField path_image;
	 @FXML
	    private Label L1;
	@FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private DatePicker date;

    @FXML
    private PasswordField password;
    @FXML
    private Label L2;
    
    static public ObservableList<String> list3 =FXCollections.observableArrayList();

    @FXML
    void create(ActionEvent event) throws SQLException {
    	int length = password.getLength();
    	if(length<8) {
    		L2.setText("Length password must be more than 8 characters ");
    		password.clear();
    	}
    	else {
    	LocalDate d1=date.getValue();
    	String nom=name.getText();
    	String Email=email.getText();
    	String date=d1.toString();
        String mot_de_passe=password.getText();
        File f=new File(Paths.get(path_image.getText()).toString());
        System.out.println(date);
        Date d=Date.valueOf(date);
        
        Producers p=new Producers(nom,Email,mot_de_passe,d,f);
        Producer.insert(p);
    	
    	
    	if(Producer.check(nom, mot_de_passe)) {
    		Alert al=new Alert(AlertType.INFORMATION);
    		al.setTitle("add producer !!");
    		al.setHeaderText("Information !");
    		al.setContentText("Well Added !!!!!");
    		al.showAndWait();
    		 
    		
    	}else {
    		Alert al=new Alert(AlertType.ERROR);
    		al.setTitle("add producer !!");
    		al.setHeaderText("Information !");
    		al.setContentText("NOT Added !!!!!");
    		al.showAndWait();
    		
    	}
    	
    	
    	}	


    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

}

}
