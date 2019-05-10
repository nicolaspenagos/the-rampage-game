package threads;

import javafx.application.Platform;
import userinterface.gameController;

public class GUIUpdateControllThread extends Thread{
	
	private final static long UPDATE_SLEEP_TIME = 40;
	private gameController gameGUI; 
	
	public GUIUpdateControllThread(gameController gameGUIx) {
		gameGUI = gameGUIx;
	}
	
	public void run() {
		while(true) {
			GUIUpdateRunnable gUR = new GUIUpdateRunnable(gameGUI);
			Platform.runLater(gUR);
		
			
			try {
				sleep(UPDATE_SLEEP_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
