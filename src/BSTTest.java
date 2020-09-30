import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test the BST function (you should throw this away for your project)
 *
 * @author Lihui Zhang/lihuiz
 * @author Haosu Wang/whaosu
 * @version 1.0
 */
public class BSTTest extends TestCase {

    private BST<Rectangle, String> bst;
    private Rectangle a;
    private Rectangle a2;
    private Rectangle b;
    private Rectangle b2;
    private Rectangle d;
    private Rectangle e;
    private Rectangle g;
    private Rectangle f;
    private Rectangle h;
    private Rectangle p;
    private Rectangle l;
    
    /**
     * setUp the condition.
     */
    public void setUp() {
        bst = new BST<Rectangle, String>();
        a = new Rectangle("a", 1, 1, 1, 3);
        a2 = new Rectangle("a2", 10, 1, 4, 1);
        b = new Rectangle("b", 2, 6, 3, 1);
        b2 = new Rectangle("b2", 4, 7, 1, 3);
        d = new Rectangle("d", 7, 1, 1, 3);
        e = new Rectangle("e", 6, 2, 3, 1);
        g = new Rectangle("g", 8, 7, 4, 1);
        f = new Rectangle("f", 8, 6, 4, 1);
        h = new Rectangle("h", 0, 1, 4, 1);
        p = new Rectangle("p", 6, 3, 3, 1);
        l = new Rectangle("l", 0, 1, 4, 4);
    }

    /**
     * test rectangle constructors
     */
    public void testConstructor() {
        assertTrue(bst.isTreeEmpty());
    }
    

    /**
     * Test insert.
     */
    public void testInsert() {
        bst.insert(a);
        bst.insert(a2);
        bst.insert(b);
        bst.insert(b2);
        bst.insert(d);
        bst.insert(e);
        bst.insert(g);
        bst.insert(f);
        bst.insert(h);
        bst.insert(p);
        bst.insert(l);
        assertTrue(bst.search(a));
        assertTrue(bst.search(a2));
        assertTrue(bst.search(b));
        assertTrue(bst.search(b2));
        assertTrue(bst.search(d));
        assertTrue(bst.search(e));
        assertTrue(bst.search(f));
        assertTrue(bst.search(g));
        assertTrue(bst.search(f));
        assertTrue(bst.search(h));
        assertTrue(bst.search(p));
        assertTrue(bst.search(l));
        assertFalse(bst.search(new Rectangle()));
    }

    /**
     * test dump
     */
    public void testDump() {
        bst.insert(a);
        bst.insert(a2);
        bst.insert(b);
        bst.insert(b2);
        bst.dump();
        assertEquals(bst.isTreeEmpty(), false);
    }
    
}
