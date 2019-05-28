package userinterface;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import threads.ScenaryAnimationsThread;

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
	private boolean enemy;
	private int times;
	
	//Enemy
	ImageView heli;
	Image h1; 
	
	public Helicopters(double x, double y, Pane pane, char o, boolean enemy) {
		
		this.x=x;
		this.y=y;
		this.pane=pane;
		orientation = o;
		this.enemy = enemy;
		times = 0;
		if(enemy == false) {
			Rectangle one = new Rectangle(27,100);
			one.setLayoutX(379);
			one.setLayoutY(30);
			one.setFill(Color.BLACK);
			
			Rectangle two = new Rectangle(27,100);
			two.setLayoutX(439);
			two.setLayoutY(30);
			two.setFill(Color.BLACK);
			
			ellipse = new Ellipse(8.0, 5.0);
			ellipse.setLayoutX(x);
			ellipse.setLayoutY(y);
			ellipse.setFill(Color.BLACK);
			
			rectangle1 = new Rectangle(18, 3);
			if(orientation==RIGHT)
				rectangle1.setLayoutX(x-18);
			else
				rectangle1.setLayoutX(x+18);
			rectangle1.setLayoutY(y-2);
			rectangle1.setFill(Color.BLACK);
			
			rectangle2 = new Rectangle(6,2);
			if(orientation==RIGHT)
				rectangle2.setLayoutX(x+2);
			else 
				rectangle2.setLayoutX(x-2);
			rectangle2.setLayoutY(y-2);
			rectangle2.setFill(Color.rgb(0, 66, 107));
			
			rectangle3 = new Rectangle(19, 2);
			if(orientation==RIGHT)
				rectangle3.setLayoutX(x-10);
			else 
				rectangle3.setLayoutX(x+10);
			rectangle3.setLayoutY(y-8);
			rectangle3.setFill(Color.BLACK);
			pane.getChildren().add(rectangle1);
			pane.getChildren().add(rectangle3);
			pane.getChildren().add(ellipse);
			pane.getChildren().add(rectangle2);
			pane.getChildren().add(one);
			pane.getChildren().add(two);
		}else {
			h1 = new Image("Enemies/h1.png");
			heli = new ImageView(h1);
			heli.setFitWidth(65);
			heli.setFitHeight(45);
		}

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
		if(orientation==RIGHT) {
			if(x<GameController.MAX_WIDTH) {
				x+=5;
			}else {
				x=GameController.MIN_WIDTH;
				if(enemy == true)
					times++;
			}
		}
		
		if(orientation==LEFT) {
			if(x>GameController.MIN_WIDTH) {
				x-=5;
			}else {
				x=GameController.MAX_WIDTH;
				if(enemy == true)
					times++;
			}
		}
		
	}
	
	public void updateOnScreen() {
		if(enemy == false) {
			if(orientation==RIGHT) {
				rectangle1.setLayoutX(x-18);
				rectangle1.setLayoutY(y-2);
				rectangle2.setLayoutX(x+2);
				rectangle2.setLayoutY(y-2);
				rectangle3.setLayoutX(x-10);
				rectangle3.setLayoutY(y-8);
				ellipse.setLayoutX(x);
				ellipse.setLayoutY(y);	
			}else {
				rectangle1.setLayoutX(x);
				rectangle1.setLayoutY(y-2);
				rectangle2.setLayoutX(x-7);
				rectangle2.setLayoutY(y-2);
				rectangle3.setLayoutX(x-9);
				rectangle3.setLayoutY(y-8);
				ellipse.setLayoutX(x);
				ellipse.setLayoutY(y);	
			}
		}else {
			heli.setLayoutX(x);
			heli.setLayoutY(y);
			if(times == 0)
				ScenaryAnimationsThread.setAttack(false);
			else
				ScenaryAnimationsThread.setAttack(true);
		}
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
	public boolean isEnemy() {
		return enemy;
	}
	public void setEnemy(boolean enemy) {
		this.enemy = enemy;
	}
	public ImageView getHeli() {
		return heli;
	}
	public void setHeli(ImageView heli) {
		this.heli = heli;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
}
