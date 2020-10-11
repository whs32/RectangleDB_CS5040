import student.TestCase;

/**
 * test the Rectangle function
 * 
 * @author Lihui Zhang/lihuiz
 * @author Haosu Wang/whaosu
 * @version Oct 2020
 */
public class RectangleTest extends TestCase {
    private Rectangle default1;
    private Rectangle a;
    private Rectangle b;
    private Rectangle c;
    private Rectangle d;
    private Rectangle e;
    private Rectangle f;
    private Rectangle g;
    
    /**
     * set up the Rectangle
     */
    public void setUp() {
        default1 = new Rectangle();
        a = new Rectangle("a", 1, 1, 1, 3);
        b = new Rectangle("b");
        c = new Rectangle("c", 1, 1, 1, 3);
        d = new Rectangle("d", 2, 1, 1, 3);
        e = new Rectangle("e", 1, 2, 1, 3);
        f = new Rectangle("f", 1, 1, 2, 3);
        g = new Rectangle("c", 1, 1, 1, 4);
    }
    
    /**
     * test getname
     */
    public void testGetName() {
        assertEquals("a", a.getname());
        assertEquals("b", b.getname());
        assertEquals("", default1.getname());
    }
    
    /**
     * test getX, getY, getWidth, getHeight
     */
    public void testGetXYWH() {
        assertEquals(1, a.getX());
        assertEquals(1, a.getY());
        assertEquals(1, a.getWidth());
        assertEquals(3, a.getHeight());
        
        assertEquals(0, b.getX());
        assertEquals(0, b.getY());
        assertEquals(0, b.getHeight());
        assertEquals(0, b.getWidth());
    }
    
    /**
     * test dimequals
     */
    public void testDimequals() {
        assertTrue(a.dimequals(c));
        assertFalse(a.dimequals(d));
        assertFalse(a.dimequals(e));
        assertFalse(a.dimequals(f));
        assertFalse(a.dimequals(g));
    }
}
