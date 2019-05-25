package userinterface;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import threads.threadAnimation;

public class Main extends Application {

	private Stage primaryStage;
	int start = 0;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.primaryStage = stage;
		FXMLLoader fxmlL = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
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
					threadAnimation.setDirectionY("Up");
					threadAnimation.setPressedY(true);
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

				case ENTER:
					if (start == 0) {
						try {
							if (!(MenuController.character.equals(null))) {
								try {
									if (!MenuController.nickname.equals("")) {
										changeScene("gameScene.fxml");
										start = 1;
									}
								} catch (NullPointerException e) {
									JOptionPane.showMessageDialog(null, "The nickname can not be null", "Error",
											JOptionPane.ERROR_MESSAGE);
								}
							}

						} catch (NullPointerException e) {
							JOptionPane.showMessageDialog(null, "Select a Character", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
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
					threadAnimation.setPressedY(false);
					break;
				case DOWN:
					threadAnimation.setPressedY(false);
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

	public void changeScene(String fxml) {

		try {
			Parent pane = FXMLLoader.load(getClass().getResource(fxml));
			primaryStage.getScene().setRoot(pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}