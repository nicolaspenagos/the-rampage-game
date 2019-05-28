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

import customsExceptions.NothingSelectedException;
import customsExceptions.TheArrayIsNotProperlySortedException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.CustomDate;
import model.PlayerScore;
import model.Scores;
import threads.ScoreControllerThread;

public class ScoreController {

	@FXML
	private ImageView typeOfRanking;
	@FXML
	private Label dateLabel;

	@FXML
	private Button sumB;

	@FXML
	private Label sum;

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
	private Button sortbutton;
	

    @FXML
    private Button searchButton1;
    
	@FXML
	private Label palindrome;

	@FXML
	private TableColumn<PlayerScore, Integer> time;
	
	@FXML
    private Label palindrome2;
	
	@FXML
	private TableColumn<CustomDate, String> date;

	@FXML
	private Label nickNameLabelScore;

	@FXML
	private Label playerScoreLabel;

	@FXML
	private ImageView table;

	@FXML
	private Label wr4;
	
    @FXML
    private Label As;

	@FXML
	private Label wr3;

	@FXML
	private Label wr2;

	@FXML
	private Label wr1;

	@FXML
	private Label playerHitsLabel;

	@FXML
	private Label labelI;

	@FXML
	private Label playerTimeLabel;

	@FXML
	private Button searchButton;

	@FXML
	private ComboBox<?> comboBox;

	@FXML
	private TextArea txtAreaTime;

	@FXML
	private TextArea txtAreaHits;

	@FXML
	private Label labelI2;

	@FXML
	private TextArea txtAreaScore;

	@FXML
	private TextArea txtAreaNickname;

	@FXML
	private TextField textFieldToSearch;

	@FXML
	private ComboBox<?> comboBox2;

	private ObservableList<PlayerScore> oListPlayers;
	private PlayerScore py;

	private Scores scoresClass;

	public void initialize() {

		loadPlayer();
		playerScoreLabel.setText("" + py.getScore());
		playerHitsLabel.setText("" + py.getHits());
		playerTimeLabel.setText("" + py.getTime());
		try {
			scoresClass = new Scores(py);
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
		sum.setVisible(false);
		palindrome2.setVisible(false);
		txtAreaTime.setEditable(false);
		As.setVisible(false);
		palindrome.setVisible(false);
		sumB.setVisible(false);
		txtAreaScore.setEditable(false);
		txtAreaNickname.setEditable(false);
		txtAreaHits.setEditable(false);
		 searchButton1.setVisible(false);
	}

	public void update() {
		updateList();

	}

	public void updateList() {
		PlayerScore[] array;
		if (scoresClass.getCategory() == Scores.WORLD_RANKING)
			array = scoresClass.getAllPlayersScoresToShow();
		else
			array = scoresClass.getTopFive();
		List<PlayerScore> list = Arrays.asList(array);
		oListPlayers = FXCollections.observableArrayList(list);
		tableView.setItems(oListPlayers);
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

	public void loadPlayer() {
		File f = new File("data/SerializedPlayer.dat");
		if (f.exists()) {
			try {
				ObjectInputStream io = new ObjectInputStream(new FileInputStream(f));
				py = (PlayerScore) io.readObject();
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
		typeOfRanking.setImage(new Image("Images/WorldRanking_Mesa de trabajo 1.png"));
		comboBox.setVisible(true);
		labelI.setVisible(true);
		sortbutton.setVisible(true);
		labelI2.setVisible(true);
		comboBox2.setVisible(true);
		textFieldToSearch.setVisible(true);
		searchButton.setVisible(true);
		txtAreaNickname.setVisible(true);
		txtAreaScore.setVisible(true);
		txtAreaHits.setVisible(true);
		palindrome2.setVisible(false);
		As.setVisible(false);
		txtAreaTime.setVisible(true);
		typeOfRanking.setVisible(true);
		palindrome.setVisible(false);
		table.setVisible(true);
		searchButton1.setVisible(false);
		sumB.setVisible(false);
		wr1.setVisible(true);
		wr2.setVisible(true);
		wr3.setVisible(true);
		wr4.setVisible(true);
		sum.setVisible(false);
		updateList();
	}

	@FXML
	void setCategpryT5(ActionEvent event) {
		scoresClass.setCategory(Scores.TOP_5);
		updateList();
		typeOfRanking.setImage(new Image("Images/ToFive_Mesa de trabajo 1.png"));
		comboBox.setVisible(false);
		labelI.setVisible(false);
		sumB.setVisible(true);
		table.setVisible(false);
		sortbutton.setVisible(false);
		sum.setVisible(true);
		palindrome2.setVisible(true);
		labelI2.setVisible(false);
		palindrome.setVisible(true);
		As.setVisible(true);
		comboBox2.setVisible(false);
		searchButton1.setVisible(true);
		textFieldToSearch.setVisible(false);
		searchButton.setVisible(false);
		txtAreaNickname.setVisible(false);
		txtAreaScore.setVisible(false);
		txtAreaHits.setVisible(false);
		txtAreaTime.setVisible(false);
		wr1.setVisible(false);
		wr2.setVisible(false);
		wr3.setVisible(false);
		wr4.setVisible(false);
		scoresClass.generateTopFive();
		updateList();

	}

	@FXML
	void save(ActionEvent event) {
		try {
			scoresClass.savePlayer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateList();
	}

	@FXML
	void exit(ActionEvent event) {

	}

	@FXML
	void search(ActionEvent event) {

		txtAreaNickname.setText("");
		txtAreaScore.setText("");
		txtAreaHits.setText("");
		txtAreaTime.setText("");
		String param = textFieldToSearch.getText();

		try {

			PlayerScore px = scoresClass.search(param, (String) comboBox2.getValue());

			if (px != null) {
				txtAreaNickname.setText("" + px.getNickName());
				txtAreaScore.setText("" + px.getScore());
				txtAreaHits.setText("" + px.getHits());
				txtAreaTime.setText("" + px.getTime());
			} else {
				txtAreaNickname.setText("N/F");
				txtAreaScore.setText("N/F");
				txtAreaHits.setText("N/F");
				txtAreaTime.setText("N/F");
			}
		} catch (TheArrayIsNotProperlySortedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void sort(ActionEvent event) {
		String option = (String) comboBox.getValue();
		try {
			scoresClass.selectSorting(option);
			

		} catch (NothingSelectedException e) {
			e.printStackTrace();
		}
		updateList();
	}

	@FXML
	void sumR(ActionEvent event) {
		int a = scoresClass.sumScores(scoresClass.getRoot());
		As.setText("Answer: "+a);
	}
	
	@FXML
	void palindrome(ActionEvent event) {
		palindrome2.setText(scoresClass.palindrome1());
	}

}
