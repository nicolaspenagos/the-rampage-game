package modelTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Player;
import model.PlayerScore;

class PlayerScoreTest {

	// -------------------------------------
	// Associations
	// -------------------------------------
	private PlayerScore p1;
	private PlayerScore p2;


	// -------------------------------------
	// Scenarios
	// -------------------------------------

	public void setUpScenary1() {

	}
		
	public void setUpScenary2() {
			p1=new PlayerScore("a", 1000, 200, "10:10:00");
			p2=new PlayerScore("a", 1000, 199, "10:10:00");
	}

	// -------------------------------------
	// Test
	// -------------------------------------
	@Test
	void PlayerScoreTest() {
		setUpScenary1();
		PlayerScore py = new PlayerScore(null, 0, 0, null);
		assertNotNull("The object were not created", py);
	}
	
	@Test
	void compareToTest() {
		setUpScenary2();
		assertTrue("The compare to is not working", p1.compareTo(p2)<0);
	}


}
