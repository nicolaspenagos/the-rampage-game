package threads;

import javafx.scene.image.Image;
import model.Bullet;
import model.Player;
import userinterface.GameController;
import userinterface.Helicopters;

public class threadTimeToShoot extends Thread{

	private Helicopters helicopter;
	private GameController GameController;
	private Player player;
	Image missile;
	
	public threadTimeToShoot(Helicopters helicopter, GameController gameController, Player player) {
		this.helicopter = helicopter;
		GameController = gameController;
		this.player = player;
		missile = new Image("Images/missile.png");
	}

	@Override
	public void run() {
		while (true) {
			try {
				if(ScenaryAnimationsThread.attack == true) {
					sleep(2000);
					Bullet b = new Bullet((int)helicopter.getX(), (int)helicopter.getY(), missile);
					threadBullet tb = new threadBullet(GameController,b, player);
					tb.setDaemon(true);
					tb.start();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
