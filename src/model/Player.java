package model;

public class Player {
	private double x;
	private double y;
	private String direction;
	private int lives;
	public Player(double x, double y) {
		this.x = x;
		this.y = y;
		lives=5;
		direction="Right";
	}

	public void move(String direction) {
		this.direction=direction;
		switch (direction) {
		case "Right":
			x += 10;
			break;

		case "Left":
			x -= 10;
			break;
		}
	}

	public void fall(String direction) {
		switch (direction) {
		case "Up":
			y -= 6;
			break;
		case "Down":
			y += 6;
			break;
		}
	}
	
	public void removeLife() {
		lives--;
	}

	public void changeImage(int n) {

	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}
	public int getLives() {
		return lives;
	}
	public double getY() {
		return y;
	}
	
    public String getDirection() {
    	return direction;
    }

	public void setY(double y) {
		this.y = y;
	}
	

}