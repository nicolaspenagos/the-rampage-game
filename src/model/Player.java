package model;

public class Player {
	private double x;
	private double y;

	public Player(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void move(String direction) {

		switch (direction) {
		case "Right":
			x += 10;
			break;

		case "Left":
			x -= 10;
			break;
		}
	}

	public void moveY(String direction) {
		switch (direction) {
		case "Up":
			y -= 6;
			break;
		case "Down":
			y += 6;
			break;
		}
	}

	public void changeImage(int n) {

	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}