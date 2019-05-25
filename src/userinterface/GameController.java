package userinterface;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Player;
import threads.GUIUpdateControllThread;
import threads.Gravity;
import threads.ScenaryAnimationsThread;
import threads.threadAnimation;

public class GameController {
	
	

	// FXML VARIABLES
	@FXML
	private ImageView monkeySpray;
	@FXML
	private Pane panelGame;
	

	//Constants
	public static final String IDLE = "IDLE";
	public static final String WALKING = "WALKING";
	public static final double MAX_WIDTH = 1100.0;
	public static final double MIN_WIDTH = 0.0;
	
	// Game variables and status
	public static Player player;
	public static String status;
	private double maxWidth;
	private double minWidth;
	private Helicopters helicopter;
	private Helicopters helicopter1;
	private Helicopters helicopter2;
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

	@FXML
	public void initialize() {
		character = MenuController.character;
		front = new Image(character+"/front.png");
		idleToWalk = new Image(character+"/idletowalk.png");
		side1 = new Image(character+"/side1.png");
		side2 = new Image(character+"/side2.png");
		side3 = new Image(character+"/side3.png");
		side4 = new Image(character+"/side4.png");
		side5 = new Image(character+"/side5.png");
		side6 = new Image(character+"/side6.png");
		
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
		ScenaryAnimationsThread sAT= new ScenaryAnimationsThread(this, helicopter);
		sAT.setDaemon(true);
		sAT.start();
		
	    ScenaryAnimationsThread sAT1= new ScenaryAnimationsThread(this, helicopter1);
		sAT1.setDaemon(true);
	    sAT1.start();
		
		ScenaryAnimationsThread sAT2= new ScenaryAnimationsThread(this, helicopter2);
		sAT2.setDaemon(true);
		sAT2.start();
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
		if (n == 1){
			if(dx.equalsIgnoreCase("Right"))
			 monkeySpray.setImage(side1);
			else 
			 monkeySpray.setImage(side4);
		}
		if (n == 2)
			if(dx.equalsIgnoreCase("Right"))
			 monkeySpray.setImage(side2);
			else 
			 monkeySpray.setImage(side5);
		if (n == 3)
			if(dx.equalsIgnoreCase("Right"))
			 monkeySpray.setImage(side3);
			else 
			 monkeySpray.setImage(side6);
	}

	// Character states

	public void idle() {
		monkeySpray.setImage(new Image(character+"/front.png"));
	}
	
	public double getMaxWidth() {
		return maxWidth;
	}
	
	public double getMinWidth() {
		return minWidth;
	}

}
