package threads;

import javafx.application.Platform;
import userinterface.GameController;

public class GUIUpdateControllThread extends Thread{
	
	private final static long UPDATE_SLEEP_TIME = 10;
	private GameController gameGUI; 
	
	public GUIUpdateControllThread(GameController gameGUIx) {
		gameGUI = gameGUIx;
	}
	
	public void run() {
		while(true) {
			GUIUpdateRunnable gUR = new GUIUpdateRunnable(gameGUI);
			Platform.runLater(gUR);
		
			
			try {
				sleep(UPDATE_SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
