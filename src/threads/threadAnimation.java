package threads;

import model.Player;
import userinterface.gameController;

public class threadAnimation extends Thread {

	private gameController gc;
	private Player player;

	public threadAnimation(gameController game, Player playerx) {
		gc = game;
		player=playerx;
	}

	@Override
	public void run() {
		try {
			
			sleep(1000);
			gc.changeImage(0);
			sleep(300);
			for (int i = 0; i < 20; i++) {
				gc.changeImage(1);
				sleep(300);
				player.move();
				gc.changeImage(2);
				sleep(300);
				
			}

		} catch (InterruptedException ex) {

		}

	}
}
