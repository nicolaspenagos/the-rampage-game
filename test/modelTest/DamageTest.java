package modelTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Damage;

class DamageTest {

	// -------------------------------------
	// Associations
	// -------------------------------------

	private Damage d1;

	// -------------------------------------
	// Scenarios
	// -------------------------------------

	public void setUpScenary1() {
		int sx = 630;
		int sy = 324;
		int ex = 435;
		int ey = 533;
		String image = "imagen";
		d1 = new Damage(sx, sy, ex, ey, image);
	}

	public void setUpScenary2() {
		int sx = 241;
		int sy = 321;
		int ex = 458;
		int ey = 865;
		String image = "imagen";
		d1 = new Damage(sx, sy, ex, ey, image);
	}

	// -------------------------------------
	// Test
	// -------------------------------------

	@Test
	void customDateTest() {
		Damage cd = new Damage(1,1,2,2,"");
		assertNotNull("The custom date have not been created", cd);
	}

	@Test
	void gettersAndSettertsTest() {
		setUpScenary1();
		assertTrue("The StartX getter is not working propertly", d1.getStartX() == 630);
		assertTrue("The StartY getter is not working propertly", d1.getStartY() == 324);
		assertTrue("The EndX getter is not working propertly", d1.getEndX() == 435);
		assertTrue("The EndY getter is not working propertly", d1.getEndY() == 533);
		assertTrue("The Image getter is not working propertly", d1.getImage() == "imagen");
	}

}
