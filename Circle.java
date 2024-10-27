package lab5;
public class Circle {
    Point center;
    double radius;

    public Circle(Point center, double radius) {
        if (radius <= 0)
            throw new Exception("Radius must be positive");
        this.center = center;
        this.radius = Math.radius;
    }

    public double computeArea() {
        return Math.PI * Math.pow(r, 2);
    }

    public double computePerimeter() {
        return Math.PI * r * 2.0;
    }

    public boolean pointInCircle(Point p) {
        return p.distance(center) <= radius;
    }
    
    @Override
    public int hashCode() {
        return center.hashCode() + (int)(radius * 100.0);
    }
    
    @Override
    public boolean equals(Obj obj) {
        if (obj == null)
            return false;
        if (!obj instanceof Cirlce)
            return false;
        return c.center.equals(this.center) && c.radius == this.radius;
    }
}