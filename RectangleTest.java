package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectangleTest {

	@Test
    void testConstructorNegativeBase() {
        try {
            Rectangle r = new Rectangle(new Point(0, 0), -1, 2);
            assertFalse(true);
        } 
        catch (IllegalArgumentException ex) {
            assertEquals("Base must be positive.", ex.getMessage());
        }
    }

    @Test
    void testConstructorNegativeHeight() {
        try {
            Rectangle r = new Rectangle(new Point(0, 0), 1, -2);
            assertFalse(true);
        } 
        catch (IllegalArgumentException ex) {
            assertEquals("Height must be positive.", ex.getMessage());
        }
    }
	
	@Test
	void TestcalculatePerimeter(){
		Rectangle rec = new Rectangle(new Point(0,0), 1, 2);
		assertEquals(6, rec.calculatePerimeter());
	}
	
	@Test
	void TestcalculateArea() {
		Rectangle rec = new Rectangle(new Point(0,0), 1, 2);
		assertEquals(2, rec.calculateArea());
	}
	
	@Test
	void TestpointInRectangle() {
		Rectangle rec = new Rectangle(new Point(0,0), 1, 2);
		assertTrue(rec.pointInRectangle(new Point(1,1)));
	}
	
	@Test
	void TestpointNotInRectangle() {
		Rectangle rec = new Rectangle(new Point(0,0), 1, 2);
		assertFalse(rec.pointInRectangle(new Point(4,3)));
	}
	
	@Test
	void TestEqualsNullObject() {
		Point A = new Point(0,0);
		Rectangle rec = new Rectangle(A, 3, 4);
		Rectangle r = null;
		assertFalse(rec.equals(r));
	}
	
	@Test
	void TestEqualsSameObject() {
		Point A = new Point(0,0);
		Rectangle rec = new Rectangle(A, 3, 4);
		assertTrue(rec.equals(rec));
	}
	
	@Test
	void TestEqualsDiffClass() {
		Point A = new Point(0,0);
		Rectangle rec = new Rectangle(A, 3, 4);
		assertFalse(rec.equals(A));
	}
	
	@Test
	void TestEqualsNullPoint() {
		Point A = new Point(0,0);
		Rectangle rec1 = new Rectangle(A, 3, 4);
		Rectangle rec2 = new Rectangle(null, 3, 4);
		assertFalse(rec1.equals(rec2));
	}
	
	
	@Test
	void TestEqualsSameProperties() {
		Point A = new Point(0,0);
		Rectangle rec1 = new Rectangle(A, 3, 4);
		Rectangle rec2 = new Rectangle(A, 3, 4);
		assertTrue(rec1.equals(rec2));
	}
	
	@Test
	void TesthashCode() {
		Point A = new Point(0,0);
		Rectangle rec1 = new Rectangle(A, 3, 4);
		Rectangle rec2 = new Rectangle(A, 3, 4);
		assertEquals(rec1.hashCode(), rec2.hashCode());
	}

}
