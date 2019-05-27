package userinterface;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CustomDate;
import model.PlayerScore;
import model.Scores;

public class ScoreController {

	@FXML
	private TableView<PlayerScore> tableView;

	@FXML
	private TableColumn<PlayerScore, Integer> ranking;

	@FXML
	private TableColumn<PlayerScore, String> nickName;

	@FXML
	private TableColumn<PlayerScore, Integer> hits;

	@FXML
	private TableColumn<PlayerScore, Integer> scores;

	@FXML
	private TableColumn<PlayerScore, Integer> time;

	@FXML
	private TableColumn<CustomDate, String> date;

	private ObservableList<PlayerScore> oListPlayers;

	private Scores scoresClass;

	public void initialize() {
		try {
			Scores scoresClass = new Scores();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateList();
		ranking.setCellValueFactory(new PropertyValueFactory<>("ranking"));
		nickName.setCellValueFactory(new PropertyValueFactory<>("nickName"));
		hits.setCellValueFactory(new PropertyValueFactory<>("hits"));
		scores.setCellValueFactory(new PropertyValueFactory<>("score"));
		time.setCellValueFactory(new PropertyValueFactory<>("time"));
		date.setCellValueFactory(new PropertyValueFactory<>("date"));
	}
	
	public void update() {
		updateList();
	}
	
	 public void updateList(){
	    	PlayerScore[] array = scoresClass.getAllPlayersScores();
	    	List<PlayerScore> list = Arrays.asList(array);
			oListPlayers = FXCollections.observableArrayList(list);
	 }
}
