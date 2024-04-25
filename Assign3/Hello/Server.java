import HelloModule.*; 
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;
import org.omg.CosNaming.NamingContextPackage.*;


public class Server {
    public static void main(String[] args) {
        try
        {
            ORB orb = ORB.init(args, null);

            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();
            
            HelloImpl echo = new HelloImpl();
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(echo);
            Hello h_ref = HelloHelper.narrow(ref);
            
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            NameComponent path[] = ncRef.to_name("Hello");
            ncRef.rebind(path, h_ref);

            System.out.println("Hello Server reading and waiting....");
            orb.run();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}