import java.util.Scanner;

/**
 * Handle received commands and arguments for RectangleDB program.
 * 
 * @author Lihui Zhang/lihuiz
 * @author Haosu Wang/whaosu
 * 
 * @version 1.0
 */
public class CommandParser {
    
    public void dump(BST<Rectangle, String> bst) {
        System.out.println("BST dump:");
        bst.dump();
    }
    
    
    public void insert(BST<Rectangle, String> bst,String Name, String args) {
        try {
            int[] words = scanwords(args);
            // rectangle words to print when we are done
            String words_String = WordsToString(Name, words);

            if (insertErr(Name,words)) {
                System.out.println("Rectangle rejected: " + words_String);
                return;
            }

            Rectangle toInsert = new Rectangle(Name, words[0], words[1], words[2], words[3]);

            //check if duplicate
            if (bst.hasRecord(bst.root, toInsert)) {
                System.out.println("Rectangle rejected: " + words_String);
                return;
            }
            else {
                bst.insert(toInsert);
                System.out.println("Rectangle accepted: " + words_String);
            }
        }
        catch (Exception e) {
            // not a good specification for a rectangle found
            System.out.println("Rectangle rejected: " + Name + args);
        }
    }
    
    public void remove(BST<Rectangle,String> bst, String args) {
        try {
            args = args.replace("\n", "");
            args = args.trim();
            if(args.matches("[a-zA-Z][a-zA-Z0-9_]*")) {
                Rectangle target = new Rectangle(args);
                if (!bst.remove(target)) {
                    System.out.println("Rectangle rejected: " + args);
                }
            }
            
            else {
                int[] words = scanwords(args);
                String args_String = String.format("(%d, %d, %d, %d)", words[0], words[1], words[2], words[3]);
                if (removeErr(words)) {
                    System.out.println("Rectangle rejected: " + args_String);
                    return;
                }
                Node<Rectangle,String> item = bst.root;
                if(findCoordHelper(item,words) == null) {
                    System.out.println("Rectangle rejected: " + args_String);
                }
                else {
                    Rectangle target = findCoordHelper(item,words);
                    bst.remove(target);
                }
            }
        }
        catch (Exception e) {
            args = args.replace(" ", ", ");
            System.out.println("Rectangle rejected: " + "(" + args +")");
        }
    }
    
    public static boolean insertErr(String name,int[] words) {
        if (words.length != 4) {
            throw new IllegalArgumentException(
                "Uncorrect number of arguments in insert");
        }

        if (words[0]<0||words[1]<0||words[2]<=0||words[3]<=0||words[0]+words[2]>1024||words[1]+words[3]>1024) {
            return true;
        }
        
                
        return !name.matches("[a-zA-Z][a-zA-Z0-9_]*");
    }
    
    public static boolean removeErr(int[] words) {
        if (words.length == 4) {
            if (words[0]<0||words[1]<0||words[2]<=0||words[3]<=0||words[0]+words[2]>1024||words[1]+words[3]>1024) {
                return true;
            }

            if (Integer.valueOf(words[2]) <= 0 || Integer.valueOf(words[3]) <= 0) {
                return true;
            }
        }
        return false;
    }
    
    private static int[] scanwords(String args) {
        int[] words = new int[4];
        Scanner sc = new Scanner(args);
        for (int i = 0; i < 4; ++i) {
            words[i] = sc.nextInt();
        }

        sc.close();
        return words;
    }
    
    private static String WordsToString(String Name, int[] words) {
        
        return String.format("(%s, %d, %d, %d, %d)", Name, words[0], words[1], words[2], words[3]);
    }

    private Rectangle findCoordHelper(Node<Rectangle,String> bst, int[] words) {
        
        if (bst == null) {
            return null;
        }
        if (words == null) {
            return null;
        }
        
        if (bst.getData().getX() == words[0] && 
            bst.getData().getY() == words[1] && 
            bst.getData().getHeight() == words[2]&& 
            bst.getData().getWidth() == words[3]) {
            return bst.getData();
        }
        else if (findCoordHelper(bst.getLeftChild(), words) == null) {
            return findCoordHelper(bst.getRightChild(), words);
        }
        else {
            return findCoordHelper(bst.getLeftChild(), words);
        }
    }
}
