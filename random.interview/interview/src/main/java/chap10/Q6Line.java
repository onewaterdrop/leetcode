package chap10;

import java.awt.Point;
import java.util.HashMap;

public class Q6Line {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] points = new Point[6];
		points[0]= new Point(0,0);
		points[1]= new Point(1,1);
		points[2]= new Point(2,2);
		points[3]= new Point(3,3);
		points[4]= new Point(5,4);
		points[5]= new Point(5,8);
		
		Line l= findBestLine(points);
		System.out.println(l);

	}

	public static Line findBestLine(Point[] points) {
		Line bestLine = null;
		HashMap<Line, Integer> line_count = new HashMap<Line, Integer>();
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				Line line = new Line(points[i], points[j]);
				if (!line_count.containsKey(line)) {
					line_count.put(line, 0);
				}
				line_count.put(line, line_count.get(line) + 1);
				if (bestLine == null
						|| line_count.get(line) > line_count.get(bestLine)) {
					bestLine = line;
				}
			}
		}
		return bestLine;
	}

}

class Line {
	private static double epsilon = .0001;
	public double slope;
	public double intercept;
	private boolean infinite_slope = false;

	public Line(Point p, Point q) {
		if (Math.abs(p.x - q.x) > epsilon) { // if x’s are different
			slope = (p.y - q.y) / (p.x - q.x); // compute slope
			intercept = p.y - slope * p.x; // y intercept from y=mx+b
		} else {
			infinite_slope = true;
			intercept = p.x; // x-intercept, since slope is infinite
		}
	}

	public boolean isEqual(double a, double b) {
		return (Math.abs(a - b) < epsilon);
	}

	@Override
	public String toString() {
		System.out.println("slope "+slope+" intercept "+intercept);
		return "slope "+slope+" intercept "+intercept;
	}
	
	@Override
	public int hashCode() {
		int sl = (int) (slope * 1000);
		int in = (int) (intercept * 1000);
		return sl | in;
	}

	@Override
	public boolean equals(Object o) {
		Line l = (Line) o;
		if (isEqual(l.slope, slope) && isEqual(l.intercept, intercept)
				&& (infinite_slope == l.infinite_slope)) {
			return true;
		}
		return false;
	}
}