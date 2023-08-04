import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client
{
  public static void main(String args[]) throws Exception
  {
    final Registry registry = LocateRegistry.getRegistry(10176);

    final Calculator calculator = (Calculator) registry.lookup("calculator");

    calculator.pushValue(3);
    calculator.pushValue(4);
    calculator.pushOperation("lcm");
    System.out.println(String.format("The top of stack is %d", calculator.pop()));

  }

}
