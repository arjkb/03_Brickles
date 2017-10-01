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
		   
		   out.setDirection(135);
		   assertEquals(135, out.getDirection());
		   
		   out.setDirection(225);
		   assertEquals(225, out.getDirection());
		   
		   out.setDirection(315);
		   assertEquals(315, out.getDirection());
		}

}