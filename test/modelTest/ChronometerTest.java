package modelTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Chronometer;

class ChronometerTest {

	//-------------------------------------
	// Associations
	//-------------------------------------
	
	private Chronometer c;
	
	//-------------------------------------
	// Scenarios
	//-------------------------------------
	
	public void setUpScenary1() {
		c = new Chronometer();
	}
	
	//-------------------------------------
	// Test
	//-------------------------------------
	
	@Test 
	void customDateTest() {
		Chronometer cd = new Chronometer();
		assertNotNull("The custom date have not been created", cd);
	}

}
