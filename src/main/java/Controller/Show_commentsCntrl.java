package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Connect.CnxDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Show_commentsCntrl implements Initializable {
	  @FXML
	    private TextField name_media;
 
	    @FXML
	    private TableView<String> table_comments;
        @FXML
	    private TableColumn<String, String> comment;
        
        
        public  ObservableList<String> l =FXCollections.observableArrayList();
        
	    @FXML
	    void search(ActionEvent event) throws SQLException {
	    	Connection cnx= CnxDB.getInstance();
		     
	    	String sql ="select * from system.media where media.name like :1" ;
	    	
	    		PreparedStatement st=cnx.prepareStatement(sql);
	    		st.setString(1,name_media.getText());
				ResultSet s=st.executeQuery();
                s.next();
                int id =s.getInt(1);
            String sql2="select * from system.comments where comments.media_id=:1";
        	PreparedStatement st2=cnx.prepareStatement(sql2);
        	st2.setInt(1, id);
        	ResultSet o=st2.executeQuery();
        	while(o.next()) {
        		l.add(o.getString(2));
        		
        	}
        	comment.setCellValueFactory(new PropertyValueFactory<String,String>("comment")); 
        	table_comments.setItems(l);
        	
	    	
	    	

	    }
	    
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
