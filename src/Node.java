/**
 * Stub for Node class
 * 
 * @author Lihui Zhang/lihuiz
 * @author Haosu Wang/whaosu
 * @param <T> the generic type; extends Comparable
 * @param <E> the generic type; extends Comparable
 * @version Oct 2020
 */
public class Node<T extends Comparable<T>, E extends Comparable<E>> {
    private T data;
    private E key;
    private Node<T, E> leftChild;
    private Node<T, E> rightChild;
    private int depth;

    /**
     * Default Node
     */
    public Node() {
        this.data = null;
        this.key = null;
        this.leftChild = null;
        this.rightChild = null;
        this.depth = -1;
       // this.delflag = false;
    }
    
    /**
     * Parameterize constructor
     * @param t
     *         a T data
     */
    public Node(T t) {
        this.key = null;
        this.data = t;
        this.leftChild = null;
        this.rightChild = null;
        this.depth = -1;
       // this.delflag = false;
    }
    
    /**
     * get the left child node
     * @return the left child node
     */
    public Node<T, E> getLeftChild() {
        return leftChild;
    }
    
    /**
     * get the right child node
     * @return the right child node
     */
    public Node<T, E> getRightChild() {
        return rightChild;
    }
    
    /**
     * get the key of the node
     * @return the Node key
     */
    public E getKey() {
        return key;
    }
    
    /**
     * get the data of the node
     * @return the Node data
     */
    public T getData() {
        return data;
    }
    
    /**
     * set the Data of the node
     * @param item the item
     */
    public void setData(T item) {
        this.data = item;
    }
    
    /**
     * set the Key of the node
     * @param item the item
     */
    public void setKey(E item) {
        this.key = item;
    }
    
    /**
     * set the left child of the node
     * @param child a node child
     */
    public void setLeftChild(Node<T, E> child) {
        this.leftChild = child;
    }
    
    /**
     * set the right child of the node
     * @param child a node child
     */
    public void setRightChild(Node<T, E> child) {
        this.rightChild = child;
    }
    
    /**
     * check if the node is a leaf node
     * @return true if the node is a leaf node
     *         false if not
     */
    public boolean isLeaf() {
        return (this.leftChild == null && this.rightChild == null);
    }
    
    /**
     * set the depth of the node
     * @param level
     *           depth level of the current node
     */
    public void setDepth(int level) {
        this.depth = level;
    }
    
    /**
     * get the depth of the node
     * @return the depth of the node
     */
    public int getDepth() {
        return this.depth;
    }
    
}