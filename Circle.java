package lab5;

public class Circle {
    Point center;
    double radius;
    private static final double EPSILON = 1e-6;

    public Circle(Point center, double radius) {
    	if (center == null)
            throw new IllegalArgumentException("Center point cannot be null");		
        if (radius <= 0)
            throw new IllegalArgumentException("Radius must be positive");
        this.center = center;
        this.radius = radius;
    }

    public double computeArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double computePerimeter() {
        return Math.PI * radius * 2.0;
    }

    public boolean pointInCircle(Point p) {
        return p.distance(center) <= radius;
    }
    
    @Override
    public int hashCode() {
        return center.hashCode() + Double.hashCode(radius) ;
    }
    
    @Override
    public boolean equals(Object obj){
    	if (this == obj) return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Circle))
            return false;
        Circle c = (Circle)obj;
        return this.center.equals(c.center) && Math.abs(this.radius - c.radius) < EPSILON;
    }
}
