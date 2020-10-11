/**
 ����* Rectangle database
 */


// On my honor:
//
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The class containing the main method.
 * 
 * @author Haosu Wang/whaosu
 * @author Lihui Zhang/lihuiz
 * @version Oct 2020
 */
public class RectangleDB {
    /**
     * @param args
     *     Command line parameters
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {

        // scanner object to parse the command file
        Scanner sc;

        try {
            sc = new Scanner(new File(args[0]));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        BST<Rectangle, String> bst = new BST<Rectangle, String>();
        CommandParser handler = new CommandParser();

        while (sc.hasNext()) {
            String cmd = sc.next();

            if (cmd.equals("dump")) {
                handler.dump(bst);
            }
            else if (cmd.equals("intersections")) {
                handler.intersections(bst);
            }
            else if (cmd.equals("regionsearch")) {
                handler.regionsearch(bst, sc.nextLine());
            }
            else if (cmd.equals("remove")) {
                handler.remove(bst, sc.nextLine());
            }
            else if (cmd.equals("insert")) {
                handler.insert(bst, sc.next(), sc.nextLine());
            }
            else if (cmd.equals("search")) {
                handler.search(bst, sc.nextLine());
            }
            else {
                System.out.println("Unrecognized input: |" + cmd + "|");
            }
        }

        // done with the scanner object
        sc.close();
    }
}
