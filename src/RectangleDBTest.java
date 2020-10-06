import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import student.TestCase;

/**
 * @author {Your Name Here}
 * @version {Put Something Here}
 */
public class RectangleDBTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     * @param path
     *            file path
     * @return encoded String
     * @throws IOException
     */
    static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }

    /**
     * Get code coverage of the class declaration.
     * @throws Exception
     */
    public void testMain() throws Exception {
        String[] params = new String[1];
        
        params[0] = "src/SimpleInsertionTest.txt";

        RectangleDB.main(params);

        assertFuzzyEquals(systemOut().getHistory(), 
            readFile("src/SimpleInsertion_Output.txt"));
        RectangleDB newSession = new RectangleDB();
        assertNotNull(newSession);
    }
}
