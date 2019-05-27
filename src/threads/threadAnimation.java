package threads;

import model.Player;
import userinterface.GameController;

public class threadAnimation extends Thread {

	private GameController gc;
	private Player player;

	public static String direction = "";
	public static String directionY = "";
	public static boolean pressed = false;
	public static boolean pressedY = false;
	public static boolean jumping = false;
	public static boolean hitting = false;

	public threadAnimation(GameController game, Player Player) {
		gc = game;
		player = Player;
	}

	@Override
	public void run() {
		try {
			while (true) {
				if(pressed == true) {
					gc.changeImage(1, direction);
					player.move(direction);
					if(hitting == true) {
						sleep(140);
						gc.punch(1,direction);
						sleep(140 );
						gc.punch(2,direction);
					}
					if(pressedY==true && jumping == false && Gravity.falling == false) {
						jumping = true;
						for (int i = 0; i < 15; i++) {
							player.moveY(directionY);
							sleep(10);
						}
						jumping = false;
						if(hitting == true) {
							sleep(140);
							gc.punch(1,direction);
							sleep(140);
							gc.punch(2,direction);
						}
					}
					sleep(150);
					if(pressed == true) {
						gc.changeImage(2, direction);
						player.move(direction);
						if(hitting == true) {
							sleep(140);
							gc.punch(1,direction);
							sleep(140);
							gc.punch(2,direction);
						}
						if(pressedY==true && jumping == false && Gravity.falling == false) {
							jumping = true;
							for (int i = 0; i < 15; i++) {
								player.moveY(directionY);
								sleep(10);
							}
							jumping = false;
							if(hitting == true) {
								sleep(140);
								gc.punch(1,direction);
								sleep(140);
								gc.punch(2,direction);
							}
						}
						sleep(150);
					}
					if(pressed == true) {
						gc.changeImage(3, direction);
						player.move(direction);
						if(hitting == true) {
							sleep(150);
							gc.punch(1,direction);
							sleep(150);
							gc.punch(2,direction);
						}
						if(pressedY==true && jumping == false && Gravity.falling == false) {
							jumping = true;
							for (int i = 0; i < 15; i++) {
								player.moveY(directionY);
								sleep(10);
							}
							jumping = false;
							if(hitting == true) {
								sleep(150);
								gc.punch(1,direction);
								sleep(150);
								gc.punch(2,direction);
							}
						}
						sleep(150);
					}
				}else if(pressedY==true && jumping == false && Gravity.falling == false) {
					jumping = true;
					for (int i = 0; i < 15; i++) {
						player.moveY(directionY);
						sleep(10);
					}
					jumping = false;
					if(hitting == true) {
						sleep(150);
						gc.punch(1,direction);
						sleep(150);
						gc.punch(2,direction);
					}
					sleep(150);
				}else {
					gc.idle();
					if(hitting == true) {
						sleep(150);
						gc.punch(1,direction);
						sleep(150);
						gc.punch(2,direction);
					}
				}
				sleep(10);
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
	
	public static boolean isPressedY() {
		return pressedY;
	}
	
	public static boolean isHitting() {
		return hitting;
	}

	public static void setHitting(boolean hitting) {
		threadAnimation.hitting = hitting;
	}
	
	//Direction

	public static boolean isJumping() {
		return jumping;
	}

	public static void setJumping(boolean jumpiing) {
		threadAnimation.jumping = jumpiing;
	}

	public static String getDirection() {
		return direction;
	}

	public static void setDirection(String direction) {
		threadAnimation.direction = direction;
	}
	
	public static void setDirectionY(String direction) {
		threadAnimation.directionY = direction;
	}
	

	public static void setPressedY(boolean pressedY) {
		threadAnimation.pressedY = pressedY;
	}
}
