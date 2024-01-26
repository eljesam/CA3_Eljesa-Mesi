import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name: Eljesa Mesi
 *  Class Group: SD2B
 */

public class CA3_Question5
{


    public static void takeoff(String flightSymbol)
    {
        Queue<String> takeoff = new LinkedList<>();
        takeoff.add(flightSymbol);
        System.out.println("Flight " + flightSymbol + " is queued for takeoff");
    }
    public static void land(String flightSymbol)
    {
        Queue<String> land = new LinkedList<>();
        land.add(flightSymbol);
        System.out.println("Flight " + flightSymbol + " is queued for landing");
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter command: ");
        String command = scanner.nextLine();

        if (command.equals("takeoff"))
        {
            System.out.println("Enter flight symbol: ");
            String flightSymbol = scanner.nextLine();
            takeoff(flightSymbol);
        }
        else if (command.equals("land"))
        {
            System.out.println("Enter flight symbol: ");
            String flightSymbol = scanner.nextLine();
            land(flightSymbol);
        }
        else if (command.equals("next"))
        {
            String flightSymbol = scanner.nextLine();
            System.out.println("Flight " + flightSymbol + " is queued for takeoff");
        }
        else if (command.equals("quit"))
        {
            String flightSymbol = scanner.nextLine();
            System.out.println("Flight " + flightSymbol + " is queued for landing");
        }




    }
}
