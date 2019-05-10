package threads;

import model.Player;
import userinterface.gameController;

public class threadAnimation extends Thread {

	private gameController gc;
	private Player player;

	public threadAnimation(gameController game, Player Player) {
		gc = game;
		player = Player;
	}

	@Override
	public void run() {
		try {
			while (true) {
				//sleep(200);
				gc.changeImage(1);
				player.move("Right");
				sleep(200);
				gc.changeImage(2);
				player.move("Right");
				sleep(200);
				gc.changeImage(3);
				player.move("Right");
				sleep(200);
			}
		} catch (InterruptedException ex) {

		}

	}
}
