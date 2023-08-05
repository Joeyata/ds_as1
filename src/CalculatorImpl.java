import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Stack;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator
{
  //Integer cnt;
  Stack<Integer> stack = new Stack<>();
  CalculatorImpl() throws RemoteException
  {
    //super();
    //cnt = 0;
    stack.clear();
  }

  public void pushValue(int val)
  {
    stack.push(val);
  }

  public int pop()
  {
    int top = stack.peek();
    stack.pop();
    return top;
  }
  public int delayPop(int millis)
  {
    try {
      Thread.sleep(millis);
      return pop();
    } catch (InterruptedException err){
      throw new RuntimeException(err);
    }
  }
  public int gcd(int a, int b)
  {
    return b == 0 ? a : gcd(b, a%b);
  }
  public boolean isEmpty()
  {
    return stack.isEmpty();
  }
  public void pushOperation(String operator)
  {
    int ans = 0;
    if(operator.equals("min")) ans = Integer.MAX_VALUE;
    if(operator.equals("max")) ans = Integer.MIN_VALUE;
    if(operator.equals("gcd")) ans = 0;
    if(operator.equals("lcm")) ans = 1;
    while(!isEmpty())
    {
      int now = pop();
      if(operator.equals("min")) ans = Math.min(ans, now);
      if(operator.equals("max")) ans = Math.max(ans, now);
      if(operator.equals("gcd")) ans = gcd(now,ans);
      if(operator.equals("lcm")) ans = (ans * now) / gcd(now, ans);
    }
    pushValue(ans);
  }

}
