import ChangeCaseModule.*;

import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class Server {
    public static void main(String[] args) {
        try
        {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
    
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();
            
            ChangeCaseImpl changeCase = new ChangeCaseImpl();
            ChangeCase ccRef = ChangeCaseHelper.narrow(rootPOA.servant_to_reference(changeCase));
    
            NamingContextExt ncRef = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
            
            NameComponent[] name = ncRef.to_name("ChangeCase");
            ncRef.rebind(name, ccRef);
    
            orb.run();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
