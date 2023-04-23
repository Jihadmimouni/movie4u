package Controller;

import java.io.File;
import java.net.URL;
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
    	Connection con=CnxDB.getInstance();
    	
    	String sql ="select * from producer";
    	PreparedStatement ps=null;
    	ResultSet o=null ;
    	ps=con.prepareStatement(sql);
    	o=ps.executeQuery();
    	
    	while(o.next()) {
    		list3.add(o.getString(2));
    		 
    	}
    	long count=list3.stream().filter(x->x==name.getText()).count();
    	
    	int length =password.getText().length();
    	
    	if((count>0) && (length>=8)) {
    	 
    		 
    	int s = 0;
    	LocalDate d1=date.getValue();
    	String nom=name.getText();
    	String Email=email.getText();
    	String date=d1.toString();
        String mot_de_passe=password.getText();
        File f=new File(path_image.getText());
        Date d=Date.valueOf(d1);
        
        Producers p=new Producers(nom,Email,mot_de_passe,d,f);
        Producer.insert(p);
    	
    	
    	if(s>0) {
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
    	else {
    		if(count==0) {
    		L1.setText("Name already existed");
    		name.clear();
    		}
    		
    	}
    	if(length<8) {
    		L2.setText("Length password must be more than 8 characters ");
    		password.clear();
    	}

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

}

}
