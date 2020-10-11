/**
 * Stub for binary search tree class
 * 
 * @author Lihui Zhang/lihuiz
 * @author Haosu Wang/whaosu
 * @version Oct 2020
 * @param <T> the generic type; extends Comparable
 * @param <E> the generic type; extends Comparable
 */
public class BST<T extends Comparable<T>, E extends Comparable<E>> {

    /** The root. */
    protected Node<T, E> root;

    /** The size. */
    private int nodecount;

    /**
     * Instantiates a new Binary Search Tree.
     */
    public BST() {
        root = null;
        nodecount = 0;
    }
    
    /**
     * Check if the tree is empty
     * 
     * @return true if the tree is empty
     */
    public boolean isTreeEmpty() {
        return (root == null);
    }
    
    /**
     * Check if has record in subTreeNode
     * 
     * @param subTreeNode
     *           the Node
     * @param target
     *           the target record
     * @return true if found
     */
    public boolean hasRecord(
        Node<Rectangle, String> subTreeNode, 
        Rectangle target) {
        if (subTreeNode == null) {
            return false;
        }
        if (target == null) {
            return false;
        }
        Rectangle rec = subTreeNode.getData();
        if (rec.equals(target)) {
            return true;
        }
        
        return hasRecord(subTreeNode.getLeftChild(), target) || 
            hasRecord(subTreeNode.getRightChild(), target);
    }
    
    /**
     * find the Node base on its name
     * 
     * @param subTreeNode 
     *           the Node
     * @param target
     *           the name of the target
     * @return the target found
     */
    public T findNodeHelper(Node<T, E> subTreeNode, T target) {
        if (subTreeNode == null) {
            return null;
        }

        if (subTreeNode.getData().compareTo(target) == 0) {
            //subTreeNode.activateDelete();
            return subTreeNode.getData();
        }

        else if (findNodeHelper(subTreeNode.getLeftChild(), target) == null) {
            return findNodeHelper(subTreeNode.getRightChild(), target);
        }
        else {
            return findNodeHelper(subTreeNode.getLeftChild(), target);
        }
    }
    
    /**
     * search all element
     * 
     * @param subTreeNode
     *          the Node
     * @param target
     *          the target to search
     * @return the object
     */
    
    private T searchAllHelper(Node<T, E> subTreeNode, T target) {
        if (subTreeNode == null) {
            return null;
        }

        if (subTreeNode.getData().compareTo(target) == 0) {
            System.out.println(subTreeNode.getData().toString());
            return searchAllHelper(subTreeNode.getLeftChild(), target);
        }
        else if (subTreeNode.getData().compareTo(target) > 0) {
            return searchAllHelper(subTreeNode.getLeftChild(), target);
        }
        else {
            return searchAllHelper(subTreeNode.getRightChild(), target);
        }
    }
    
    /**
     * the helper to dump a subtree node
     * 
     * @param subTreeNode
     *          the target node
     */
    private void dumpHelper(Node<T, E> subTreeNode) {
        if (subTreeNode != null) {
            dumpHelper(subTreeNode.getLeftChild());
            System.out.println("Node has depth " + 
                subTreeNode.getDepth() + ", Value " + 
                subTreeNode.getData().toString());
            dumpHelper(subTreeNode.getRightChild());
        }
    }

    /**
     * the helper to insert a node
     * 
     * @param subTreeNode
     *          the node
     * @param item
     *          the item needed to insert
     * @return an node
     */
    private Node<T, E> insertHelper(Node<T, E> subTreeNode, T item) {
        if (subTreeNode == null) {
            return new Node<T, E>(item);
        }
        if (item.compareTo(subTreeNode.getData()) <= 0) {
            subTreeNode.setLeftChild(this.insertHelper(
                subTreeNode.getLeftChild(), item));
        }
        else {
            subTreeNode.setRightChild(this.insertHelper(
                subTreeNode.getRightChild(), item));
        }
        return subTreeNode;
    }
    
    /**
     * remove the max Node
     * 
     * @param subTreeNode
     *           the Node
     * @return the Node after removed
     */
    private Node<T, E> removeMax(Node<T, E> subTreeNode) {
        if (subTreeNode.getRightChild() == null) {
            return subTreeNode.getLeftChild();
        }
        subTreeNode.setRightChild(removeMax(subTreeNode.getRightChild()));
        return subTreeNode;
    }
    
    /**
     * remove the max Node
     * 
     * @param subTreeNode
     *           the Node
     * @return the Node after removed
     */
    private Node<Rectangle, String> removeMaxdim(
        Node<Rectangle, String> subTreeNode) {
        if (subTreeNode.getRightChild() == null) {
            return subTreeNode.getLeftChild();
        }
        subTreeNode.setRightChild(removeMaxdim(subTreeNode.getRightChild()));
        return subTreeNode;
    }
    
    /**
     * get the max Node
     * 
     * @param subTreeNode
     *           the Node
     * @return the max Node
     */
    private Node<T, E> getMax(Node<T, E> subTreeNode) {
        if (subTreeNode.getRightChild() == null) {
            return subTreeNode;
        }
        return getMax(subTreeNode.getRightChild());
    }
    
    /**
     * get the max Node
     * 
     * @param subTreeNode
     *           the Node
     * @return the max Node
     */
    private Node<Rectangle, String> getMaxdim(
        Node<Rectangle, String> subTreeNode) {
        if (subTreeNode.getRightChild() == null) {
            return subTreeNode;
        }
        return getMaxdim(subTreeNode.getRightChild());
    }
    
    /**
     * the Helper to remove the target by the name
     * 
     * @param subTreeNode
     *           the Node
     * @param target
     *           the target(name) to remove
     * @return the Node after removed
     */
    private Node<T, E> removeHelper(Node<T, E> subTreeNode, T target) {
        if (subTreeNode.getData().compareTo(target) > 0) {
            subTreeNode.setLeftChild(removeHelper(
                subTreeNode.getLeftChild(), target));
        }
        
        else if (subTreeNode.getData().compareTo(target) < 0) {
            subTreeNode.setRightChild(removeHelper(
                subTreeNode.getRightChild(), target));
        }
        
        //found it
        else {
            if (subTreeNode.getLeftChild() == null) {
                return subTreeNode.getRightChild();
            }
            else if (subTreeNode.getRightChild() == null) {
                return subTreeNode.getLeftChild();
            }
            else {
                Node<T, E> temp = getMax(subTreeNode.getLeftChild());
                subTreeNode.setData(temp.getData());
                subTreeNode.setLeftChild(removeMax(subTreeNode.getLeftChild()));
            }
        }
        return subTreeNode;
    }
    
    /**
     * the Helper to remove by dimension
     * @param subTreeNode
     *           the Node
     * @param target
     *           the target(dimension) to remove
     * @return the Node after removed
     */
    private Node<Rectangle, String> removeDimhelper(
        Node<Rectangle, String> subTreeNode, 
        Rectangle target) {
        if (subTreeNode.getData().compareTo(target) > 0) {
            subTreeNode.setLeftChild(removeDimhelper(
                subTreeNode.getLeftChild(), target));
        }
        
        else if (subTreeNode.getData().compareTo(target) < 0) {
            subTreeNode.setRightChild(removeDimhelper(
                subTreeNode.getRightChild(), target));
        }
        
        else if (!subTreeNode.getData().dimequals(target)) {
            subTreeNode.setLeftChild(removeDimhelper(
                subTreeNode.getLeftChild(), target));
        }
        
        else {
            if (subTreeNode.getLeftChild() == null) {
                return subTreeNode.getRightChild();
            }
            else if (subTreeNode.getRightChild() == null) {
                return subTreeNode.getLeftChild();
            }
            else {
                Node<Rectangle, String> temp = getMaxdim(
                    subTreeNode.getLeftChild());
                subTreeNode.setData(temp.getData());
                subTreeNode.setLeftChild(removeMaxdim(
                    subTreeNode.getLeftChild()));
            }
        }
        return subTreeNode;
        
    }
    
    /**
     * the helper to set node's depth
     * @param subTreeNode 
     *          the node
     * @param level
     *          the depth of the node 
     */
    private void setDepthHelper(Node<T, E> subTreeNode, int level) {
        if (subTreeNode == null) {
            return;
        }
        else {
            subTreeNode.setDepth(level);
            setDepthHelper(subTreeNode.getLeftChild(), level + 1);
            setDepthHelper(subTreeNode.getRightChild(), level + 1);
        }
    }

    /**
     * insert an item
     * @param item
     *          the item to insert
     */
    public void insert(T item) {
        root = insertHelper(root, item);
        nodecount++;
    }
    
    /**
     * dump the whole tree
     */
    public void dump() {
        if (root == null) {
            System.out.println("Node has depth 0, Value (null)");
            System.out.println("BST size is: " + this.nodecount);
        }
        else {
            this.setDepthHelper(root, 0);
            dumpHelper(root);
            System.out.println("BST size is: " + this.nodecount);
        }
    }

    /**
     * search for a target
     * @param target
     *          the target to search
     * @return true if found
     *         false if not found
     */
    public boolean search(T target) {
        if (findNodeHelper(root, target) == null) {
            return false;
        }
        this.searchAllHelper(root, target);
        return true;
    }
    
    /**
     * remove the target
     * 
     * @param target
     *           the target to remove
     * @return true if success
     *         false if failed
     */
    public boolean remove(T target) {
        if (target == null) {
            return false;
        }
        if (root == null) {
            return false;
        }
        
        T targetFound = findNodeHelper(root, target);
        
        if (targetFound == null) {
            return false;
        }
        else {
            root = removeHelper(root, target);
            nodecount--;
            return true;
        }
    }
    
    /**
     * remove the target by dimension
     * @param bst
     *         the BST
     * @param target
     *         the target to remove
     */
    public void removeDim(Node<Rectangle, String> bst, Rectangle target) {
        bst = removeDimhelper(bst, target);
        nodecount--;
    }
    
    
}
