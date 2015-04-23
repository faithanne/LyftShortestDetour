package org.strieber.faithanne.lyft;

import java.text.DecimalFormat;

public class Driver {
	
	private String name;
	private Point start;
	private Point end;
	
	public Driver(String name, Point start, Point end) {
		this.name = name;
		this.start = start;
		this.end = end;
	}

	public String getName() {
		return name;
	}

	public Point getStart() {
		return start;
	}

	public Point getEnd() {
		return end;
	}
	
	public double getRouteDistance() {
		return start.getDistanceTo(end);
	}
	
	public double getDetourDistance(Driver strandedDriver) {
		double original = getRouteDistance();
		double pickup   = start.getDistanceTo(strandedDriver.getStart());
		
		double stranded = strandedDriver.getRouteDistance();
		double lastLeg  = strandedDriver.getEnd().getDistanceTo(end);
		
		return pickup + stranded + lastLeg - original;
	}
	
	public static String getShortestDetour(Driver driver1, Driver driver2) {
		double detour1 = driver1.getDetourDistance(driver2);
		double detour2 = driver2.getDetourDistance(driver1);
		
		if (detour1 < detour2) {
			return printShortestDetour(driver1.getName(), detour1);
		}
		else {
			return printShortestDetour(driver2.getName(), detour2);
		}
	}
	
	public static String printShortestDetour(String name, double distance) {
		return "Shortest Detour → " + name + " @ " + new DecimalFormat("#.##").format(distance) + " mi.";
	}
	
	public static void main(String[] args) {
		
		Point a = new Point(32.132832, -81.250125);
		Point b = new Point(32.001945, -81.116934);
		Point c = new Point(31.990311, -81.069813);
		Point d = new Point(32.076528, -81.096666);
		System.out.println(getShortestDetour(new Driver("Driver 1", a, b), new Driver("Driver 2", c, d)));
	}
}