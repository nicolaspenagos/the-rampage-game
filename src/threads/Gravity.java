package threads;

import model.Player;

public class Gravity extends Thread{
	
	private Player player;
	public static boolean falling = false;

	public Gravity(Player Player) {
		player = Player;
	}
	
	@Override
	public void run() {
		while(true) {
			
			try {
				
				while(true) {
					if(player.getY()< 500 && threadAnimation.jumping == false) {
						sleep(20);
						player.moveY("Down");
						falling = true;
					}else {
						falling = false;
					}
					sleep(10);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
