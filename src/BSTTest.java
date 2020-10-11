import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test the BST function (you should throw this away for your project)
 *
 * @author Lihui Zhang/lihuiz
 * @author Haosu Wang/whaosu
 * @version Oct 2020
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
    private Rectangle c;
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
        c = new Rectangle("c", 0, 1, 4, 4);
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
     * Test remove.
     */
    public void testRemove() {
        bst.insert(a);
        assertTrue(bst.search(a));
        bst.remove(a);
        assertFalse(bst.search(a));
        assertTrue(bst.isTreeEmpty());
        bst.insert(a);
        bst.insert(a2);
        bst.insert(b);
        bst.insert(b2);
        assertTrue(bst.search(a));
        assertTrue(bst.search(a2));
        assertTrue(bst.search(b));
        assertTrue(bst.search(b2));
        assertTrue(bst.remove(b2));
        assertFalse(bst.search(b2));
        assertTrue(bst.search(a));
        assertTrue(bst.search(a2));
        assertTrue(bst.search(b));
        assertTrue(bst.remove(a));
        assertTrue(bst.remove(a2));
        assertFalse(bst.search(a));
        assertFalse(bst.search(a2));

        // test remove an empty tree
        bst = new BST<Rectangle, String>();
        assertFalse(bst.remove(a));
        
        // test remove an unexisting node
        bst.insert(a);
        assertFalse(bst.remove(b));

        // test remove tree with 1 node only
        bst = new BST<Rectangle, String>();
        bst.insert(a);
        assertTrue(bst.remove(a));
        assertTrue(bst.isTreeEmpty());

        // test remove left child while no right child
        bst.insert(d);
        bst.insert(a);
        assertTrue(bst.remove(a));
        assertTrue(bst.search(d));
        assertFalse(bst.search(a));

        // test remove right child while no left child
        bst = new BST<Rectangle, String>();
        bst.insert(a);
        bst.insert(d);
        assertTrue(bst.remove(d));
        assertTrue(bst.search(a));
        assertFalse(bst.search(d));

        // test remove left child
        bst = new BST<Rectangle, String>();
        bst.insert(d);
        bst.insert(a);
        bst.insert(e);
        assertTrue(bst.remove(a));
        assertTrue(bst.search(d));
        assertTrue(bst.search(e));
        assertFalse(bst.search(a));

        // test remove right child
        bst = new BST<Rectangle, String>();
        bst.insert(d);
        bst.insert(a);
        bst.insert(e);
        assertTrue(bst.remove(e));
        assertTrue(bst.search(a));
        assertTrue(bst.search(d));
        assertFalse(bst.search(e));

        // test remove left child while it has 2 child. its left child < right
        bst = new BST<Rectangle, String>();
        bst.insert(d);
        bst.insert(b);
        bst.insert(a);
        bst.insert(c);
        assertTrue(bst.remove(b));
        assertTrue(bst.search(a));
        assertTrue(bst.search(d));
        assertTrue(bst.search(c));
        assertFalse(bst.search(b));

        // test remove right child while it has 2 child. its left child < right
        bst = new BST<Rectangle, String>();
        bst.insert(a);
        bst.insert(d);
        bst.insert(e);
        bst.insert(c);
        assertTrue(bst.remove(d));
        assertTrue(bst.search(a));
        assertTrue(bst.search(e));
        assertTrue(bst.search(c));
        assertFalse(bst.search(d));

        // test remove null
        bst.remove(null);

        // test remove left child name b when b has a left child
        bst = new BST<Rectangle, String>();
        bst.insert(c);
        bst.insert(b);
        bst.insert(a);
        assertTrue(bst.remove(b));
        assertTrue(bst.search(c));
        assertTrue(bst.search(a));
        assertFalse(bst.search(b));

        // test remove left child name a when a has a right child
        bst = new BST<Rectangle, String>();
        bst.insert(c);
        bst.insert(a);
        bst.insert(b);
        assertTrue(bst.remove(a));
        assertTrue(bst.search(c));
        assertTrue(bst.search(b));
        assertFalse(bst.search(a));

        // test remove right child name c when c has a left child
        bst = new BST<Rectangle, String>();
        bst.insert(a);
        bst.insert(c);
        bst.insert(b);
        assertTrue(bst.remove(c));
        assertTrue(bst.search(a));
        assertTrue(bst.search(b));
        assertFalse(bst.search(c));

        // test remove right child name b when b has a right child
        bst = new BST<Rectangle, String>();
        bst.insert(a);
        bst.insert(b);
        bst.insert(c);
        assertTrue(bst.remove(b));
        assertTrue(bst.search(a));
        assertTrue(bst.search(c));
        assertFalse(bst.search(b));
    }
    
    /**
     * test hasRecord
     */
    public void testHasRecord() {
        bst = new BST<Rectangle, String>();
        assertFalse(bst.hasRecord(bst.root, a));
        bst.insert(a);
        assertFalse(bst.hasRecord(bst.root, null));
        assertTrue(bst.hasRecord(bst.root, a));
        assertFalse(bst.hasRecord(bst.root, b));
        
        bst = new BST<Rectangle, String>();
        bst.insert(a);
        bst.insert(b);
        assertTrue(bst.hasRecord(bst.root, a));
        assertTrue(bst.hasRecord(bst.root, b));
        
        bst = new BST<Rectangle, String>();
        bst.insert(b);
        bst.insert(a);
        assertTrue(bst.hasRecord(bst.root, a));
        assertTrue(bst.hasRecord(bst.root, b));
    }
    

    /**
     * test dump
     */
    public void testDump() {
        bst = new BST<Rectangle, String>();
        assertTrue(bst.isTreeEmpty());
        bst.insert(a);
        bst.insert(a2);
        bst.insert(b);
        bst.insert(b2);
        bst.dump();
        assertFalse(bst.isTreeEmpty());
    }
    
}
