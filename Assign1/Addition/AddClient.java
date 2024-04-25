import java.rmi.*;

public class AddClient {
    public static void main(String[] args)
    {
        try 
        {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
    
            AddInterface addInterface = (AddInterface) Naming.lookup("rmi://127.0.0.1/AddServer");

            int res = addInterface.add(num1, num2);
            System.out.println(res);
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
}
