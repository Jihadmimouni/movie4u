package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class SearchViewCntrl {

    @FXML
    private TextField searchActor;

    @FXML
    private TextField searchGenre;

    @FXML
    private TextField searchProducer;

    @FXML
    private TextField searchname;

    @FXML
    void SearchbyActor(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/ResultView.fxml"));
    	Parent root = loader.load();
    	
    	ResultViewCntrl rvc = new ResultViewCntrl();
    	try {
			rvc.DisplayINFO_film(searchActor.getText().toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	try {
			rvc.DisplayINFO_Serie(searchActor.getText().toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void SearchbyGenre(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/ResultView.fxml"));
    	Parent root = loader.load();
    	
    	ResultViewCntrl rvc = new ResultViewCntrl();
    	try {
			rvc.DisplayINFO_film(searchGenre.getText().toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	try {
			rvc.DisplayINFO_Serie(searchGenre.getText().toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void SearchbyName(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/ResultView.fxml"));
    	Parent root = loader.load();
    	
    	ResultViewCntrl rvc = new ResultViewCntrl();
    	try {
			rvc.DisplayINFO_film(searchname.getText().toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	try {
			rvc.DisplayINFO_Serie(searchname.getText().toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void SearchbyProducer(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/ResultView.fxml"));
    	Parent root = loader.load();
           
    	ResultViewCntrl rvc = new ResultViewCntrl();
    	try {
			rvc.DisplayINFO_Serie(searchProducer.getText().toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	try {
			rvc.DisplayINFO_Serie(searchProducer.getText().toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

}
