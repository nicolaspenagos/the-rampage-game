package userinterface;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Helicopters {
	
	public final static char RIGHT = 'R';
	public final static char LEFT = 'L';
	private Circle circle;
	private Rectangle rectangle1;
	private Rectangle rectangle2;
	private Rectangle rectangle3;
	private double x;
	private double y;
	private Pane pane;
	private char orientation;
	
	
	
	public Helicopters(double x, double y, Pane pane) {
		this.x=x;
		this.y=y;
		this.pane=pane;
		circle = new Circle(8.0);
		circle.setLayoutX(x);
		circle.setLayoutY(y);
		circle.setFill(Color.BLACK);
		rectangle1 = new Rectangle(18, 4);
		rectangle1.setLayoutX(x-18);
		rectangle1.setLayoutY(y-2);
		rectangle1.setFill(Color.BLACK);
		rectangle2 = new Rectangle(13, 1.5);
		rectangle2.setLayoutX(x-24);
		rectangle2.setLayoutY(y-1);
		rectangle2.setFill(Color.BLACK);
		rectangle2.setRotate(90);
		rectangle3 = new Rectangle(21, 2);
		rectangle3.setLayoutX(x-10);
		rectangle3.setLayoutY(y-10);
		rectangle3.setFill(Color.BLACK);
		pane.getChildren().add(rectangle1);
		pane.getChildren().add(rectangle2);
		pane.getChildren().add(rectangle3);
		pane.getChildren().add(circle);
		setOrientation(RIGHT); 
		
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
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

	public Rectangle getRectangle1() {
		return rectangle1;
	}

	public void setRectangle1(Rectangle rectangle1) {
		this.rectangle1 = rectangle1;
	}

	public Rectangle getRectangle2() {
		return rectangle2;
	}

	public void setRectangle2(Rectangle rectangle2) {
		this.rectangle2 = rectangle2;
	}

	public Rectangle getRectangle3() {
		return rectangle3;
	}

	public void setRectangle3(Rectangle rectangle3) {
		this.rectangle3 = rectangle3;
	}

	public char getOrientation() {
		return orientation;
	}

	public void setOrientation(char orientation) {
		this.orientation = orientation;
	}
}
