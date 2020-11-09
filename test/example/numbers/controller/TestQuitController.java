package example.numbers.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQuitController extends AppTestCase{
	
	@Test
	public void testQuit() {
		assertEquals(true, app.isVisible());
		ExitController ec = new ExitController(app);
		
		ec.exitTest();
		
		assertEquals(false, app.isVisible());
		
	}
	

}
