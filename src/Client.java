import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.File;
import java.util.Scanner;
import java.lang.String;

public class Client
{
  public static void main(String args[]) throws Exception
  {
    final Registry registry = LocateRegistry.getRegistry(10176);

    final Calculator calculator = (Calculator) registry.lookup("calculator");

    try (Scanner sc = new Scanner(new File("input.txt"))) {
      while (sc.hasNextLine()) {

        String line = sc.nextLine();
        if(line.length() < 3) continue; //space line or inadequate command
        if(line.substring(0,3).equals("pus")) //pushValue
        {
          int number = 0; //get the number after the command
          for(int i = 10;i < line.length();i++) {
            number = number * 10 + line.charAt(i) - '0';
          }
          calculator.pushValue(number);
          System.out.println(String.format("The calculator has been pushed value %d", number));
        }
        else if(line.substring(0,3).equals("pop"))
        {
          System.out.println(String.format("The top of stack is %d", calculator.pop()));
        }
        else if(line.substring(0,3).equals("isE")) //isEmpty
        {
          if(calculator.isEmpty()) System.out.println("stack is empty now");
          else System.out.println("stack is not empty");
        }
        else if(line.substring(0,3).equals("del")) //delayPop
        {
          int number = 0;
          for(int i = 9;i < line.length();i++) {
            number = number * 10 + line.charAt(i) - '0';
          }
          System.out.println(String.format("delay %dms The top of stack is %d", number, calculator.delayPop(number)));
        }
        else //min,max,gcd,lcm
        {
          calculator.pushOperation(line.substring(0,3));
          System.out.println(line.substring(0,3) + " operation");
        }
        }
      sc.close();
    }
  }

}
