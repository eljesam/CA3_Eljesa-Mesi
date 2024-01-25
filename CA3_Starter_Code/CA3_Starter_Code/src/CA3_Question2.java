import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Eljesa Mesi
 *  Class Group: SD2B
 */
public class CA3_Question2
{

    //in a paint program , a flood fill fills all empty pixels of a drawing with a given colour,
    //stopping whe it reaches occupied pixels.
    //implement a simple algorithm, flood filling a 10x10 array of integers that are initially 0.
    //push the row and column pair onto a stack. you will need to provide a simple Pair class to store the rows and columns.
    //repeat the following operations until the stack is empty:
    //pop off the pair from the top of the stack,
    //if it has not yet been filled, fill the corresponding cell location with a number 1,2,3 and so on.
    //push the coordinates of any unfilled neghbours in the north,eas,south or west direction onto the stack.
    //When done , print the entire array.
    /*
        Starter function to create the 2D array and populate it with 0

     */

    public static int[][]  floodFillStart() {

        Scanner kb = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
       return arr;
    }
    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int r, int c, int[][] arr)
    {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(r, c));
        while (!stack.isEmpty())
        {
            Pair p = stack.pop();
            if (arr[p.r][p.c] == 0)
            {
                arr[p.r][p.c] = 1;
                if (p.r > 0)
                {
                    stack.push(new Pair(p.r - 1, p.c));
                }
                if (p.r < 9)
                {
                    stack.push(new Pair(p.r + 1, p.c));
                }
                if (p.c > 0)
                {
                    stack.push(new Pair(p.r, p.c - 1));
                }
                if (p.c < 9)
                {
                    stack.push(new Pair(p.r, p.c + 1));
                }
            }
        }

    }

    public static void start()
    {
       int[][] arr = floodFillStart();
    }
    public static void main(String[] args) {
        start();
    }

}
