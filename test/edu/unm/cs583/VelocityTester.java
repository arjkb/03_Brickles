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
	public void testReverseY()	{
		Velocity v;
		
		v = new Velocity(100, 90);
		v.reverseY();
		assertEquals(-99, v.getSpeedY());
		assertEquals(270, v.getDirection());
		
		v = new Velocity(100, 0);
		v.reverseY();
		assertEquals(0, v.getSpeedY());
		assertEquals(0, v.getDirection());
		
		v = new Velocity(100, 360);
		v.reverseY();
		assertEquals(6, v.getSpeedY());
		assertEquals(0, v.getDirection());
	}

}