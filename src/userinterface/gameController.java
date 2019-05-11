package userinterface;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Player;
import threads.GUIUpdateControllThread;
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
	public static boolean pressed;
	private double maxWidth;
	private double minWidth;

	// Image Variables
	Image front;
	Image idleToWalk;
	Image side1;
	Image side2;
	Image side3;

	@FXML
	public void initialize() {
		
		maxWidth=panelGame.getMaxWidth();
		minWidth=panelGame.getMinWidth();
		front = new Image("Images/front.png");
		idleToWalk = new Image("Images/idletowalk.png");
		side1 = new Image("Images/side1.png");
		side2 = new Image("Images/side2.png");
		side3 = new Image("Images/side3.png");

		GUIUpdateControllThread guiThread = new GUIUpdateControllThread(this);
		guiThread.setDaemon(true);
		guiThread.start();
		monkeySpray.setImage(idleToWalk);
		player = new Player(100, 450);
		threadAnimation th = new threadAnimation(this, player);
		th.setDaemon(true);
		th.start();
		idle();  
	}

	// Update the screen every 5 ms
	public void update() {
		monkeySpray.setLayoutX(player.getX());
		monkeySpray.setLayoutY(player.getY());
		if (pressed == true) {
			startMove();
		} else {
			//idle();
			status = IDLE;
		}
	}

	// Keys Status

	public static void setPressed(boolean pressed) {
		gameController.pressed = pressed;
	}
	public static boolean isPressed() {
		return pressed;
	}

	// change of image to walk
	public void changeImage(int n) {
		if (n == 1)
			monkeySpray.setImage(side1);
		if (n == 2)
			monkeySpray.setImage(side2);
		if (n == 3)
			monkeySpray.setImage(side3);
	}

	// called the thread that changes the images for the animation of walking
	public void startMove() {
		if(status.equals(IDLE)) {
			
			//status = WALKING;
		}
	}

	// Character states

	public void idle() {
		monkeySpray.setImage(new Image("Images/front.png"));
	}

}
