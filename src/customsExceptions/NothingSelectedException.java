package customsExceptions;

public class NothingSelectedException extends Thread{
	//-------------------------------------
	//Constructor
	//-------------------------------------
	public NothingSelectedException() {
		super("The user has to select an option from the comboBox");
	}
}
