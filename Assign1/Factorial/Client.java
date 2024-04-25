import java.rmi.*;

public class Client {
    public static void main(String[] args)
    {
        try
        {
            int num = Integer.parseInt(args[0]);

            FactorialInterface factorialInterface = (FactorialInterface) Naming.lookup("factorial");

            int res = factorialInterface.factorial(num);
            System.out.println(res);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
