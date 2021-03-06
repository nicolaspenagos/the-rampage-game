package userinterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.Bonus;
import model.Bullet;
import model.Chronometer;
import model.CustomDate;
import model.Player;
import model.PlayerScore;
import model.Stage;
import model.StageElements;
import threads.CollapsedThread;
import threads.GUIUpdateControllThread;
import threads.Gravity;
import threads.ScenaryAnimationsThread;
import threads.StageElementsThread;
import threads.threadAnimation;
import threads.threadBonus;
import threads.threadBullet;
import threads.threadEnemys;

public class GameController {
	///////////////////////////////////////////////////////////////////////////////
	@FXML
	private ImageView building1;
	@FXML
	private ImageView building2;
	@FXML
	private ImageView building4;
	@FXML
	private ImageView building3;
	@FXML
	private TextField AAA;
	@FXML
	private TextField XXX;
	@FXML
	private ImageView Life1;
	@FXML
	private ImageView Life2;
	@FXML
	private ImageView Life3;
	@FXML
	private ImageView Life4;
	@FXML
	private ImageView Life5;
	@FXML
	private ImageView youWinImage;
	@FXML
	private Label endGameTime;
	@FXML
	private Label endGameHits;
	@FXML
	private Label endGameScore;
	@FXML
	private Button exitButton;
	@FXML
	private Label nicknameLabel;
	@FXML
	private Label time;
	@FXML
	private Label hits;
	@FXML
	private Label score;
	@FXML
	private Button socoreButton;
	@FXML
	private ImageView monkeySpray;
	//////////////////////////////////////////////////////////////////////////////////

	// FXML VARIABLES
	@FXML
	private Pane panelGame;
	@FXML
	private ImageView prueba1;

	// Constants
	public static final String IDLE = "IDLE";
	public static final String WALKING = "WALKING";
	public static final double MAX_WIDTH = 1100.0;
	public static final double MIN_WIDTH = 0.0;

	// Game variables and status
	private int scoreNumber;
	private int hitsNumber;
	private Chronometer c;
	private boolean gameEnded;
	private int counter;
	public static Player player;
	public static String status;
	private double maxWidth;
	private double minWidth;
	private Helicopters helicopter;
	private Helicopters helicopter1;
	private Helicopters helicopter2;
	private Helicopters heli;
	private Stage modelStage;
	private int from;
	private int to;
	private boolean fT;
	private ArrayList<ImageView> stageElements;
	String character;
	private boolean win;
	private boolean lose;
	private boolean objectWritten;
	Main main;

	// Image Variables
	Bonus bonus;
	Bullet bullet;
	ImageView bon;
	ImageView bull;
	Image front;
	Image idleToWalk;
	Image side1;
	Image side2;
	Image side3;
	Image side4;
	Image side5;
	Image side6;
	Image punch;
	Image punchLeft;
	Image punchDownL;
	Image punchDownR;
	Image punchUpR;
	Image punchUpL;
	Image lookDownL;
	Image lookDownR;
	Image lookUpR;
	Image lookUpL;
	Image painr;
	Image painl;

	@FXML
	public void initialize() {
		exitButton.setVisible(false);
		socoreButton.setVisible(false);
		youWinImage.setVisible(false);
		endGameTime.setVisible(false);
		endGameHits.setVisible(false);
		endGameScore.setVisible(false);
		scoreNumber = 0;
		hitsNumber = 0;
		counter = 0;
		monkeySpray.setFitHeight(120);
		monkeySpray.setFitWidth(110);
		character = MenuController.character;
		objectWritten = false;
		c = new Chronometer();
		win = false;
		lose = false;
		fT = true;
		front = new Image(character + "/front.png");
		side1 = new Image(character + "/side1.png");
		side2 = new Image(character + "/side2.png");
		side3 = new Image(character + "/side3.png");
		side4 = new Image(character + "/side4.png");
		side5 = new Image(character + "/side5.png");
		side6 = new Image(character + "/side6.png");
		punch = new Image(character + "/punch.png");
		punchLeft = new Image(character + "/punchLeft.png");
		punchDownL = new Image(character + "/punchDownL.png");
		punchDownR = new Image(character + "/punchDownR.png");
		punchUpR = new Image(character + "/punchUpR.png");
		punchUpL = new Image(character + "/punchUpL.png");
		lookDownL = new Image(character + "/lookDownL.png");
		lookDownR = new Image(character + "/lookDownR.png");
		lookUpR = new Image(character + "/lookUpR.png");
		lookUpL = new Image(character + "/lookUpL.png");
		painr = new Image(character + "/painr.png");
		painl = new Image(character + "/painl.png");
		modelStage = new Stage();
		stageElements = new ArrayList<>();
		gameEnded = false;
		readNickName();

		//
		GUIUpdateControllThread guiThread = new GUIUpdateControllThread(this);
		guiThread.setDaemon(true);
		guiThread.start();

		player = new Player(100, 500);
		helicopter = new Helicopters(95, 50, panelGame, Helicopters.RIGHT, false);
		helicopter1 = new Helicopters(100, 70, panelGame, Helicopters.RIGHT, false);
		helicopter2 = new Helicopters(600, 100, panelGame, Helicopters.LEFT, false);
		//
		threadAnimation th = new threadAnimation(this, player);
		th.setDaemon(true);
		th.start();
		//
		Gravity gravity = new Gravity(player);
		gravity.setDaemon(true);
		gravity.start();
		//
		ScenaryAnimationsThread sAT = new ScenaryAnimationsThread(this, helicopter, player);
		sAT.setDaemon(true);
		sAT.start();
		//
		ScenaryAnimationsThread sAT1 = new ScenaryAnimationsThread(this, helicopter1, player);
		sAT1.setDaemon(true);
		sAT1.start();
		//
		ScenaryAnimationsThread sAT2 = new ScenaryAnimationsThread(this, helicopter2, player);
		sAT2.setDaemon(true);
		sAT2.start();
		//
		StageElementsThread sET = new StageElementsThread(this);
		sET.setDaemon(true);
		updateStageElements();
		sET.start();
		//
		CollapsedThread cT = new CollapsedThread(this, modelStage);
		cT.setDaemon(true);
		cT.start();
		//
		threadBonus tb = new threadBonus(this);
		tb.setDaemon(true);
		tb.start();
		//
		threadEnemys te = new threadEnemys(this);
		te.setDaemon(true);
		te.start();
	}

	// Update the screen every 10 ms
	public void update() {
		monkeySpray.setLayoutX(player.getX());
		monkeySpray.setLayoutY(player.getY());
		monkeySpray.toFront();
		helicopter.updateOnScreen();
		helicopter1.updateOnScreen();
		helicopter2.updateOnScreen();
		heli.updateOnScreen();
		if (!win) {
			time.setText(c.getTime());
			score.setText("" + scoreNumber);
			hits.setText("" + hitsNumber);
		}
		if (player.getLives() == 4)
			Life5.setVisible(false);
		if (player.getLives() == 3)
			Life4.setVisible(false);
		if (player.getLives() == 2)
			Life3.setVisible(false);
		if (player.getLives() == 1)
			Life2.setVisible(false);
		if (player.getLives() == 1) {
			Life1.setVisible(false);
			lose();
		}
		if (modelStage.getFirst() == null) {
			win = true;
			win();
		}
		
		if (bonus != null) {
			int startX = bonus.getX() - 15;
			int endX = bonus.getX() + 15;
			if ((player.getX() >= startX && player.getX() <= endX) && (player.getY() <= bonus.getY())) {
				panelGame.getChildren().remove(bon);
				scoreNumber = scoreNumber + 5;
			}
		}

	}

	// change of image to walk
	public void changeImage(int n, String dx) {
		if (n == 1) {
			if (dx.equalsIgnoreCase("Right"))
				monkeySpray.setImage(side1);
			else
				monkeySpray.setImage(side4);
		}
		if (n == 2)
			if (dx.equalsIgnoreCase("Right"))
				monkeySpray.setImage(side2);
			else
				monkeySpray.setImage(side5);
		if (n == 3)
			if (dx.equalsIgnoreCase("Right"))
				monkeySpray.setImage(side3);
			else
				monkeySpray.setImage(side6);
	}

	// change of image to walk
	public void lookAt(String dirX, String dirY) {
		if (dirX.equals("Right")) {
			if (dirY.equals("Up")) {
				monkeySpray.setImage(lookUpR);
			} else {
				monkeySpray.setImage(lookDownR);
			}
		} else {
			if (dirY.equals("Up")) {
				monkeySpray.setImage(lookUpL);
			} else {
				monkeySpray.setImage(lookDownL);
			}
		}
	}

	public void punchX(int i, String dir) {

		if (i == 1) {
			if (dir.equals("Right"))
				monkeySpray.setImage(punch);
			else
				monkeySpray.setImage(punchLeft);
		} else {
			if (dir.equals("Right"))
				monkeySpray.setImage(side3);
			else
				monkeySpray.setImage(side4);
		}
	}

	public void punchY(int i, String dirX, String dirY) {
		if (i == 1) {
			if (dirX.equals("Right")) {
				if (dirY.equals("Up")) {
					monkeySpray.setImage(punchUpR);
				} else {
					monkeySpray.setImage(punchDownR);
				}
			} else {
				if (dirY.equals("Up")) {
					monkeySpray.setImage(punchUpL);
				} else {
					monkeySpray.setImage(punchDownL);
				}
			}
		} else {
			if (dirX.equals("Right"))
				monkeySpray.setImage(side3);
			else
				monkeySpray.setImage(side4);
		}
	}

	public void updateStageElements() {

	}

	// Character states

	public void idle() {
		monkeySpray.setImage(new Image(character + "/front.png"));
	}

	public double getMaxWidth() {
		return maxWidth;
	}

	public double getMinWidth() {
		return minWidth;
	}

	///////////////////////////////////////////////////////////////////////

	public void prueba() {
		hitsNumber++;
		double x = player.getX() + 8;
		double y = player.getY();
		if (modelStage.getFirst() != null) {
			if (modelStage.getFirst().destroy(x, y)) {
				scoreNumber += 5;
				counter++;
				ImageView imv = new ImageView();
				imv.setImage(new Image("Images/damage1.png"));
				imv.setLayoutX(x);
				imv.setLayoutY(y);

				imv.setFitWidth(62);
				imv.setFitHeight(62);
				imv.setPreserveRatio(true);
				imv.setSmooth(true);
				imv.setCache(true);
				panelGame.getChildren().add(imv);
			}
		}
	}

	public void collapsing(int id, int counter) {
		if (id == 1) {
			String root = "Images/b1-" + counter + ".png";
			building1.setImage(new Image(root));
		} else if (id == 2) {
			String root = "Images/b2-" + counter + ".png";
			building2.setImage(new Image(root));
		} else if (id == 3) {
			String root = "Images/b3-" + counter + ".png";
			building3.setImage(new Image(root));
		} else if (id == 4) {
			String root = "Images/b4-" + counter + ".png";
			building4.setImage(new Image(root));
		}
	}

	public void addBonus(Bonus b) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				bonus = b;
				bon = new ImageView(bonus.getImage());
				bon.setFitWidth(55);
				bon.setFitHeight(45);
				panelGame.getChildren().add(bon);
			}
		});
	}
	
	public void addBullet(Bullet b) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				bullet = b;
				bull = new ImageView(bullet.getImage());
				panelGame.getChildren().add(bull);
			}
		});
	}

	public void updateBonus() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if(bon != null) {
					bon.setLayoutX(bonus.getX());
					bon.setLayoutY(bonus.getY());
				}
			}
		});
	}
	
	public void updateBullet() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				bull.setLayoutX(bullet.getX());
				bull.setLayoutY(bullet.getY());
			}
		});
	}

	public void setupMain(Main m) {
		main = m;
	}

	@FXML
	void Exit(ActionEvent event) {
		main.changeScene("MainMenu.fxml");
	}

	@FXML
	void goToScores(ActionEvent event) {
		main.changeScene("Score.fxml");
	}

	@FXML
	void loadGame(ActionEvent event) {

	}

	public void lose() {
		lose = true;
		youWinImage.setImage(new Image("Images/YOU_LOSE.png"));
		youWinImage.setVisible(true);
		endGameHits.setVisible(true);
		endGameTime.setVisible(true);
		endGameScore.setVisible(true);
		endGameHits.setText(hits.getText());
		endGameTime.setText(time.getText());
		endGameScore.setText(score.getText());
		youWinImage.toFront();
		endGameHits.toFront();
		endGameTime.toFront();
		endGameScore.toFront();
		exitButton.setVisible(true);
		socoreButton.setVisible(true);
		exitButton.toFront();
		socoreButton.toFront();
		if (!objectWritten)
			saveSerializedPlayerScore();
	}

	public void win() {
		win = true;
		youWinImage.setVisible(true);
		endGameHits.setVisible(true);
		endGameTime.setVisible(true);
		endGameScore.setVisible(true);
		endGameHits.setText(hits.getText());
		endGameTime.setText(time.getText());
		endGameScore.setText(score.getText());
		youWinImage.toFront();
		endGameHits.toFront();
		endGameTime.toFront();
		endGameScore.toFront();
		exitButton.setVisible(true);
		socoreButton.setVisible(true);
		exitButton.toFront();
		socoreButton.toFront();
		if (!objectWritten)
			saveSerializedPlayerScore();

	}

	public void saveSerializedPlayerScore() {
		objectWritten = true;
		Calendar c = new GregorianCalendar();
		int day = (c.get(Calendar.DATE));
		int month = (c.get(Calendar.MONTH));
		int year = (c.get(Calendar.YEAR));
		PlayerScore ps = new PlayerScore(nicknameLabel.getText(), hitsNumber, scoreNumber, endGameTime.getText(),
				new CustomDate(day, month, year));

		try {
			ObjectOutputStream io = new ObjectOutputStream(new FileOutputStream(new File("data/SerializedPlayer.dat")));
			io.writeObject(ps);
			io.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void readNickName() {
		File f = new File("data/nickName.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			nicknameLabel.setText(line);
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

	public void addEnemy() {
		char a = ramdonDirection(randBetween(1, 2));
		if (a == Helicopters.RIGHT)
			heli = new Helicopters(1, randBetween(20, 350), panelGame, a, true);
		else
			heli = new Helicopters(MAX_WIDTH - 1, randBetween(20, 350), panelGame, a, true);
		ScenaryAnimationsThread sAT = new ScenaryAnimationsThread(this, heli, player);
		sAT.setDaemon(true);
		sAT.start();
	}

	public void deleteEnemy() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				panelGame.getChildren().remove(heli.getHeli());
				
			}
		});
	}
	
	public void deleteBullet() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				panelGame.getChildren().remove(bull);
				
			}
		});
	}

	public void addNode(Node node) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				panelGame.getChildren().add(node);
			}
		});
	}

	public char ramdonDirection(int i) {
		if (i == 1)
			return Helicopters.RIGHT;
		else {
			return Helicopters.LEFT;
		}
	}

	public int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	public Pane getPane() {
		return panelGame;
	}

	public boolean getLose() {
		return lose;
	}

	public void setLose(boolean lose) {
		this.lose = lose;
	}
	
	public boolean getWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

}

//<>
