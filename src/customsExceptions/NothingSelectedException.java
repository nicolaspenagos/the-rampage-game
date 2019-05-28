package customsExceptions;

public class NothingSelectedException extends Exception{
	//-------------------------------------
	//Constructor
	//-------------------------------------
	public NothingSelectedException() {
		super("The user has to select an option from the comboBox");
	}
}
