package org.strieber.faithanne.lyft;

import static java.lang.Math.asin;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;

public class Point {

	private static final int EARTH_RADIUS = 3960; // miles

	private double lat;
	private double lon;

	public Point(double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

	public double getDistanceTo(Point end) {
		
		double halfLatDelta = toRadians(end.getLat() - lat) / 2;
		double halfLonDelta = toRadians(end.getLon() - lon) / 2;

		double a = sin(halfLatDelta) * sin(halfLatDelta) + 
				   cos(toRadians(lat)) * cos(toRadians(end.getLat())) *
				   sin(halfLonDelta) * sin(halfLonDelta);

		return 2 * EARTH_RADIUS * asin(sqrt(a));
	}
}