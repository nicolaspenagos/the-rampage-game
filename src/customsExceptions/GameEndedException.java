package customsExceptions;

@SuppressWarnings("serial")
public class GameEndedException extends Exception{
	
	//-------------------------------------
	//Constructor
	//-------------------------------------
	public GameEndedException() {
		super("The game has ended, there is no more buildings");
	}
		
}
