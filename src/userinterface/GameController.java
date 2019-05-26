package userinterface;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.Player;
import model.Stage;
import model.StageElements;
import threads.CollapsedThread;
import threads.GUIUpdateControllThread;
import threads.Gravity;
import threads.ScenaryAnimationsThread;
import threads.StageElementsThread;
import threads.threadAnimation;

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
	private int counter;
	private ImageView monkeySpray;
	public static Player player;
	public static String status;
	private double maxWidth;
	private double minWidth;
	private Helicopters helicopter;
	private Helicopters helicopter1;
	private Helicopters helicopter2;
	private Stage modelStage;
	private int from;
	private int to;
	private boolean fT;
	private ArrayList<ImageView> stageElements;
	String character;

	// Image Variables
	Image front;
	Image idleToWalk;
	Image side1;
	Image side2;
	Image side3;
	Image side4;
	Image side5;
	Image side6;
	Image punch;

	@FXML
	public void initialize() {
		counter = 0;
		monkeySpray = new ImageView();
		monkeySpray.setFitHeight(120);
		monkeySpray.setFitWidth(110);
		character = MenuController.character;
		fT = true;
		front = new Image(character + "/front.png");
		side1 = new Image(character + "/side1.png");
		side2 = new Image(character + "/side2.png");
		side3 = new Image(character + "/side3.png");
		side4 = new Image(character + "/side4.png");
		side5 = new Image(character + "/side5.png");
		side6 = new Image(character + "/side6.png");
		punch = new Image(character + "/punch.png");
		modelStage = new Stage();
		stageElements = new ArrayList<>();

		//
		GUIUpdateControllThread guiThread = new GUIUpdateControllThread(this);
		guiThread.setDaemon(true);
		guiThread.start();

		player = new Player(100, 500);
		helicopter = new Helicopters(95, 35, panelGame, Helicopters.RIGHT);
		helicopter1 = new Helicopters(100, 60, panelGame, Helicopters.RIGHT);
		helicopter2 = new Helicopters(600, 90, panelGame, Helicopters.LEFT);
		//
		threadAnimation th = new threadAnimation(this, player);
		th.setDaemon(true);
		th.start();
		//
		Gravity gravity = new Gravity(player);
		gravity.setDaemon(true);
		gravity.start();
		//
		ScenaryAnimationsThread sAT = new ScenaryAnimationsThread(this, helicopter);
		sAT.setDaemon(true);
		sAT.start();

		ScenaryAnimationsThread sAT1 = new ScenaryAnimationsThread(this, helicopter1);
		sAT1.setDaemon(true);
		sAT1.start();

		ScenaryAnimationsThread sAT2 = new ScenaryAnimationsThread(this, helicopter2);
		sAT2.setDaemon(true);
		sAT2.start();

		StageElementsThread sET = new StageElementsThread(this);
		sET.setDaemon(true);
		updateStageElements();
		panelGame.getChildren().add(monkeySpray);
		sET.start();

		CollapsedThread cT = new CollapsedThread(this, modelStage);
		cT.setDaemon(true);
		cT.start();
	}

	// Update the screen every 10 ms
	public void update() {
		monkeySpray.setLayoutX(player.getX());
		monkeySpray.setLayoutY(player.getY());
		helicopter.updateOnScreen();
		helicopter1.updateOnScreen();
		helicopter2.updateOnScreen();
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

	public void punch(int i, String dir) {
		if (i == 1) {
			monkeySpray.setImage(punch);
		} else {
			if (dir.equals("Right"))
				monkeySpray.setImage(side3);
			else
				monkeySpray.setImage(side4);
		}
		double x = player.getX();
		double y = player.getY();
		if (modelStage.getFirst().destroy(x, y)) {
			counter++;
			ImageView imv = new ImageView();
			imv.setImage(new Image("Images/damage1.png"));
			imv.setLayoutX(x);
			imv.setLayoutY(y);
			System.out.println("hola" + counter);
			imv.setFitWidth(62);
			imv.setFitHeight(62);
			imv.setPreserveRatio(true);
			imv.setSmooth(true);
			imv.setCache(true);
			panelGame.getChildren().add(imv);
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
	@FXML
	void prueba(ActionEvent event) {
		
	}

	public void collapsing(int id, int counter) {
		if (id == 1) {

			String root = "Images/b1-" + counter + ".png";
			System.out.println(root);
			building1.setImage(new Image(root));
		}
	}
///////////////////////
}

//<>
