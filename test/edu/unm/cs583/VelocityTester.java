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
		assertEquals(-70, v.getSpeedX());
		assertEquals(135, v.getDirection());

		v = new Velocity(50, 200);
		v.reverseX();
		assertEquals(46, v.getSpeedX());
		assertEquals(340, v.getDirection());


		// negative test case
		v = new Velocity(-100, 0);
		v.reverseX();
		assertEquals(100, v.getSpeedX());
		assertEquals(180, v.getDirection());
	}
	
	public void testReverseY()	{
		Velocity v;

		// positive test cases
		v = new Velocity(0, 90);
		v.reverseY();
		assertEquals(0, v.getSpeedY());
		assertEquals(270, v.getDirection());

		v = new Velocity(100, 0);
		v.reverseY();
		assertEquals(0, v.getSpeedY());
		assertEquals(0, v.getDirection());

		v = new Velocity(100, 90);
		v.reverseY();
		assertEquals(-100, v.getSpeedY());
		assertEquals(270, v.getDirection());

		v = new Velocity(100, 360);
		v.reverseY();
		assertEquals(0, v.getSpeedY());
		assertEquals(0, v.getDirection());

		v = new Velocity(100, 480);
		v.reverseY();
		assertEquals(-86, v.getSpeedY());
		assertEquals(240, v.getDirection());
		
		
		// negative test cases
		v = new Velocity(-100, 0);
		v.reverseY();
		assertEquals(0, v.getSpeedY());
		assertEquals(0, v.getDirection());

		v = new Velocity(-100, 90);
		v.reverseY();
		assertEquals(100, v.getSpeedY());
		assertEquals(270, v.getDirection());

		v = new Velocity(-100, 360);
		v.reverseY();
		assertEquals(0, v.getSpeedY());
		assertEquals(0, v.getDirection());

		v = new Velocity(-100, 480);
		v.reverseY();
		assertEquals(86, v.getSpeedY());
		assertEquals(240, v.getDirection());
	}

	/**
	 * public void test() { fail("Not yet implemented");
	 **/
	@Test
	public void testSetDirection() {
		Velocity out = new Velocity();
		
		// use an enhanced for-loop to test one angle from every quadrant  
		for(int angle: new int[] {45, 135, 225, 315}) {
			out.setDirection(angle);
			assertEquals(angle, out.getDirection());
		}
		
		// test angles 0 and 360. Should return 0 in both cases.
		out.setDirection(0);
		assertEquals(0, out.getDirection());
				
		out.setDirection(360);
		assertEquals(0, out.getDirection());
		
		// test angle 361. Should return 1.
		out.setDirection(361);
		assertEquals(1, out.getDirection());
	}
	
	@Test
	public void testGetDirection()	{
		
		// test with one direction from each of the 4 quadrants (positive)
		Velocity v1 = new Velocity(0, 45);
		Velocity v2 = new Velocity(0, 135);
		Velocity v3 = new Velocity(0, 225);
		Velocity v4 = new Velocity(0, 315);
		
		assertEquals(45, v1.getDirection());
		assertEquals(135, v2.getDirection());
		assertEquals(225, v3.getDirection());
		assertEquals(315, v4.getDirection());
		
		// test with 0 and 360, as they are the edge cases (positive)
		Velocity v0 = new Velocity(0, 0);
		Velocity v360 = new Velocity(0, 360);
		
		assertEquals(0, v0.getDirection());
		assertEquals(0, v360.getDirection());
		
		// test with a number greater than 360 (negative)
		Velocity vBig = new Velocity(0, 400);
		assertEquals(40, vBig.getDirection());	
	}

	// Mario LoPrinzi
	@Test
	public void testSetSpeed() {
		Velocity v = new Velocity(2, 0);
		int expected = 5;
		v.setSpeed(5);

		// The speed should be the same
		// as whatever is given to set speed.
		// This includes the getSpeedX() function.
		// The getSpeedY() is 0 * speed which is 0.
		assertEquals(expected, v.speed);
		assertEquals(expected, v.getSpeedX());
		assertEquals(0, v.getSpeedY());
	}

	// Mario LoPrinzi
	@Test
	public void testGetSpeedX() {
		// cos(0) is 1 and 1*2 is 2
		// v.getSpeedX() should be equal
		// to the speed passed in.
		Velocity v = new Velocity(2, 0);
		assertEquals(2, v.getSpeedX());

		// cos(90) is 0 and 0*360 is 0
		// getSpeedX() should always be
		// zero here.
		Velocity v2 = new Velocity(360, 90);

		assertEquals(0, v2.getSpeedX());

	}

	// Mario LoPrinzi
	@Test
	public void testGetSpeedY() {
		// with direction zero sin is 0 so
		// v.getSpeedY() should be zero.
		Velocity v = new Velocity(2, 0);
		assertEquals(0, v.getSpeedY());

		// sin(2pi) = 1 so 1*360 is 360.
		Velocity v2 = new Velocity(360, 90);
		assertEquals(360, v2.getSpeedY());
	}

	// Mario LoPrinzi
	@Test
	public void testDecomposeSpeed() {
		// Testing that decompose speed will
		// be zero for a zero speed Velocity
		Velocity v = new Velocity();
		assertEquals(0, v.getSpeedX());
		assertEquals(0, v.getSpeedY());

		// Testing changing the speed will
		// call decomposeSpeed() as expected
		v.setSpeed(360);
		assertEquals(360, v.getSpeedX());
		assertEquals(0, v.getSpeedY());


		// Testing the changing of direction
		// to see if the getSpeedY gets all of the
		// speed
		v.setDirection(90);
		v.decomposeSpeed();

		assertEquals(0, v.getSpeedX());
		assertEquals(360, v.getSpeedY());

		// Testing a 3rd quadrant Velocity
		// where speed is negative.
		v.setDirection(200);
		v.decomposeSpeed();
		assertEquals(-338, v.getSpeedX());
		assertEquals(-123, v.getSpeedY());

	}
}
