package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class User_profileCntrl implements Initializable {

    @FXML
    private TableColumn<?, ?> BdateColomn;

    @FXML
    private DatePicker birthTxt;

    @FXML
    private Button editBtn;

    @FXML
    private TableColumn<?, ?> emailColomn;

    @FXML
    private TextField emailTxt;

    @FXML
    private ImageView image;

    @FXML
    private TableColumn<?, ?> nameColomn;

    @FXML
    private TextField nameTxt;

    @FXML
    private TableColumn<?, ?> pswrdColomn;

    @FXML
    private TextField pswrdTxt;

    @FXML
    void Edit(ActionEvent event) {
                   
    }
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	void displayINFO(String name , String email ,String pswrd , String date) {
		nameColomn.setText(name);
		emailColomn.setText(email);
		pswrdColomn.setText(pswrd);
		BdateColomn.setText(date);
		
	}
	
	
	
	
	
	
	
	
	

}
