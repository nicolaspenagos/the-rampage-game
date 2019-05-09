package threads;

import userinterface.gameController;

public class threadAnimation extends Thread {

	private gameController gc;

	public threadAnimation(gameController game) {
		gc = game;
	}

	@Override
	public void run() {
		try {
			//gc.changeImage(0);
			//sleep(100);
			gc.changeImage(1);
			sleep(150);
			gc.changeImage(2);
			sleep(150);
		} catch (InterruptedException ex) {

		}

	}
}
