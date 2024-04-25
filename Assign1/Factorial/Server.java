import java.rmi.Naming;

public class Server {
    public static void main(String[] args)
    {
        try
        {
            FactorialImpl factorialImpl = new FactorialImpl();

            Naming.rebind("factorial", factorialImpl);
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
}