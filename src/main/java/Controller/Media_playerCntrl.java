package Controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer ;
import javafx.scene.media.MediaView ;

public class Media_playerCntrl implements Initializable {

    @FXML
    private Label Labelvolume;

    @FXML
    private Button buttonppr;

    @FXML
    private HBox hboxcontrols;

    @FXML
    private HBox hboxvolume;

    @FXML
    private Label labelcurrentTime;

    @FXML
    private Label labelfullscreen;

    @FXML
    private Label labelspeed;

    @FXML
    private Label labelturtltime;

    @FXML
   private MediaView mvVideo ;
    private MediaPlayer mpVideo ;
    private Media mediaVideo;

    @FXML
    private Slider sliderTime;

    @FXML
    private Slider slidervolume;

    @FXML
    private VBox vboxparent;
    
   @FXML 
   private boolean atEndOfVideo = false ;
   private boolean isPlaying = true ;
   private boolean isMuted = true ;
   
   private ImageView ivPlay ;
   private ImageView ivPause;
   private ImageView ivRestart;
   private ImageView ivVolume;
   private ImageView ivFullScreen;
   private ImageView ivMute;
   private ImageView ivExit;
   

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		final int IV_SIZE =25 ;
		
		/*mediaVideo = new Media(new File("/movie4u/src/main/resources/buttons/valooo.mp4").toURI().toString());
		mpVideo = new MediaPlayer(mediaVideo);
		mvVideo.setMediaPlayer(mpVideo);*/
		
		
		Image ImagePlay = new Image(new File("/movie4u/src/main/resources/buttons/play.jpg").toURI().toString());
		ivPlay=new ImageView(ImagePlay);
		ivPlay.setFitHeight(IV_SIZE);
		ivPlay.setFitWidth(IV_SIZE);
		
		Image ImagePause = new Image(new File("/movie4u/src/main/resources/buttons/pause.png").toURI().toString());
		ivPause=new ImageView(ImagePause);
		ivPause.setFitHeight(IV_SIZE);
		ivPause.setFitWidth(IV_SIZE);
		
		Image ImageRestart = new Image(new File("/movie4u/src/main/resources/buttons/restart.jpg").toURI().toString());
		ivRestart=new ImageView(ImageRestart);
		ivRestart.setFitHeight(IV_SIZE);
		ivRestart.setFitWidth(IV_SIZE);
		
		
		Image ImageVolume = new Image(new File("/movie4u/src/main/resources/buttons/volume.png").toURI().toString());
		ivVolume=new ImageView(ImageVolume);
		ivVolume.setFitHeight(IV_SIZE);
		ivVolume.setFitWidth(IV_SIZE);
		
		Image ImageFullScreen = new Image(new File("/movie4u/src/main/resources/buttons/fullscreen.png").toURI().toString());
		ivFullScreen=new ImageView(ImageFullScreen);
		ivFullScreen.setFitHeight(IV_SIZE);
		ivFullScreen.setFitWidth(IV_SIZE);
		
		Image ImageMute = new Image(new File("/movie4u/src/main/resources/buttons/mute.png").toURI().toString());
		ivMute=new ImageView(ImageMute);
		ivMute.setFitHeight(IV_SIZE);
		ivMute.setFitWidth(IV_SIZE);
		
		Image ImageExit = new Image(new File("/movie4u/src/main/resources/buttons/exitsreen.png").toURI().toString());
		ivExit=new ImageView(ImageExit);
		ivExit.setFitHeight(IV_SIZE);
		ivExit.setFitWidth(IV_SIZE);
		
		
		buttonppr.setGraphic(ivPause);
		Labelvolume.setGraphic(ivMute);
		labelspeed.setText("1X");
		labelfullscreen.setGraphic(ivFullScreen);	
		
	}

}
