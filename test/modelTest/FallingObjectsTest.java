package modelTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.scene.image.Image;
import model.FallingObjects;

class FallingObjectsTest {

	// -------------------------------------
	// Associations
	// -------------------------------------

	private FallingObjects fobj;

	// -------------------------------------
	// Scenarios
	// -------------------------------------

	int x;
	int y;
	Image image;
	
	public void setUpScenary1() {
		x = 485;
		y = 280;
		image = null;
		fobj = new FallingObjects(x, y, image);
	}
	
	public void setUpScenary2() {
		x = 100;
		y = 10;
		image = null;
		fobj = new FallingObjects(x, y, image);
	}

	// -------------------------------------
	// Test
	// -------------------------------------

	@Test
	void fallingObjectsTest() {
		FallingObjects fo = new FallingObjects(1,1,null);
		assertNotNull("The fallingObjects have not been created", fo);
	}

	@Test
	void gettersAndSettertsTest() {
		setUpScenary1();
		assertTrue("The x getter is not working propertly", fobj.getX() == 485);
		assertTrue("The y getter is not working propertly", fobj.getY() == 280);
		assertTrue("The image getter is not working propertly", fobj.getImage() == null);
	}
	
}
