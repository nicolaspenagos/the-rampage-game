package threads;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Bonus;
import model.Player;
import userinterface.GameController;

public class threadBonus extends Thread {

	public static int TIME_SLEEP = 1000;
	public static boolean falling = false;

	private GameController gc;
	private Player player;

	//
	Bonus bonus;
	Image fruits = new Image("Images/fruits.png");
	Image chicken = new Image("Images/chicken.png");
	Image watermelon = new Image("Images/watermelon.png");
	List<Image> images = new ArrayList<>();

	public threadBonus(GameController game) {
		gc = game;
		images.add(fruits);
		images.add(chicken);
		images.add(watermelon);
	}

	@Override
	public void run() {
		try {
			while (true) {
				if (falling == false) {
					bonus = new Bonus(randBetween(0, 1102), -4, images.get(randBetween(0, 2)));
					TIME_SLEEP = bonus.randBetween(5000, 20000);
					sleep(TIME_SLEEP);
					gc.addBonus(bonus);
					falling = true;
				}
				if (bonus.getY() < 580) {
					bonus.fall();
					gc.updateBonus();
					sleep(30);
				} else {
					falling = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

}
