import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 *  Name:
 *  Class Group:
 */
public class CA3_Question4 {
 //write a program that reads a Java source file and produces an index of all identifiers in the file.
    //For each identifier, print all lines with the line number in which it occurs.
    //For simplicity we will consider eash string consisting of only letters, numbers and underscores as identifiers
    //declare a scanner in reading from the source file and call in use delimiter.
    //then each call to next returns an identifier.
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
