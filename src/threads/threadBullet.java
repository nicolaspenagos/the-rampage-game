package threads;

import javafx.scene.image.ImageView;
import model.Bullet;
import model.Player;
import userinterface.GameController;

public class threadBullet extends Thread {

	public static boolean hit = false;

	private GameController gc;
	private Bullet bullet;
	private Player player;
	ImageView img;

	public threadBullet(GameController game, Bullet bu, Player player) {
		this.bullet = bu;
		this.player = player;
		gc = game;
		img = new ImageView(bullet.getImage());
		gc.addNode(img);
	}

	@Override
	public void run() {
		while (bullet.getY() > 0 && !hit) {
			try {
				bullet.fall();
				img.setLayoutX(bullet.getX());
				img.setLayoutY(bullet.getY());
				sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
