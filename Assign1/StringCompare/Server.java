import java.rmi.*;

public class Server {
    public static void main(String[] args)
    {
        try
        {
            CompareImpl compareObj = new CompareImpl();

            Naming.rebind("compare", compareObj);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
