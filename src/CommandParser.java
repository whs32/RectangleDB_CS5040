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

            bst.insert(toInsert);
            System.out.println("Rectangle accepted:" + words_String);
        }
        catch (Exception e) {
            // not a good specification for a rectangle found
            System.out.println("Bad arguments! Use: insert <rect_name>" + " <x> <y> <width> <height>");
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

}
