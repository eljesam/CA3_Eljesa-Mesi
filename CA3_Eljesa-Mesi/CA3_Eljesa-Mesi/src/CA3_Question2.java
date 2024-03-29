import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Eljesa Mesi
 *  Class Group: SD2B
 */
public class CA3_Question2
{
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
