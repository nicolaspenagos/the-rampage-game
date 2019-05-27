package userinterface;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CustomDate;
import model.PlayerScore;
import model.Scores;
import threads.ScoreControllerThread;

public class ScoreController {
    @FXML
    private Label dateLabel;
	@FXML
	private TableView<PlayerScore> tableView;
	@FXML
	private TableColumn<PlayerScore, Integer> ranking;
	@FXML
	private TableColumn<PlayerScore, String> nickName;
	@FXML
	private TableColumn<PlayerScore, Integer> hits;
	@FXML
	private TableColumn<PlayerScore, Integer> score;
	@FXML
	private TableColumn<PlayerScore, Integer> time;
	@FXML
	private TableColumn<CustomDate, String> date;
	
	private ObservableList<PlayerScore> oListPlayers;

	private Scores scoresClass;

	public void initialize() {
		try {
			scoresClass = new Scores();
			Date dx = new Date();
			String date=dx.toString();
	     	String toShow=date.substring(3,11 );
			dateLabel.setText(toShow+"/ 2019");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateList();
		ranking.setCellValueFactory(new PropertyValueFactory<>("ranking"));
		nickName.setCellValueFactory(new PropertyValueFactory<>("nickName"));
		hits.setCellValueFactory(new PropertyValueFactory<>("hits"));
		score.setCellValueFactory(new PropertyValueFactory<>("score"));
		time.setCellValueFactory(new PropertyValueFactory<>("time"));
		date.setCellValueFactory(new PropertyValueFactory<>("date"));
		tableView.setItems(oListPlayers);
		
	
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
