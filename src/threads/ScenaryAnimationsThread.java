package threads;

import userinterface.Helicopters;
import javafx.scene.image.Image;
import model.Bullet;
import model.Player;
import userinterface.GameController;

public class ScenaryAnimationsThread extends Thread {

	public static boolean attack = false;

	private Helicopters helicopter;
	private GameController GameController;
	private Player player;
	Image h1;
	Image h1r;
	Image h2;
	Image h2r;
	Image h3;
	Image h3r;
	Image h4;
	Image h4r;

	public ScenaryAnimationsThread(GameController gc, Helicopters h, Player pla) {
		helicopter = h;
		GameController = gc;
		player = pla;
		h1 = new Image("Enemies/h1.png");
		h1r = new Image("Enemies/h1r.png");
		h2 = new Image("Enemies/h2.png");
		h2r = new Image("Enemies/h2r.png");
		h3 = new Image("Enemies/h3.png");
		h3r = new Image("Enemies/h3r.png");
		h4 = new Image("Enemies/h4.png");
		h4r = new Image("Enemies/h4r.png");
		if(helicopter.isEnemy() == true)
		GameController.addNode(helicopter.getHeli());
		threadTimeToShoot tts = new threadTimeToShoot(helicopter, GameController, player);interrupt();
		tts.setDaemon(true);
		tts.start();
	}

	@Override
	public void run() {
		while (helicopter.getTimes() < 2) {
			try {
				if (helicopter.isEnemy() == false) {
					helicopter.move();
					sleep(100);
				} else {
					if (helicopter.getOrientation() == Helicopters.RIGHT) {
						if (attack == false) {
							helicopter.getHeli().setImage(h3r);
							helicopter.move();
							sleep(40);
							helicopter.getHeli().setImage(h4r);
							helicopter.move();
							sleep(40);
						} else {
							helicopter.getHeli().setImage(h1r);
							helicopter.move();
							sleep(40);
							helicopter.getHeli().setImage(h2r);
							helicopter.move();
							sleep(40);
						}

					} else {
						if (attack == false) {
							helicopter.getHeli().setImage(h3);
							helicopter.move();
							sleep(40);
							helicopter.getHeli().setImage(h4);
							helicopter.move();
							sleep(40);
						} else {
							helicopter.getHeli().setImage(h1);
							helicopter.move();
							sleep(40);
							helicopter.getHeli().setImage(h2);
							helicopter.move();
							sleep(40);
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		helicopter.getHeli().setVisible(false);
	}

	public static boolean isAttack() {
		return attack;
	}

	public static void setAttack(boolean attack) {
		ScenaryAnimationsThread.attack = attack;
	}
	
}
