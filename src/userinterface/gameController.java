package userinterface;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Player;
import threads.GUIUpdateControllThread;
import threads.threadAnimation;

public class gameController {

	@FXML
	private ImageView monkeySpray;
	@FXML
	private Pane panelGame;
	
	private Player player;

	
	Image[] moves = new Image[10];
	
	


	public void initialize() {
		moves[0] = new Image("Images/side1.png");
		moves[1] = new Image("Images/side2.png");
		moves[2] = new Image("Images/side3.png");


		GUIUpdateControllThread guiThread = new GUIUpdateControllThread(this); 
    	guiThread.setDaemon(true);
    	guiThread.start();
    	player = new Player(100,100);
		startMove();
	}

    public void update() {
    	monkeySpray.setLayoutX(player.getX());
	}
    
    
	public void changeImage(int n) {
		monkeySpray.setImage(moves[n]);
	}

	public void startMove() {
		threadAnimation th = new threadAnimation(this, player);
		th.setDaemon(true);
		th.start();
	}
	

}
