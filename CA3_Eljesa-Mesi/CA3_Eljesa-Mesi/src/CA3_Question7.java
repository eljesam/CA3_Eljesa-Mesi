import java.util.*;
/**
 *  Name: Eljesa Mesi
 *  Class Group: SD2B
 */
public class CA3_Question7
{
    /*
   Will repeatedly ask the user to enter the commands in the format
   buy company qty price
   or
   sell company qty price
   or
   quit
    */
    //Hint: Keep a Map<String, Queue<Block>> to store the shares of each company.
    public static void main(String[] args) {
        //create map for the blocks
        Map<String, Queue<Block>> blocks = new HashMap<>();

        Scanner in = new Scanner(System.in);
        String command="";
        do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                // Code to buy shares
                Block block = new Block(qty, (int) price);
                if(blocks.containsKey(company))
                {
                    blocks.get(company).add(block);
                }
                else
                {
                    Queue<Block> queue = new LinkedList<>();
                    queue.add(block);
                    blocks.put(company, queue);
                }
            }
            else if(command.equals("sell"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                // Code to sell shares and calculate profit
                if(blocks.containsKey(company))
                {
                    Queue<Block> queue = blocks.get(company);
                    while(qty > 0 && !queue.isEmpty()) {
                        Block block = queue.peek();
                        if (block.getQty() <= qty) {
                            qty -= block.getQty();
                            queue.poll();
                        } else {
                            block.setQty(block.getQty() - qty);
                            qty = 0;
                        }
                    }
                }
            }
        }while(!command.equalsIgnoreCase("quit"));

    }
}
