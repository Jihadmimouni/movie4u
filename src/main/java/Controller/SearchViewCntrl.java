package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import movie4u.models.Media;

public class SearchViewCntrl implements Initializable {

    @FXML
    private TextField searchActor;

    @FXML
    private TextField searchGenre;

    @FXML
    private TextField searchProducer;

    @FXML
    private TextField searchname;
    
  

    @FXML
    void SearchbyActor(ActionEvent event) throws IOException, SQLException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/ResultView.fxml"));
    	Parent root = loader.load();
    	 ObservableList<Media> MediaList ;
    	 MediaList =  (ObservableList<Media>) DAO.Media.get_BYactor_name(searchActor.getText().toString());
    	
    	ResultViewCntrl rvc = new ResultViewCntrl();
    	try {
			rvc.DisplayINFO_film( MediaList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	try {
			rvc.DisplayINFO_Serie(MediaList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void SearchbyName(ActionEvent event) throws IOException, SQLException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/ResultView.fxml"));
    	Parent root = loader.load();
    	 ObservableList<Media> MediaList ;
    	 MediaList =  (ObservableList<Media>) DAO.Media.get_byname(searchname.getText().toString());
    	
    	ResultViewCntrl rvc = new ResultViewCntrl();
    	try {
			rvc.DisplayINFO_film( MediaList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	try {
			rvc.DisplayINFO_Serie(MediaList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void SearchbyGenre(ActionEvent event) throws IOException, SQLException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/ResultView.fxml"));
    	Parent root = loader.load();
    	 ObservableList<Media> MediaList ;
    	 MediaList =  (ObservableList<Media>) DAO.Media.get_bygenre(searchname.getText().toString());
    	
    	ResultViewCntrl rvc = loader.getController();
    	try {
			rvc.DisplayINFO_film( MediaList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	try {
			rvc.DisplayINFO_Serie(MediaList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

   

    @FXML
    void SearchbyProducer(ActionEvent event) throws IOException, SQLException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/ResultView.fxml"));
    	Parent root = loader.load();
    	 ObservableList<Media> MediaList ;
    	 MediaList =  (ObservableList<Media>) DAO.Media.get_byproducer_name(searchProducer.getText().toString());
    	
    	ResultViewCntrl rvc = new ResultViewCntrl();
    	try {
			rvc.DisplayINFO_film( MediaList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	try {
			rvc.DisplayINFO_Serie(MediaList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
