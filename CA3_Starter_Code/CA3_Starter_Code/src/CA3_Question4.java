import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 *  Name:Eljesa Mesi
 *  Class Group: SD2B
 */
public class CA3_Question4 {

    /*
        filename: name of the file to test.
     */
    public static boolean validate(String filename) throws FileNotFoundException
    {
        //create a scanner to read the file
        Scanner scanner = new Scanner(new File(filename));
        //set the delimiter to be anything other than a letter, number or underscore
        scanner.useDelimiter("[^a-zA-Z0-9_]+");
        //create a stack to store the identifiers
        Stack<String> stack = new Stack<>();
        //read the file
        while (scanner.hasNext())
        {
            //get the next identifier
            String identifier = scanner.next();
            //push it onto the stack
            stack.push(identifier);
        }
        //print the identifiers
        while (!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
        //return true if the stack is empty
        if (stack.isEmpty())
        {
            return true;
        }
        //return false if the stack is not empty
        if(!stack.isEmpty())
        {
            return false;
        }
        return false;
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for(String fName: files) {
            System.out.print(fName +": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }
}
