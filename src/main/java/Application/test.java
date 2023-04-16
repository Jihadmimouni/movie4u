package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class test extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		try {
    	    // Parent root = (  Parent)FXMLLoader.load(Main.class.getResource("/Vue/MEDIA.fxml"));
    	 Parent root = (  Parent)FXMLLoader.load(test.class.getResource("/Vue/Welcome.fxml"));
    			
    			
    			Scene scene = new Scene(root );
    			stage.setScene(scene); 
    		//	scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
    			//primaryStage.setTitle( "home11111");
    			stage.setTitle( "media  salah");
    		
    			stage.show();
    		} catch(Exception e) {
    			System.out.println("dcgbjkkvhfughkbj");
    			e.printStackTrace();
    		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

}

}
