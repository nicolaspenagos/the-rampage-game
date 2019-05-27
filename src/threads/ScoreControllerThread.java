package threads;

import userinterface.ScoreController;

public class ScoreControllerThread extends Thread{
	private ScoreController sC;
	
	public ScoreControllerThread(ScoreController sC) {
		this.sC=sC;
	}
	@Override
	public void run() {
		while(true) {
			sC.update();
			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
