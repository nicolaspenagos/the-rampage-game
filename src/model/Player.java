package model;

public class Player {
	private double x;
	private double y;

	
	public Player(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public void move() {
		x+=15;
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