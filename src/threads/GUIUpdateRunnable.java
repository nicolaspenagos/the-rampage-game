package threads;

import userinterface.gameController;

public class GUIUpdateRunnable implements Runnable{
	private gameController gameGUI;;
	
	public GUIUpdateRunnable(gameController gCx) {
		gameGUI = gCx;
	}
	@Override
	public void run() {
		gameGUI.update();
	}

}