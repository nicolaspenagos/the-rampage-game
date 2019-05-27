package userinterface;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class MenuController {

	public static String character;
	public static String nickname;

	@FXML
	private Pane georgePane;

	@FXML
	private Pane ralphPane;

	@FXML
	private Pane lizziePane;

	@FXML
	private TextField tfNickname;

	@FXML
	void acceptNickName(KeyEvent event) {
		if(event.getCode().equals(KeyCode.ENTER)) {
			if(!tfNickname.getText().equals("")) {
				nickname = tfNickname.getText();
			}else {
				tfNickname.requestFocus();
			}
		}
	}

	@FXML
	void georgeMouseEntered(MouseEvent event) {
		try {
			if(!character.equals("george") || character.equals(null)) {
				georgePane.setStyle("-fx-background-color :  gainsboro");
			}
		} catch (NullPointerException e) {
			georgePane.setStyle("-fx-background-color :  gainsboro");
		}
	}

	@FXML
	void georgeMouseExited(MouseEvent event) {
		try {
			if(!character.equals("george") || character.equals(null)) {
				georgePane.setStyle("-fx-background-color :  darkcyan");
			}
		} catch (NullPointerException e) {
			georgePane.setStyle("-fx-background-color :  darkcyan");
		}
		
	}

	@FXML
	void selectGeorge(MouseEvent event) {
		character = "george";
		georgePane.setStyle("-fx-background-color :  red");
		ralphPane.setStyle("-fx-background-color :  darkcyan");
	}

	@FXML
	void ralphMouseEntered(MouseEvent event) {
		try {
			if(!character.equals("ralph") || character.equals(null)) {
				ralphPane.setStyle("-fx-background-color :  gainsboro");
			}
		} catch (NullPointerException e) {
			ralphPane.setStyle("-fx-background-color :  gainsboro");
		}
	}

	@FXML
	void ralphMouseExited(MouseEvent event) {
		try {
			if(!character.equals("ralph") || character.equals(null)) {
				ralphPane.setStyle("-fx-background-color :  darkcyan");
			}
		} catch (NullPointerException e) {
			ralphPane.setStyle("-fx-background-color :  darkcyan");
		}
	}

	@FXML
	void selectRalph(MouseEvent event) {
		character = "ralph";
		ralphPane.setStyle("-fx-background-color :  red");
		georgePane.setStyle("-fx-background-color :  darkcyan");
	}

	@FXML
	void lizzieMouseEntered(MouseEvent event) {
		lizziePane.setStyle("-fx-background-color : gainsboro");
	}

	@FXML
	void lizzieMouseExited(MouseEvent event) {
		lizziePane.setStyle("-fx-background-color :  grey");
	}

	@FXML
	void selectLizzie(MouseEvent event) {
		JOptionPane.showMessageDialog(null, "This character has not been unlocked", "Sorry",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public String getNickname() {
		return tfNickname.getText();
	}

	public static String getCharacter() {
		return character;
	}

	public static void setCharacter(String character) {
		MenuController.character = character;
	}

	
}
