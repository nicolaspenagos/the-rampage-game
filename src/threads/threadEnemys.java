package threads;

import userinterface.GameController;

public class threadEnemys extends Thread{
	
	private GameController gc;
	
	public threadEnemys(GameController game) {
		gc = game;
	}
	
	@Override
	public void run() {
		while (gc.getWin() == false && gc.getLose() == false) {
			try {
				gc.addEnemy();
				sleep(20000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
