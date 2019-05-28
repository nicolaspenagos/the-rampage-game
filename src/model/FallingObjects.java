package model;

import javafx.scene.image.Image;

public class FallingObjects {

	protected int x;
	protected int y;
	protected Image image;
	
	public FallingObjects(int x, int y, Image image) {
		this.x = x;
		this.y = y;
		this.image = image;
	}
	
	//Methods
	
	public void fall() {
		y+= 4;
	}
	
	public int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}
	
	//-----------------
	//Getters and Setters
	//-----------------

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}
