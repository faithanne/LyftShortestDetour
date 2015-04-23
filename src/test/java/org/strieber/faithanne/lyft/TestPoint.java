package org.strieber.faithanne.lyft;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestPoint {

	static Point point;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		point = new Point(10.12345, 20.12345);
	}

	@Test
	public void testGetLat() {
		assertEquals(10.12345, point.getLat(), 0.001);
	}

	@Test
	public void testGetLon() {
		assertEquals(20.12345, point.getLon(), 0.001);
	}
	
	@Test
	public void testGetDistanceTo() {
		Point endPoint = new Point(11.0, 20.123);
		assertEquals(60.58279, point.getDistanceTo(endPoint), 0.001);
	}
}
