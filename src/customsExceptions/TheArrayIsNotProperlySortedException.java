package customsExceptions;

import model.Scores;

public class TheArrayIsNotProperlySortedException extends Exception{
	
	// -------------------------------------
	// Constructor
	// -------------------------------------
	public TheArrayIsNotProperlySortedException() {
		super("The array has to be ordered the criteria before to sort");	
	}
}
