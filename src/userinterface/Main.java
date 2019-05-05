package userinterface;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		FXMLLoader fxmlL= new FXMLLoader(getClass().getResource("gameScene.fxml"));
		Parent root = fxmlL.load(); 
		Scene scene = new Scene(root);
		stage.setTitle("Rampage");
		stage.setScene(scene);
		stage.show();

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case UP:	System.out.println("Arriba");
					break;
				case DOWN:	System.out.println("Abajo");
					break;
				case LEFT:	System.out.println("Izquierda");
					break;
				case RIGHT: System.out.println("Derecha");
					break;

				}
			}
		});
	}

}