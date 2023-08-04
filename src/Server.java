import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server
{
  public static void main(String args[]) throws Exception
  {
    final Registry registry = LocateRegistry.createRegistry(1099);

    final Calculator calculator = new CalculatorImpl();


    registry.bind("calculator", calculator);
  }
}
