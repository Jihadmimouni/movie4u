package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import movie4u.models.Media;
import movie4u.models.Users;

public class User_profileCntrl implements Initializable {
	
	//public static Users profile ;

    @FXML
    private TableColumn<Users, String> BdateColomn;

    @FXML
    private DatePicker birthTxt;

    @FXML
    private Button editBtn;

    @FXML
    private TableColumn<Users, String> emailColomn;

    @FXML
    private TextField emailTxt;

    @FXML
    private ImageView image;

    @FXML
    private TableColumn<Users, String> nameColomn;

    @FXML
    private TextField nameTxt;

    @FXML
    private TableColumn<Users, String> pswrdColomn;

    @FXML
    private TextField pswrdTxt;
    
    @FXML
    private TableView<Users> tableinfo;

    


    @FXML
    void Edit(ActionEvent event) {
                   
    }
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	void displayINFO( ObservableList<Users> Userinfo) {
		 
		   Userinfo.stream()
		           .forEach(info ->{
		        	   nameColomn.setCellValueFactory(new PropertyValueFactory<>("name"));
		        	   emailColomn.setCellValueFactory(new PropertyValueFactory<>("email"));
		        	   pswrdColomn.setCellValueFactory(new PropertyValueFactory<>("password"));
		        	   BdateColomn.setCellValueFactory(new PropertyValueFactory<>("Birthdate"));
           	            tableinfo.getItems().add(info);   
		           });
		           
		        		   
		        		   
		        		   
		
	}
	
	
	
	
	
	
	
	
	

}
