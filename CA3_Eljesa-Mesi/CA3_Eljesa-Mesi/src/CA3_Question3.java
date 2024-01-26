import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  Name:
 *  Class Group:
 */

public class CA3_Question3
{
    public static void readFile(String fileName)
    {
        try
        {
            Scanner scanner = new Scanner(new File(fileName));
            scanner.useDelimiter("[^a-zA-Z0-9_]+");
            while (scanner.hasNext())
            {
                String identifier = scanner.next();
                System.out.println(identifier);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
