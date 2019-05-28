package threads;

import userinterface.GameController;

public class threadEnemys extends Thread{
	
	private GameController gc;
	
	public threadEnemys(GameController game) {
		gc = game;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				gc.addEnemy();
				sleep(20000);
				gc.deleteEnemy();
				sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
