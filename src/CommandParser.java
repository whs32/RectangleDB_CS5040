import java.util.Scanner;
import java.util.Iterator;
import java.util.Stack;

/**
 * Handle received commands and arguments for RectangleDB program.
 * 
 * @author Lihui Zhang/lihuiz
 * @author Haosu Wang/whaosu
 * 
 * @version Oct 2020
 */
public class CommandParser {
    
    /**
     * the dump command
     * 
     * @param bst
     *          the BST
     */
    public void dump(BST<Rectangle, String> bst) {
        System.out.println("BST dump:");
        bst.dump();
    }
    
    /**
     * the insert command
     * @param bst
     *          the BST
     * @param name
     *          the key(name) of the target
     * @param args
     *          the data(X,Y,W,H) of the target
     */
    public void insert(BST<Rectangle, String> bst, String name, String args) {
        try {
            int[] words = scanwords(args);
            // rectangle words to print when we are done
            String wordsToString = wordsToString(name, words);

            if (insertErr(name, words)) {
                System.out.println("Rectangle rejected: " + wordsToString);
                return;
            }

            Rectangle toInsert = new Rectangle(name, 
                words[0], words[1], words[2], words[3]);

            //check if duplicate
            if (bst.hasRecord(bst.root, toInsert)) {
                System.out.println("Rectangle rejected: " + wordsToString);
                return;
            }
            else {
                bst.insert(toInsert);
                System.out.println("Rectangle accepted: " + wordsToString);
            }
        }
        catch (Exception e) {
            // not a good specification for a rectangle found
            System.out.println("Rectangle rejected: " + name + args);
        }
    }
    
    /**
     * the remove command
     * @param bst
     *          the BST
     * @param args
     *          the target to remove
     */
    public void remove(BST<Rectangle, String> bst, String args) {
        try {
            args = args.replace("\n", "");
            args = args.trim();
            if (args.matches("[a-zA-Z][a-zA-Z0-9_]*")) {
                Rectangle target = new Rectangle(args);
                if (!bst.remove(target)) {
                    System.out.println("Rectangle rejected: " + args);
                }
            }
            
            else {
                int[] words = scanwords(args);
                String argsToString = String.format("(%d, %d, %d, %d)", 
                    words[0], words[1], words[2], words[3]);
                if (removeErr(words)) {
                    System.out.println("Rectangle rejected: " + argsToString);
                    return;
                }
                Node<Rectangle, String> item = bst.root;
                if (findCoordHelper(item, words) == null) {
                    System.out.println("Rectangle rejected: " + argsToString);
                }
                else {
                    Rectangle target = findCoordHelper(item, words);
                    bst.removeDim(bst.root, target);
                }
            }
        }
        catch (Exception e) {
            args = args.replace(" ", ", ");
            System.out.println("Rectangle rejected: " + "(" + args + ")");
        }
    }
    
    /**
     * the regionsearch command
     * @param bst
     *          the BST
     * @param args
     *          the region
     */
    public void regionsearch(BST<Rectangle, String> bst, String args) {
        try {
            args = args.replace("\n", "");
            args = args.trim();
            int[] words = scanwords(args);
            String argsToString = String.format("(%d, %d, %d, %d)", 
                words[0], words[1], words[2], words[3]);
            if (regionErr(words)) {
                return;
            }
            System.out.println("Rectangles intersecting region " + 
                argsToString);
            Rectangle target = new Rectangle("target", 
                words[0], words[1], words[2], words[3]);
            BSTIterator b = new BSTIterator(bst.root);
            while (b.hasNext()) {
                Node<Rectangle, String> next = b.next();
                if (isInRegion(target, next.getData()) || 
                    isInRegion(next.getData(), target)) {
                    System.out.println(next.getData().toString());
                }
            }
        }
        catch (Exception e) {
            //do nothing if caught exception
        }
    }
    
    /**
     * the intersections command
     * @param bst
     *           the BST
     */
    public void intersections(BST<Rectangle, String> bst) {
        try {
            System.out.println("Intersection pairs:");
            BSTIterator outer = new BSTIterator(bst.root);
            int inLoopIndex = 0;
            int outLoopIndex = 0;
            while (outer.hasNext()) {
                Node<Rectangle, String> next1 = outer.next();
                BSTIterator inner = new BSTIterator(bst.root);
                while (inner.hasNext()) {
                    Node<Rectangle, String> next2 = inner.next();
                    if (inLoopIndex > outLoopIndex && 
                        isIntersect(next1.getData(), next2.getData())) {
                        System.out.println(next1.getData().toString() + 
                            ":" + next2.getData().toString());
                    }
                    inLoopIndex++;
                }
                inLoopIndex = 0;
                outLoopIndex++;
            }
        }
        catch (Exception e) {
            //do nothing if caught exception
        }
    }
    
    /**
     * the search command
     * @param bst
     *           the BST
     * @param name
     *           the target's name
     */
    public void search(BST<Rectangle, String> bst, String name) {
        try {
            name = name.replace("\n", "");
            name = name.trim();
            Rectangle target =  new Rectangle(name);
            if (bst.findNodeHelper(bst.root, target) == null) {
                System.out.println("Rectangle not found:" + name);
            }
            else {
                BSTIterator b = new BSTIterator(bst.root);
                while (b.hasNext()) {
                    Node<Rectangle, String> next = b.next();
                    String nameNode = next.getData().getname();
                    if (nameNode.equals(name)) {
                        System.out.println("Rectangle found:" + 
                            next.getData().toString());
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("Rectangle not found:" + name);
        }
        
    }
    
    /**
     * to judge if there are some input errors
     * 
     * @param name
     *          the key(name) of the target
     * @param words
     *          the data(X,Y,W,H) of the target
     * @return true if there are some errors
     *         false if there is no error
     */
    public static boolean insertErr(String name, int[] words) {
        if (words.length != 4) {
            throw new IllegalArgumentException(
                "Uncorrect number of arguments in insert");
        }

        if (words[0] < 0 || words[1] < 0 || words[2] <= 0 || 
            words[3] <= 0 || words[0] + words[2] > 1024 || 
            words[1] + words[3] > 1024) {
            return true;
        }
        
                
        return !name.matches("[a-zA-Z][a-zA-Z0-9_]*");
    }
    
    /**
     * to judge if there are some remove errors
     * @param words
     *           the dimension of the target
     * @return true if there are some errors
     *         false if there is no error
     */
    
    public static boolean removeErr(int[] words) {
        if (words.length == 4) {
            if (words[0] < 0 || words[1] < 0 || words[2] <= 0 || 
                words[3] <= 0 || words[0] + words[2] > 1024 || 
                words[1] + words[3] > 1024) {
                return true;
            }

            if (Integer.valueOf(words[2]) <= 0 || 
                Integer.valueOf(words[3]) <= 0) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * to judge if there are some region errors
     * @param words
     *           the dimension of the target
     * @return true if there are some errors
     *         flase if there is no error
     */
    public static boolean regionErr(int[] words) {
        if (words.length == 4) {
            return Integer.valueOf(words[2]) <= 0 || 
                Integer.valueOf(words[3]) <= 0;
        }
        return false;
    }
    
    /**
     * change the dimension String into int
     * @param args
     *          the target to change
     * @return the changed target
     */
    private static int[] scanwords(String args) {
        int[] words = new int[4];
        Scanner sc = new Scanner(args);
        for (int i = 0; i < 4; ++i) {
            words[i] = sc.nextInt();
        }

        sc.close();
        return words;
    }
    
    /**
     * formalize the target to String
     * @param name
     *          the name of the target
     * @param words
     *          the dimension of the target
     * @return the formalized target
     */
    private static String wordsToString(String name, int[] words) {
        
        return String.format("(%s, %d, %d, %d, %d)", 
            name, words[0], words[1], words[2], words[3]);
    }

    /**
     * find the target by dimension
     * @param bst
     *          the BST
     * @param words
     *          the dimension to search
     * @return the found target
     */
    private Rectangle findCoordHelper(
        Node<Rectangle, String> bst, 
        int[] words) {
        
        if (bst == null) {
            return null;
        }
        if (words == null) {
            return null;
        }
        
        if (bst.getData().getX() == words[0] && 
            bst.getData().getY() == words[1] && 
            bst.getData().getWidth() == words[2] && 
            bst.getData().getHeight() == words[3]) {
            return bst.getData();
        }
        else if (findCoordHelper(bst.getLeftChild(), words) == null) {
            return findCoordHelper(bst.getRightChild(), words);
        }
        else {
            return findCoordHelper(bst.getLeftChild(), words);
        }
    }
    
    /**
     * to judge if one Rectangle is in the other Rectangle
     * @param target
     *        one of the target Rectangles
     * @param next
     *        the other Rectangle
     * @return true if target Rectangle is in next Rectangle
     *         false if not
     */
    private boolean isInRegion(Rectangle target, Rectangle next) {
        int tx = target.getX();
        int tx2 = target.getX() + target.getWidth();
        int ty = target.getY();
        int ty2 = target.getY() + target.getHeight();
        
        int nx = next.getX();
        int nx2 = next.getX() + next.getWidth();
        int ny = next.getY();
        int ny2 = next.getY() + next.getHeight();
        
        while (nx <= nx2) {
            if ((tx < nx) && (tx2 > nx)) {
                int temp = ny;
                while (temp <= ny2) {
                    if ((ty < temp) && (temp < ty2)) {
                        return true;
                    }
                    temp++;
                }
            }
            nx++;
        }
        return false;
    }
    
    /**
     * to judge if two Rectangles intersect
     * @param left
     *        one of the Rectangles
     * @param right
     *        the other Rectangle
     * @return true if two Rectangles intersect
     */
    private boolean isIntersect(Rectangle left, Rectangle right) {
        int lx = left.getX();
        int lx2 = left.getX() + left.getWidth();
        int ly = left.getY();
        int ly2 = left.getY() + left.getHeight();
        
        int rx = right.getX();
        int rx2 = right.getX() + right.getWidth();
        int ry = right.getY();
        int ry2 = right.getY() + right.getHeight();
        
        return (!(lx >= rx2 || rx >= lx2 || ly >= ry2 || ry >= ly2));
    }
    
    /**
     * Private iterator class that implements a preorder traversal of the BST
     * implements iterator class and uses stack class
     */
    private class BSTIterator implements Iterator<Node<Rectangle, String>> {
        private Stack<Node<Rectangle, String>> nodeStack =
            new Stack<Node<Rectangle, String>>();


        /**
         * Iterator constructor, pushes root onto the stack if it is not null
         */
        public BSTIterator(Node<Rectangle, String> root) {
            if (root != null) {
                nodeStack.push(root);
            }
        }


        /** 
         * Checks if iterator has another node in the stack 
         */
        public boolean hasNext() {
            return !(nodeStack.isEmpty());
        }


        /** 
         * Pushes a node onto the stack if it is not null 
         */
        public Node<Rectangle, String> next() {
            Node<Rectangle, String> current = null;
            if (hasNext()) {
                current = nodeStack.peek();
                nodeStack.pop();
                if (current.getRightChild() != null) {
                    nodeStack.push(current.getRightChild());
                }
                if (current.getLeftChild() != null) {
                    nodeStack.push(current.getLeftChild());
                }
            }
            return current;
        }
    }
}
