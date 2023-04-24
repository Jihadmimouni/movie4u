package Controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;



	public class ResultViewCntrl implements Initializable {

	    @FXML
	    private TextField Datetxt;

	    @FXML
	    private TextField Genretxt;

	    @FXML
	    private TableColumn<?, ?> actorFilmColomn;

	    @FXML
	    private TableColumn<?, ?> actorSerieColomn;

	    @FXML
	    private TextField durationtxt;

	    @FXML
	    private TableColumn<?, ?> filmColomn;

	    @FXML
	    private TableColumn<?, ?> fimGenreColomn;

	    @FXML
	    private ImageView mediaImage;

	    @FXML
	    private TextField mediaNametxt;

	    @FXML
	    private TableColumn<?, ?> serieColomn;

	    @FXML
	    private TableColumn<?, ?> serieGenreColomn;

	    @FXML
	    void watch(ActionEvent event) {
                  
	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}
		
	void	displayResultName(String name){
			
		}
	void	displayResultActor(String Actor){
		
	}
	void	displayResultProducer(String Producer){
		
	}
	void	displayResultGenre(String Genre){
		
	}

	}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
