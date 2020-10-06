import student.TestCase;

/**
 * test the Node function
 * 
 * @author Lihui Zhang/lihuiz
 * @author Haosu Wang/whaosu
 * @version Oct 2020
 */
public class NodeTest extends TestCase {
    private Node<String, String> n1;
    private Node<String, String> n2;
    private String str;
    
    /**
     * set up the Node
     */
    public void setUp() {
        n1 = new Node<String, String>();
        str = "string";
        n2 = new Node<String, String>(str);
    }
    
    /**
     * test getLeftChild
     */
    public void testGetLeftChild() {
        assertNull(n1.getLeftChild());
        assertNull(n1.getLeftChild());
    }

    /**
     * test getRightChild
     */
    public void testGetRightChild() {
        assertNull(n1.getRightChild());
        assertNull(n2.getRightChild());
    }

    /**
     * test getKey
     */
    public void testGetKey() {
        assertNull(n2.getKey());
    }
    
    /**
     * test getData
     */
    public void testGetData() {
        assertEquals(str, n2.getData());
    }
    
    /**
     * test setData
     */
    public void testSetData() {
        String str2 = "Hello";
        n2.setData(str2);
        assertEquals(str2, n2.getData());
    }

    /**
     * test setKey
     */
    public void testSetKey() {
        String str2 = "Hello";
        n2.setKey(str2);
        assertEquals(str2, n2.getKey());
    }

    /**
     * test setLeftChild
     */
    public void testSetLeftChild() {
        String str2 = "Hello";
        Node<String, String> left = new Node<String, String>(str2);
        n2.setLeftChild(left);
        assertEquals(left, n2.getLeftChild());
    }
    
    /**
     * test setRightChild
     */
    public void testSetRightChild() {
        String str2 = "Hello";
        Node<String, String> right = new Node<String, String>(str2);
        n2.setRightChild(right);
        assertEquals(right, n2.getRightChild());
    }

    /**
     * test isLeaf
     */
    public void testIsLeaf() {
        assertTrue(n2.isLeaf());

        String str2 = "Hello";
        Node<String, String> left = new Node<String, String>(str2);
        n2.setLeftChild(left);
        assertFalse(n2.isLeaf());

        Node<String, String> right = new Node<String, String>(str2);
        n2.setRightChild(right);
        assertFalse(n2.isLeaf());
    }
    
    /**
     * test setDepth and get Depth
     */
    public void testSetAndGetDepth() {
        assertEquals(-1, n2.getDepth());
        assertEquals(-1, n1.getDepth());
        n2.setDepth(4);
        assertEquals(4, n2.getDepth());
    }
}
