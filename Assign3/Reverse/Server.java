import ReverseModule.*;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class Server {
    public static void main(String[] args)
    {
        try
        {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            ReverseImpl reverseImpl = new ReverseImpl();
            org.omg.CORBA.Object reverseObj = rootPOA.servant_to_reference(reverseImpl);
            Reverse revRef = ReverseHelper.narrow(reverseObj);

            org.omg.CORBA.Object ncObj = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(ncObj);

            NameComponent[] name = ncRef.to_name("Reverse");
            ncRef.rebind(name, revRef);

            orb.run();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
