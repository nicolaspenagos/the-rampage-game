package userinterface;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Helicopters {
	
	public final static char RIGHT = 'R';
	public final static char LEFT = 'L';
	private Ellipse ellipse;
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
		/*
		circle = new Circle(8.0);
		circle.setLayoutX(x);
		circle.setLayoutY(y);
		circle.setFill(Color.BLACK);
		*/
		ellipse = new Ellipse(8.0, 5.0);
		ellipse.setLayoutX(x);
		ellipse.setLayoutY(y);
		ellipse.setFill(Color.BLACK);
		
		
		
		
		
		
		rectangle1 = new Rectangle(18, 3);
		rectangle1.setLayoutX(x-18);
		rectangle1.setLayoutY(y-2);
		rectangle1.setFill(Color.BLACK);
		
		rectangle2 = new Rectangle(6,2);
		rectangle2.setLayoutX(x+2);
		rectangle2.setLayoutY(y-2);
		rectangle2.setFill(Color.rgb(0, 66, 107));
		
		
		
		rectangle3 = new Rectangle(19, 2);
		rectangle3.setLayoutX(x-10);
		rectangle3.setLayoutY(y-8);
		rectangle3.setFill(Color.BLACK);
		
		pane.getChildren().add(rectangle1);
		pane.getChildren().add(rectangle3);
		pane.getChildren().add(ellipse);
		pane.getChildren().add(rectangle2);
		
		setOrientation(RIGHT); 
		
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
		
		if(x<GameController.MAX_WIDTH) {
			x+=5;
		}else {
			x=0;
		}
		
	}
	
	public void updateOnScreen() {
		rectangle1.setLayoutX(x-18);
		rectangle1.setLayoutY(y-2);
		rectangle2.setLayoutX(x+2);
		rectangle2.setLayoutY(y-2);
		rectangle3.setLayoutX(x-10);
		rectangle3.setLayoutY(y-8);
		ellipse.setLayoutX(x);
		ellipse.setLayoutY(y);
		
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
