package model;

import javafx.scene.image.Image;

public class Bonus extends FallingObjects{

	public Bonus(int x, int y, Image image) {
		super(x, y, image);
	}
	
	@Override
	public void fall() {
		super.fall();
	}

	@Override
	public int randBetween(int start, int end) {
		return super.randBetween(start, end);
	}
	
}
