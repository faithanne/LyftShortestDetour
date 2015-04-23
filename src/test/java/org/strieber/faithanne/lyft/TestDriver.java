package org.strieber.faithanne.lyft;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestDriver {

	static Driver driver1;
	static Driver driver2;
	static Point a;
	static Point b;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		a = new Point(32.132832, -81.250125);
		b = new Point(32.001945, -81.116934);
		Point c = new Point(31.990311, -81.069813);
		Point d = new Point(32.076528, -81.096666);
		driver1 = new Driver("driver1", a, b);
		driver2 = new Driver("driver2", c, d);
	}

	@Test
	public void testGetName() {
		assertEquals("driver1", driver1.getName());
	}

	@Test
	public void testGetStart() {
		assertEquals(a, driver1.getStart());
	}
	
	@Test
	public void testGetEnd() {
		assertEquals(b, driver1.getEnd());
	}

	@Test
	public void testRouteDistance() {
		assertEquals(11.94, driver1.getRouteDistance(), 0.01);
	}
	
	@Test
	public void testDetourDistance() {
		assertEquals(13.94, driver1.getDetourDistance(driver2), 0.01);
	}

	@Test
	public void testShortestDetour() {
		assert(Driver.getShortestDetour(driver1, driver2).contains("13.95"));
		assert(Driver.getShortestDetour(driver1, driver2).contains("driver1"));
	}
}
