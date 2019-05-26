package threads;

import userinterface.GameController;

public class StageElementsThread extends Thread{
	private GameController gc;
	public StageElementsThread(GameController gC) {
		gc=gC;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				sleep(20);
				gc.updateStageElements();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
