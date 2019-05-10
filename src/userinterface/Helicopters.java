package userinterface;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Helicopters {
	
	public final static char RIGHT = 'R';
	public final static char LEFT = 'L';
	private Circle circle;
	private Line line1; 
	private Line line2; 
	private double x;
	private double y;
	private Pane pane;
	private char orientation;
	
	
	
	public Helicopters(double x, double y, Pane pane) {
		this.x=x;
		this.y=y;
		this.pane=pane;
		circle = new Circle(3.0);
		circle.setLayoutX(x);
		circle.setLayoutY(y);
		circle.setFill(Color.BLACK);
		pane.getChildren().add(circle);
		orientation = RIGHT; 
		
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public Line getLine2() {
		return line2;
	}

	public void setLine2(Line line2) {
		this.line2 = line2;
	}

	public Line getLine1() {
		return line1;
	}

	public void setLine1(Line line1) {
		this.line1 = line1;
	}

	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void move() {
		
	}
}
