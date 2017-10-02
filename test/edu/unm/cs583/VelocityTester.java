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
	public void testReverseX()	{
		Velocity v;

		// positive test cases
		v = new Velocity(100, 0);
		v.reverseX();
		assertEquals(-100, v.getSpeedX());
		assertEquals(180, v.getDirection());

		v = new Velocity(0, 0);
		v.reverseX();
		assertEquals(0, v.getSpeedX());
		assertEquals(180, v.getDirection());

		v = new Velocity(100, 45);
		v.reverseX();
		assertEquals(-71, v.getSpeedX());
		assertEquals(135, v.getDirection());

		v = new Velocity(50, 200);
		v.reverseX();
		assertEquals(47, v.getSpeedX());
		assertEquals(340, v.getDirection());


		// negative test case
		v = new Velocity(-100, 0);
		v.reverseX();
		assertEquals(100, v.getSpeedX());
		assertEquals(180, v.getDirection());
	}

	/**
	 * public void test() { fail("Not yet implemented");
	 **/
	public void testSetDirection() {
		Velocity out = new Velocity();
		out.setDirection(45);
		assertEquals("Result", 45, out.getDirection());
	}

	@Test
	public void testSetSpeed() {
		Velocity v = new Velocity(2, 0);
		int expected = 5;
		v.setSpeed(5);
		assertEquals(expected, v.speed);
		assertEquals(expected, v.getSpeedX());
		assertEquals(0, v.getSpeedY());
	}

	@Test
	public void testGetSpeedX() {
		Velocity v = new Velocity(2, 0);
		assertEquals(2, v.getSpeedX());

		Velocity v2 = new Velocity(360, 90);
		assertEquals(5, v2.getSpeedX());
	}

	@Test
	public void testGetSpeedY() {
		Velocity v = new Velocity(2, 0);
		assertEquals(0, v.getSpeedY());

		Velocity v2 = new Velocity(360, 90);
		assertEquals(359, v2.getSpeedY());
	}

	@Test
	public void testDecomposeSpeed()
	{
		Velocity v = new Velocity();
		assertEquals(0, v.getSpeedX());
		assertEquals(0, v.getSpeedY());

		v.setSpeed(360);
		assertEquals(360, v.getSpeedX());
		assertEquals(0, v.getSpeedY());

		v.setDirection(90);
		v.decomposeSpeed();
		assertEquals(5, v.getSpeedX());
		assertEquals(359, v.getSpeedY());

		v.setDirection(200);
		v.decomposeSpeed();
		assertEquals(-342, v.getSpeedX());
		assertEquals(-110, v.getSpeedY());

	}
}
