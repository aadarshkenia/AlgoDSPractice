import java.util.Map;
import java.util.HashMap;

class _149 {
	public static void main(String args[]) {
		Point p1 = new Point(1,1);
		Point p2 = new Point(1,1);
		Point p3 = new Point(2,2);
		Point p4 = new Point(4,5);
		Point[] points = {p1, p2, p3, p4};
		Point[] points2 = {new Point(0,0), new Point(0,0)};
		System.out.println(new _149().maxPoints(points));
	}

	public int maxPoints(Point[] points) {
		if(points == null || points.length < 1) {
			return 0;
		} else if (points.length == 1) {
			return 1;
		}
		int globalMax = 2;
		for(Point p : points) {
			int maxLinearPoints = 1, samePointCounter = 0;
			Map<Slope, Integer> slopeToLinearPoints = new HashMap<>();
			for(Point q : points) {
				if(p != q) {
					//If points are the same, directly add this to maxLinearPoints per point
					if(q.x == p.x && q.y == p.y) {
						samePointCounter++;
					} else {
							Slope slope = calculateSlope(p, q);
							if(slopeToLinearPoints.containsKey(slope)) {
								int numPoints = slopeToLinearPoints.get(slope);
								if(numPoints + 1 > maxLinearPoints) {
									maxLinearPoints = numPoints + 1;
								}
								slopeToLinearPoints.put(slope, numPoints  + 1);
							} else {
								slopeToLinearPoints.put(slope, 2);
							}				
					
					}
				}
			}
			if(maxLinearPoints + samePointCounter > globalMax) {
				globalMax = maxLinearPoints + samePointCounter;
			}
		}
		return globalMax;
	}

	private Slope calculateSlope(Point p, Point q) {
		int ydiff = p.y - q.y;
		int xdiff = p.x - q.x;
		int gcd_ = gcd(ydiff, xdiff);
		return gcd_ != 0 ? new Slope(ydiff/gcd_, xdiff/gcd_) : new Slope(ydiff, xdiff);
	}

	public int gcd(int a, int b) {
		if(b == 0){
			return a;
		}
		return gcd(b, a%b);
	}

	static class Point {
		int x;
		int y;
		Point() {
			x=0; 
			y=0;
		}

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Slope {
		int ydiff;
		int xdiff;

		Slope(int yd, int xd) {
			xdiff = xd;
			ydiff = yd;
		}

		public int hashCode() {
			return xdiff*xdiff + ydiff*ydiff;
		}

		public boolean equals (Object other) {
			if(other != null && (other instanceof Slope)) {
				Slope other_ = (Slope)other;
				if(xdiff == 0 && other_.xdiff == 0) {
					return true;
				} else if(ydiff == 0 && other_.ydiff == 0) {
					return true;
				} else {
					return ydiff == other_.ydiff && xdiff == other_.xdiff;				
				}
			}
			return false;
		}
	}

}


