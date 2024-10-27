import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void testArea() {
        Square square = new Square(new Point(0, 0), 5);
        assertEquals(25, square.area(), "Area should be side squared.");
    }

    @Test
    void testPerimeter() {
        Square square = new Square(new Point(0, 0), 5);
        assertEquals(20, square.perimeter(), "Perimeter should be four times the side length.");
    }

    @Test
    void testContainsPointInside() {
        Square square = new Square(new Point(0, 0), 5);
        assertTrue(square.contains(new Point(2, 2)), "Point (2, 2) should be inside the square.");
    }

    @Test
    void testContainsPointOutside() {
        Square square = new Square(new Point(0, 0), 5);
        assertFalse(square.contains(new Point(6, 6)), "Point (6, 6) should be outside the square.");
    }

    @Test
    void testContainsPointOnEdge() {
        Square square = new Square(new Point(0, 0), 5);
        assertTrue(square.contains(new Point(5, 0)), "Point (5, 0) should be on the edge and considered inside.");
    }

    @Test
    void testEqualsSameObject() {
        Square square = new Square(new Point(0, 0), 5);
        assertEquals(square, square, "The same object should be equal to itself.");
    }

    @Test
    void testEqualsDifferentObjectSameValues() {
        Square square1 = new Square(new Point(0, 0), 5);
        Square square2 = new Square(new Point(0, 0), 5);
        assertEquals(square1, square2, "Squares with the same topLeft and side should be equal.");
    }

    @Test
    void testNotEqualsDifferentSide() {
        Square square1 = new Square(new Point(0, 0), 5);
        Square square2 = new Square(new Point(0, 0), 6);
        assertNotEquals(square1, square2, "Squares with different side lengths should not be equal.");
    }

    @Test
    void testNotEqualsDifferentTopLeft() {
        Square square1 = new Square(new Point(0, 0), 5);
        Square square2 = new Square(new Point(1, 1), 5);
        assertNotEquals(square1, square2, "Squares with different topLeft points should not be equal.");
    }

    @Test
    void testHashCodeSameValues() {
        Square square1 = new Square(new Point(0, 0), 5);
        Square square2 = new Square(new Point(0, 0), 5);
        assertEquals(square1.hashCode(), square2.hashCode(), "Squares with the same properties should have the same hash code.");
    }

    @Test
    void testHashCodeDifferentValues() {
        Square square1 = new Square(new Point(0, 0), 5);
        Square square2 = new Square(new Point(0, 0), 6);
        assertNotEquals(square1.hashCode(), square2.hashCode(), "Squares with different properties should have different hash codes.");
    }
}
