package edu.unm.cs583;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VelocityTester {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	/** public void test() {
		fail("Not yet implemented"); **/
	public void testSetDirection() {
		Velocity out = new Velocity();
		
		// use an enhanced for-loop to test one angle from every quadrant  
		for(int angle: new int[] {45, 135, 225, 315}) {
			out.setDirection(angle);
			assertEquals(angle, out.getDirection());
		}
		
		
	}
}