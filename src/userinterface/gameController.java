package userinterface;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Player;
import threads.GUIUpdateControllThread;
import threads.ScenaryAnimationsThread;
import threads.threadAnimation;

public class gameController {
	
	

	// FXML VARIABLES
	@FXML
	private ImageView monkeySpray;
	@FXML
	private Pane panelGame;
	
	

	//Constants
	public static final String IDLE = "IDLE";
	public static final String WALKING = "WALKING";
	
	// Game variables and status
	public static Player player;
	public static String status;
	private double maxWidth;
	private double minWidth;
	private Helicopters helicopters;

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
		
		maxWidth=panelGame.getMaxWidth();
		minWidth=panelGame.getMinWidth();
		front = new Image("Images/front.png");
		idleToWalk = new Image("Images/idletowalk.png");
		side1 = new Image("Images/side1.png");
		side2 = new Image("Images/side2.png");
		side3 = new Image("Images/side3.png");
		side4 = new Image("Images/side4.png");
		side5 = new Image("Images/side5.png");
		side6 = new Image("Images/side6.png");
		//
		GUIUpdateControllThread guiThread = new GUIUpdateControllThread(this);
		guiThread.setDaemon(true);
		guiThread.start();
		//
		player = new Player(100, 450);
		helicopters = new Helicopters(100, 65, panelGame);
		//
		threadAnimation th = new threadAnimation(this, player);
		th.setDaemon(true);
		th.start();
		//
		ScenaryAnimationsThread sAT= new ScenaryAnimationsThread(this, helicopters);
		sAT.setDaemon(true);
		sAT.start();
	}

	// Update the screen every 10 ms
	public void update() {
		monkeySpray.setLayoutX(player.getX());
		monkeySpray.setLayoutY(player.getY());
		helicopters.updateOnScreen();
		
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
		monkeySpray.setImage(new Image("Images/front.png"));
	}

}
