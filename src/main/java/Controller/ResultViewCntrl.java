package Controller;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DAO.Film;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import movie4u.models.Films;
import movie4u.models.Media;
import movie4u.models.Series;


	public class ResultViewCntrl implements Initializable {

	    @FXML
	    private TextField Datetxt;

	    @FXML
	    private TextField Genretxt;

	    @FXML
	    private TableColumn<Media, String> actorFilmColomn;

	    @FXML
	    private TableColumn<Media, String> actorSerieColomn;

	    @FXML
	    private TextField durationtxt;

	    @FXML
	    private TableColumn<Media, String> filmColomn;

	    @FXML
	    private TableColumn<Media, String> fimGenreColomn;

	    @FXML
	    private ImageView mediaImage;

	    @FXML
	    private TextField mediaNametxt;

	    @FXML
	    private TableColumn<Media, String> serieColomn;

	    @FXML
	    private TableColumn<Media, String> serieGenreColomn;
	    
	    @FXML
	    private TableView<Media> tableFilm;

	    @FXML
	    private TableView<Media> tableSerie;
	    
	    private ObservableList<Media> MediaList ;

	    @FXML
	    void watch(ActionEvent event) {

	    }
	  

		
		void DisplayINFO_film(String categorie) throws SQLException{
			MediaList = (ObservableList<Media>) DAO.Media.get(1);
			
			MediaList.stream()
	                 .filter(Films.class::isInstance)
	                 .forEach(film -> {
	             filmColomn.setCellValueFactory(new PropertyValueFactory<>("Film"));
	             actorFilmColomn.setCellValueFactory(new PropertyValueFactory<>("Actors"));
	             fimGenreColomn.setCellValueFactory(new PropertyValueFactory<>("Genre"));
	             tableFilm.getItems().add(film);
	         });
			
		}
		void DisplayINFO_Serie(String categorie) throws SQLException {
			MediaList = (ObservableList<Media>) DAO.Media.get(1);
			MediaList.stream()
            .filter(Series.class::isInstance)
            .forEach(serie -> {
            	serieColomn.setCellValueFactory(new PropertyValueFactory<>("Serie"));
            	actorSerieColomn.setCellValueFactory(new PropertyValueFactory<>("Actors"));
            	serieGenreColomn.setCellValueFactory(new PropertyValueFactory<>("Genre"));
            	tableSerie.getItems().add(serie);
    });
			
		}
		 @FXML
		    void selectFilm(MouseEvent event) {
                   
		    }

		    @FXML
		    void selectSerie(MouseEvent event) {

		    }
		    @Override
			public void initialize(URL location, ResourceBundle resources) {
				
				
			}




	}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
