package lab5;

public class Rectangle {
	Point bottomLeft;
	double base;
	double height;
		
	public Rectangle(Point point, double base, double height) {
		if (base <= 0)
            throw new IllegalArgumentException("Base must be positive.");
        if (height <= 0)
            throw new IllegalArgumentException("Height must be positive.");
        
		this.bottomLeft = point;
		this.base = base;
		this.height = height;
	}
		
	public double calculatePerimeter() {
		return (2 * base) + (2 * height);
	}
		
	public double calculateArea() {
		return height * base;
	}
		
	public boolean pointInRectangle(Point A) {
		return A.x <= (bottomLeft.x + base) && A.x >= bottomLeft.x && A.y <= (bottomLeft.y + height) && A.y >= bottomLeft.y; 
	}
		
	@Override
	public int hashCode() {
		if (bottomLeft == null)
			return 0;
		return bottomLeft.hashCode() + (int)(3*base + 5*height);
	}
		
	@Override
	public boolean equals(Object obj) {
		if (obj == null) 
			return false;
		if (obj == this) 
			return true;
		if (!(obj instanceof Rectangle))
			return false;
		Rectangle other = (Rectangle) obj;
		if (this.bottomLeft == null || bottomLeft == null)
			return false;
		return bottomLeft.equals(other.bottomLeft) && (height == other.height) && (base == other.base); 
	}
}
