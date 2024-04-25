import HelloModule.*; 
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg. CORBA.*; 
import java.io.*;

public class Client {
    public static void main(String args[])
    {
        Hello hello = null;
        try
        {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            String name = "Hello";
            hello = HelloHelper.narrow(ncRef.resolve_str(name));
            
            String tempStr = hello.sayHello();
            System.out.println(tempStr);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}