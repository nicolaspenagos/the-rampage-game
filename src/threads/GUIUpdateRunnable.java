package threads;

import userinterface.GameController;

public class GUIUpdateRunnable implements Runnable{
	private GameController gameGUI;;
	
	public GUIUpdateRunnable(GameController gCx) {
		gameGUI = gCx;
	}
	@Override
	public void run() {
		gameGUI.update();
	}

}