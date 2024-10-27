public class Square {
    Point topLeft;
    double side;

    public Square(Point topLeft, double side) {
        this.topLeft = topLeft;
        this.side = side;
    }

    public double area() {
        return side * side;
    }

    public double perimeter() {
        return 4 * side;
    }

    public boolean contains(Point p) {
        return p.x >= topLeft.x && p.x <= topLeft.x + side && p.y >= topLeft.y && p.y <= topLeft.y + side;
    }

    @Override
    public int hashCode() {
        return topLeft.hashCode() + (int)side;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Square other = (Square) obj;
        if (!topLeft.equals(other.topLeft))
            return false;
        if (side != other.side)
            return false;
        return true;
    }
}