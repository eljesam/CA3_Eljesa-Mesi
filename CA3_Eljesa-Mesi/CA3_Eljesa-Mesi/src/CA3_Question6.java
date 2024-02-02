
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 *  Name: Eljesa Mesi
 *  Class Group: SD2B
 */
public class CA3_Question6
{
    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit */

    public static void main(String[] args) {
        //create queue for the blocks
        Queue<Block> blocks = new LinkedList<>();
        //create scanner
        Scanner in = new Scanner(System.in);
        //create command string
        String command;
        //create block object
        Block block;
        //create share object
        Share share;
        //create total gain variable
        double totalGain = 0;
        //create total cost variable
        double totalCost = 0;
        //create total shares variable
        int totalShares = 0;
        //create total shares sold variable
        int totalSharesSold = 0;
        //create total shares bought variable
        int totalSharesBought = 0;
            do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
                block = new Block(qty, (int) price);
                blocks.add(block);
                totalSharesBought += qty;
                totalShares += qty;
                totalCost += block.getCost();


            }
            else if(command.equals("sell"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
                double gain = 0;
                int sharesSold = 0;
                int sharesBought = 0;
                while(qty > 0)
                {
                    block = blocks.peek();
                    if(block.getQty() <= qty)
                    {
                        qty -= block.getQty();
                        gain += (price - block.getPrice()) * block.getQty();
                        sharesSold += block.getQty();
                        blocks.remove();
                    }
                    else
                    {
                        gain += (price - block.getPrice()) * qty;
                        sharesSold += qty;
                        block.setQty(block.getQty() - qty);
                        qty = 0;
                    }
                }


            }

        }while(!command.equalsIgnoreCase("quit"));
        System.out.println("Total shares: " + totalShares);
        System.out.println("Total shares bought: " + totalSharesBought);
        System.out.println("Total shares sold: " + totalSharesSold);
        System.out.println("Total cost: " + totalCost);
        System.out.println("Total gain: " + totalGain);


    }
}