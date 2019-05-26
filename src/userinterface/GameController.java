package userinterface;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.Player;
import model.Stage;
import model.StageElements;
import threads.GUIUpdateControllThread;
import threads.Gravity;
import threads.ScenaryAnimationsThread;
import threads.StageElementsThread;
import threads.threadAnimation;

public class GameController {
	///////////////////////////////////////////////////////////////////////////////
	 @FXML
	    private TextField AAA;

	    @FXML
	    private TextField XXX;
//////////////////////////////////////////////////////////////////////////////////
	

	// FXML VARIABLES
	@FXML
	private Pane panelGame;
	@FXML
    private ImageView prueba1;

	

	//Constants
	public static final String IDLE = "IDLE";
	public static final String WALKING = "WALKING";
	public static final double MAX_WIDTH = 1100.0;
	public static final double MIN_WIDTH = 0.0;
	
	// Game variables and status
	private ImageView monkeySpray;
	public static Player player;
	public static String status;
	private double maxWidth;
	private double minWidth;
	private Helicopters helicopter;
	private Helicopters helicopter1;
	private Helicopters helicopter2;
	private Stage modelStage;
	private int from;
	private int to;
	private boolean fT;
	private ArrayList<ImageView> stageElements;
	String character;

	// Image Variables
	Image front;
	Image idleToWalk;
	Image side1;
	Image side2;
	Image side3;
	Image side4;
	Image side5;
	Image side6;


	@FXML
	public void initialize() {
		monkeySpray = new ImageView();
		monkeySpray.setFitHeight(120);
		monkeySpray.setFitWidth(110);
		character = MenuController.character;
		fT=true;
		front = new Image(character+"/front.png");
		side1 = new Image(character+"/side1.png");
		side2 = new Image(character+"/side2.png");
		side3 = new Image(character+"/side3.png");
		side4 = new Image(character+"/side4.png");
		side5 = new Image(character+"/side5.png");
		side6 = new Image(character+"/side6.png");
		modelStage=new Stage();
		stageElements = new ArrayList<>();
		//
		GUIUpdateControllThread guiThread = new GUIUpdateControllThread(this);
		guiThread.setDaemon(true);
		guiThread.start();
	
		player = new Player(100, 500);
		helicopter = new Helicopters(95, 35, panelGame, Helicopters.RIGHT);
		helicopter1 = new Helicopters(100, 60, panelGame, Helicopters.RIGHT);
		helicopter2 = new Helicopters(600, 90, panelGame, Helicopters.LEFT);
		//
		threadAnimation th = new threadAnimation(this, player);
		th.setDaemon(true);
		th.start();
		//
		Gravity gravity = new Gravity(player);
		gravity.setDaemon(true);
		gravity.start();
		//
		ScenaryAnimationsThread sAT= new ScenaryAnimationsThread(this, helicopter);
		sAT.setDaemon(true);
		sAT.start();
		
	    ScenaryAnimationsThread sAT1= new ScenaryAnimationsThread(this, helicopter1);
		sAT1.setDaemon(true);
	    sAT1.start();
		
		ScenaryAnimationsThread sAT2= new ScenaryAnimationsThread(this, helicopter2);
		sAT2.setDaemon(true);
		sAT2.start();
		
		StageElementsThread sET = new StageElementsThread(this);
		sET.setDaemon(true);
		updateStageElements();
		panelGame.getChildren().add(monkeySpray);
		sET.start();
	}

	// Update the screen every 10 ms
	public void update() {
		monkeySpray.setLayoutX(player.getX());
		monkeySpray.setLayoutY(player.getY());
		helicopter.updateOnScreen();
		helicopter1.updateOnScreen();
		helicopter2.updateOnScreen();
		System.out.println(panelGame.getChildren().size());
		System.out.println(stageElements.size());
		if(panelGame.getChildren().size()!=(stageElements.size()+27)) {
			stageElements.get(stageElements.size()-1).getImage();
			Circle cx = new Circle(30);
			cx.setFill(Color.RED);
			cx.setLayoutX(100);
			panelGame.getChildren().add(stageElements.get(stageElements.size()-1));
			//panelGame.getChildren().add(cx);
		}
		
	}
	
	

	// change of image to walk
	public void changeImage(int n, String dx) {
		if (n == 1){
			if(dx.equalsIgnoreCase("Right"))
			 monkeySpray.setImage(side1);
			else 
			 monkeySpray.setImage(side4);
		}
		if (n == 2)
			if(dx.equalsIgnoreCase("Right"))
			 monkeySpray.setImage(side2);
			else 
			 monkeySpray.setImage(side5);
		if (n == 3)
			if(dx.equalsIgnoreCase("Right"))
			 monkeySpray.setImage(side3);
			else 
			 monkeySpray.setImage(side6);
	}
	
	public void updateStageElements() {
		ArrayList<StageElements> array = modelStage.getItemsToDraw();
		if(stageElements.size()==0||array.size()!=stageElements.size()) {
			
			if(fT) {
				for (int  i= 0; i < array.size(); i++) {
					StageElements current = array.get(i);
					ImageView imv = new ImageView();
					imv.setImage(new Image("Images"+current.getImage()));
					imv.setLayoutX(current.getStartX());
					imv.setLayoutY(current.getStartY()-140);System.out.println(current.getStartY());
			        imv.setFitWidth(current.getWidth());
			        imv.setFitHeight(current.getHeight());
			        imv.setPreserveRatio(true);
			        imv.setSmooth(true);
			        imv.setCache(true);
					stageElements.add(imv);
					if(fT) {
						panelGame.getChildren().add(imv);
					}
			}
			fT=false;
			}else {
				System.out.println("22222222222222222222222222222222");
				StageElements current = array.get(array.size()-1);
				ImageView imv = new ImageView();
				imv.setImage(new Image("Images/Prueba-01.png"));
				imv.setLayoutX(current.getStartX());
				imv.setLayoutY(current.getStartY()-140);System.out.println(current.getStartY());
		        imv.setFitWidth(current.getWidth());
		        imv.setFitHeight(current.getHeight());
		        imv.setPreserveRatio(true);
		        imv.setSmooth(true);
		        imv.setCache(true);
				stageElements.add(imv);
			}
			
		}
	}

	// Character states

	public void idle() {
		monkeySpray.setImage(new Image(character+"/front.png"));
	}
	
	public double getMaxWidth() {
		return maxWidth;
	}
	
	public double getMinWidth() {
		return minWidth;
	}
	///////////////////////////////////////////////////////////////////////
	  @FXML
	    void prueba(ActionEvent event) {
		  
		  modelStage.getFirst().destroy(Double.parseDouble(AAA.getText()), Double.parseDouble(XXX.getText()));
		  modelStage.addItemsToDraw();
	    }
/////////////////////////////////////////////////////////////////////////
}

