import ReverseModule.*;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextHelper;

public class Client {
    public static void main(String[] args) {
        try
        {
            org.omg.CORBA.ORB orb = ORB.init(args, null);
    
            org.omg.CORBA.Object ncObj = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(ncObj);
    
            Reverse reverse = ReverseHelper.narrow(ncRef.resolve_str("Reverse"));
            String res = reverse.doReverse(args[4]);
            System.out.println(res);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}