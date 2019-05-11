package userinterface;

import javafx.fxml.FXML;
import javafx.scene.image.Image;

public class gameBonusController {

	Image idleToWalk;
	Image side1;
	Image side2;
	Image side3;

	@FXML
	public void initialize() {
		idleToWalk = new Image("Images/idletowalk.png");
		side1 = new Image("Images/side1.png");
		side2 = new Image("Images/side2.png");
		side3 = new Image("Images/side3.png");
	}
}
