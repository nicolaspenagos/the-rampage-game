package threads;

import model.Player;
import userinterface.gameController;

public class threadAnimation extends Thread {

	private gameController gc;
	private Player player;
	public static String direction = "";
	public static boolean pressed = false;

	public threadAnimation(gameController game, Player Player) {
		gc = game;
		player = Player;
	}

	@Override
	public void run() {
		try {
			while (true) {
				if(pressed == true) {
					gc.changeImage(1);
					player.move(direction);
					sleep(200);
					gc.changeImage(2);
					player.move(direction);
					sleep(200);
					gc.changeImage(3);
					player.move(direction);
					sleep(200);
				}else {
					gc.idle();
					//System.out.println(pressed);
				}
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

	}

	// Keys Status

	public static void setPressed(boolean pressed) {
		threadAnimation.pressed = pressed;
	}

	public static boolean isPressed() {
		return pressed;
	}
	
	//Direction

	public static String getDirection() {
		return direction;
	}

	public static void setDirection(String direction) {
		threadAnimation.direction = direction;
	}
}
