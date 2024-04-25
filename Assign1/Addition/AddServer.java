import java.rmi.*;

public class AddServer{
    public static void main(String[] args)
    {
        try
        {
            AddImp addObj = new AddImp();
            
            Naming.rebind("AddServer", addObj);
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
}
