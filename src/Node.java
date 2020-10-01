/**
 * Stub for Node class
 * 
 * @author Lihui Zhang/lihuiz
 * @author Haosu Wang/whaosu
 * @param <T> the generic type; extends Comparable
 * @param <E> the generic type; extends Comparable
 */

public class Node<T extends Comparable<T>, E extends Comparable<E>> {
    private T data;
    private E key;
    private Node<T,E> leftChild;
    private Node<T,E> rightChild;
    private int Depth;
    /**
     * Default Node
     */
    public Node() {
        this.data = null;
        this.key = null;
        this.leftChild = null;
        this.rightChild = null;
        this.Depth = -1;
    }
    
    public Node(T t) {
        this.key = null;
        this.data = t;
        this.leftChild = null;
        this.rightChild = null;
        this.Depth = -1;
    }
    
    public Node<T, E> getLeftChild(){
        return leftChild;
    }
    
    
    public Node<T, E> getRightChild(){
        return rightChild;
    }
    
    
    public E getKey(){
        return key;
    }
    
    
    public T getData(){
        return data;
    }
    
    public void setData(T item) {
        this.data = item;
    }
    
    public void setKey(E item) {
        this.key = item;
    }
    
    public void setLeftChild(Node<T, E> Child) {
        this.leftChild = Child;
    }
    
    public void setRightChild(Node<T, E> Child) {
        this.rightChild = Child;
    }
    
    public boolean isLeaf() {
        return (this.leftChild == null && this.rightChild == null);
    }
    
    public void setDepth(int level) {
        this.Depth = level;
    }
    
    public int getDepth() {
        return this.Depth;
    }
}
