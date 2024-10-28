package lab5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircleTests {

    private Circle circle;
    private Point center;

    @BeforeEach
    public void setUp() {
        center = new Point(0, 0); // center at origin
        circle = new Circle(center, 5.0); // radius of 5.0
    }

    @Test
    public void testConstructor_validParameters() {
        assertNotNull(circle);
        assertEquals(center, circle.center);
        assertEquals(5.0, circle.radius);
    }

    @Test
    public void testConstructor_invalidRadius() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Circle(center, -5.0); // invalid radius
        });
        assertEquals("Radius must be positive", exception.getMessage());
        
// other possible way to test the exception.
    	
//    	try {
//            new Circle(center, -5.0); // invalid radius
//            fail("Expected IllegalArgumentException for non-positive radius");
//            //fail(...) makes sure that even though in the case where Circle(center, -0.5) didn't throw exception, it makes sure the it failed. 
//        } catch (IllegalArgumentException e) {
//            assertEquals("Radius must be positive", e.getMessage());
//        }
    }

    @Test
    public void testConstructor_nullCenter() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Circle(null, 5.0); // null center
        });
        assertEquals("Center point cannot be null", exception.getMessage());
        
// other possible way to test the exception .
    	
//    	try {
//    		new Circle(null, 5.0);
//    		fail("Expected IllegalArgumentException for null center");
//    	} catch (IllegalArgumentException e) {
//    		assertEquals("Center point cannot be null", e.getMessage());
//    	}
    }

    @Test
    public void testComputeArea() {
        assertEquals(Math.PI * 25.0, circle.computeArea(), 1e-6); // area should be PI * r^2
    }

    @Test
    public void testComputePerimeter() {
        assertEquals(Math.PI * 10.0, circle.computePerimeter(), 1e-6); // perimeter should be 2 * PI * r
    }

    @Test
    public void testPointInCircle_pointInside() {
        Point p = new Point(3, 4); // inside the circle (3^2 + 4^2 = 25)
        assertTrue(circle.pointInCircle(p));
    }

    @Test
    public void testPointInCircle_pointOnBoundary() {
        Point p = new Point(5, 0); // on the boundary of the circle
        assertTrue(circle.pointInCircle(p));
    }

    @Test
    public void testPointInCircle_pointOutside() {
        Point p = new Point(6, 0); // outside the circle
        assertFalse(circle.pointInCircle(p));
    }

    @Test
    public void testEquals_sameCircle() {
        Circle anotherCircle = new Circle(center, 5.0);
        assertEquals(circle, anotherCircle);
    }

    @Test
    public void testEquals_differentCenter() {
        Circle anotherCircle = new Circle(new Point(1, 1), 5.0);
        assertNotEquals(circle, anotherCircle);
    }

    @Test
    public void testEquals_differentRadius() {
        Circle anotherCircle = new Circle(center, 4.9);
        assertNotEquals(circle, anotherCircle);
    }
    
    @Test 
    public void testEqualCircleItself() {
    	assertEquals(circle, circle);
    }
    
    @Test
    public void testEqualCircleNull() {
    	assertNotEquals(circle, null);
    }
    
    @Test
    public void testEqualCircleNotanInstance() {
    	String test = "Hello world";
    	assertNotEquals(circle, test);
    }

    @Test
    public void testHashCode() {
        Circle anotherCircle = new Circle(center, 5.0);
        assertEquals(circle.hashCode(), anotherCircle.hashCode());
    }
    
    
}

