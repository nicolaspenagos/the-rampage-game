package userinterface;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import threads.threadAnimation;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		FXMLLoader fxmlL = new FXMLLoader(getClass().getResource("gameScene.fxml"));
		Parent root = fxmlL.load();
		Scene scene = new Scene(root);
		stage.setTitle("Rampage");
		stage.setScene(scene);
		stage.show();

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case UP:
					break;
				case DOWN:
					break;
				case LEFT:
					threadAnimation.setDirection("Left");
					threadAnimation.setPressed(true);
					break;
				case RIGHT:
					threadAnimation.setDirection("Right");
					threadAnimation.setPressed(true);
					break;
				default: 
					break;
				}
			}
		});
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case UP:
					break;
				case DOWN:
					break;
				case LEFT:
					threadAnimation.setPressed(false);
					break;
				case RIGHT:
					threadAnimation.setPressed(false);
					break;
				}
			}
		});
	}

}