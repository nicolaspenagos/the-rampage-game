package threads;

import javafx.scene.image.ImageView;
import model.Bullet;
import model.Player;
import userinterface.GameController;

public class threadBullet extends Thread {

	private boolean hit = false;

	private GameController gc;
	private Bullet bullet;
	private Player player;
	ImageView img;

	public threadBullet(GameController game, Bullet bu, Player player) {
		this.bullet = bu;
		this.player = player;
		gc = game;
	}

	@Override
	public void run() {
		gc.addBullet(bullet);
		while (bullet.getY() < 660 && hit == false) {
			try {
				bullet.fall();
				gc.updateBullet();
				int startX = bullet.getX() - 30;
				int endX = bullet.getX() + 30;
				if ((player.getX() >= startX && player.getX() <= endX) && (player.getY() <= bullet.getY()+15)) {
					bullet.setX(0);
					bullet.setY(0);
					hit=true;
					gc.deleteBullet();
					player.removeLife();
					System.out.println("hit");
					System.out.println(bullet.getX() + " " + bullet.getY());
				}
				sleep(30);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isHit() {
		return hit;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}

	
	
}
