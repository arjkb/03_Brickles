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
		   out.setDirection(45);
		   assertEquals("Result", 45, out.getDirection());
		}
	
	@Test
	public void testGetDirection()	{
		
		// test with one direction from each of the 4 quadrants
		Velocity v1 = new Velocity(0, 45);
		Velocity v2 = new Velocity(0, 135);
		Velocity v3 = new Velocity(0, 225);
		Velocity v4 = new Velocity(0, 315);
		
		assertEquals(45, v1.getDirection());
		assertEquals(135, v2.getDirection());
		assertEquals(225, v3.getDirection());
		assertEquals(315, v4.getDirection());
		
		// test with 0 and 360, as they are the edge cases
		Velocity v0 = new Velocity(0, 0);
		Velocity v360 = new Velocity(0, 360);
		
		assertEquals(0, v0.getDirection());
		assertEquals(0, v360.getDirection());
		
		
	}

}