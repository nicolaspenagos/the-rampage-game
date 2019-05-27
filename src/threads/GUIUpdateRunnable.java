package threads;

import userinterface.GameController;
import userinterface.ScoreController;

public class GUIUpdateRunnable implements Runnable{
	private GameController gameGUI;

	
	public GUIUpdateRunnable(GameController gCx) {
		gameGUI = gCx;
	}
	@Override
	public void run() {
		gameGUI.update();
	}

}