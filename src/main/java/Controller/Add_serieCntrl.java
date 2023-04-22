package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Connect.CnxDB;
import Connect.DAOSerie;
import Connect.DAOSynopsis;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import movie4u.models.Media;
import movie4u.models.Series;
import movie4u.models.Synopsis;

public class Add_serieCntrl implements Initializable {
	@FXML
	private TextField name_media;

	@FXML
	private TextField id_media;

	@FXML
	private TextField path_video;

	@FXML
	private TextField title_video;

	@FXML
	private TextField id_video;

	@FXML
	private TextArea text;

	@FXML
	private TextField tiltle_synopsis;

	@FXML
	private TextField id_synopsis;

	@FXML
	private ComboBox<String> genre;
	@FXML
	private Label L1;

	@FXML
	private Label L2;
	
	
	public static Media media ;

	public ObservableList<String> l = FXCollections.observableArrayList("Comedy", "Romantic", "Action", "Historic",
			"Dramatic", "Science-fiction");
	static public ObservableList<String> list = FXCollections.observableArrayList();
	static public ObservableList<String> list2 = FXCollections.observableArrayList();

	@FXML
	void save_media(ActionEvent event) throws SQLException {
		Connection conn = CnxDB.getInstance();
		/// ResultSet o=null;
		String sql = "select media.id from media where media.name like :1";
		PreparedStatement ps;
		ps = conn.prepareStatement(sql);

		ps.setString(1,name_media.getText());

		ResultSet o = ps.executeQuery();

		if (o.next()) {

			System.out.println("MEdia FOUND");

			int a = o.getInt(1);
			String b = Integer.toString(a);
			 
			id_media.setText(b);

		}
	}

	@FXML
	void save_promo(ActionEvent event) throws SQLException, FileNotFoundException {
		Connection conn = CnxDB.getInstance();
		ResultSet o = null, o1;

		String sql3 = "select * from video";
		PreparedStatement ps3 = conn.prepareStatement(sql3);
		o1 = ps3.executeQuery();
		while (o1.next()) {
			list.add(o1.getString(3));

		}
		long count = list.stream().filter(x -> x == title_video.getText().toString()).count();

		if (count > 0) {
			System.out.println("name mawjoud !!");
			L1.setText("Name already existed!!");
		}

		else {

			String sql = "insert into video(video,title) values(:1,:2)";
			PreparedStatement ps, ps2;
			ps = conn.prepareStatement(sql);

			File f = new File(path_video.getText());
			FileInputStream f1 = new FileInputStream(f);
			ps.setBlob(1, f1);
			ps.setString(2, title_video.getText());
			String c = title_video.getText();

			int s = ps.executeUpdate();

			if (s == 0) {
				System.out.println("NOT INSERTED video");

			} else {
				System.out.println("INSERTED VIDEO");
				String sql2 = "select video.id from video where video.title like :1";
				ps2 = conn.prepareStatement(sql2);

				 
				ps2.setString(1, c);
				o = ps2.executeQuery();
				o.next();
				int a = o.getInt(1);
				String b = Integer.toString(a);
				 
				id_video.setText(b);

			}
		}

	}

	@FXML
	void save_synopsis(ActionEvent event) throws SQLException {
		Connection conn = CnxDB.getInstance();
		ResultSet o = null, o1;

		String sql3 = "select * from synopsis";
		PreparedStatement ps3 = conn.prepareStatement(sql3);
		o1 = ps3.executeQuery();
		while (o1.next()) {
			list2.add(o1.getString(4));

		}
		long count = list2.stream().filter(x -> x == tiltle_synopsis.getText().toString()).count();
		if (count > 0) {
			System.out.println("mawjoud name synopsis");
			L2.setText("Name already existed!!!!");
		}

		else {

			PreparedStatement ps;

			String a = id_video.getText();
			int id_video = Integer.parseInt(a);

			Synopsis e = new Synopsis();
			e.setVideo_id(id_video);
			e.setText(text.getText());
			e.setSynopsis_title(tiltle_synopsis.getText());
			String c = tiltle_synopsis.getText();

			int s = DAOSynopsis.save(e);
			if (s > 0) {
				
				String sql = "select synopsis.id from synopsis where synopsis.title like :1";
				ps = conn.prepareStatement(sql);
 
				ps.setString(1, c);
				o = ps.executeQuery();
				o.next();
				int k = o.getInt(1);
				String b = Integer.toString(k);
				 
				id_synopsis.setText(b);

				 

			} else {
				Alert al = new Alert(AlertType.ERROR);
				al.setTitle("add SYNopsis !!");
				al.setHeaderText("Information !");
				al.setContentText("NON  AJOUTE !!!!!");
				al.showAndWait();

			}
		}
	}

	@FXML
	void save_serie(ActionEvent event) throws SQLException {
		String a = id_media.getText();
		int id_media = Integer.parseInt(a);

		String b = id_synopsis.getText();
		int id_synopsis = Integer.parseInt(b);

		Connection conn = CnxDB.getInstance();
		PreparedStatement ps;
		ResultSet o;
		String sql = "select genre.id from genre where genre.name like :1";
		ps = conn.prepareStatement(sql);
		ps.setString(1, genre.getValue());
		o = ps.executeQuery();
		o.next();
		int id_genre = o.getInt(1);

		Series e = new Series();
		e.setMedia_id(id_media);
		e.setSynopsis_id(id_synopsis);

		e.setGenre_id(id_genre);
		int s = DAOSerie.save(e);

		if (s > 0) {
			Alert al = new Alert(AlertType.INFORMATION);
			al.setTitle("add Serie !!");
			al.setHeaderText("Information !");
			al.setContentText("BIEN AJOUTE !!!!!");
			al.showAndWait();

		} else {
			Alert al = new Alert(AlertType.ERROR);
			al.setTitle("add Serie !!");
			al.setHeaderText("Information !");
			al.setContentText("NON  AJOUTE !!!!!");
			al.showAndWait();

		}

	}

	public void m(String v) {
		name_media.setText(v);
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		genre.setItems(l);

	}

}
