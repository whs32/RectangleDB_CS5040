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
    
    /**
     * set up the Rectangle
     */
    public void setUp() {
        default1 = new Rectangle();
        a = new Rectangle("a", 1, 1, 1, 3);
        b = new Rectangle("b");
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
    
}
