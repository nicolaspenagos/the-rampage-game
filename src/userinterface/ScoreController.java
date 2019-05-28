package userinterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
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
	@FXML
	private Label nickNameLabelScore;
    @FXML
    private Label playerScoreLabel;
    @FXML
	private Label playerHitsLabel;
    @FXML
    private Label playerTimeLabel;
    @FXML
    private ComboBox<?> comboBox;

	private ObservableList<PlayerScore> oListPlayers;
	private PlayerScore py;

	private Scores scoresClass;

	public void initialize() {
	
		loadPlayer();
		
		playerScoreLabel.setText(""+py.getScore());
		playerHitsLabel.setText(""+py.getHits());
		playerTimeLabel.setText(""+py.getTime());
		try {
			scoresClass = new Scores();
			dateLabel.setText(py.getDate().toString());
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
		readNickName();

	}

	public void update() {
		updateList();

	}

	public void updateList() {
		PlayerScore[] array = scoresClass.getAllPlayersScoresToShow();
		List<PlayerScore> list = Arrays.asList(array);
		oListPlayers = FXCollections.observableArrayList(list);
	}

	public void readNickName() {
		File f = new File("data/nickName.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			nickNameLabelScore.setText(line);
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadPlayer(){
		File f=new File("data/SerializedPlayer.dat");
		if(f.exists()) {
			try {
				ObjectInputStream io = new ObjectInputStream(new FileInputStream(f));
				py=(PlayerScore) io.readObject();
				io.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	}
	

    @FXML
    void setCategoryWR(ActionEvent event) {
    	scoresClass.setCategory(Scores.WORLD_RANKING);
    	updateList();
    }
    
    @FXML
    void setCategpryT5(ActionEvent event) {
       	scoresClass.setCategory(Scores.TOP_5);
       	updateList();
    }
    
    @FXML
    void save(ActionEvent event) {

    }
    
    @FXML
    void exit(ActionEvent event) {

    }
    
    @FXML
    void sort(ActionEvent event) {
    	String option=(String) comboBox.getValue();
    	//scoresClass.selectSorting(option);
    }
}
