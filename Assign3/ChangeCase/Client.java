import ChangeCaseModule.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class Client {
    public static void main(String[] args) {
        try
        {
            ORB orb = ORB.init(args, null);
    
            NamingContextExt ncRef = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
            
            ChangeCase ccRef = ChangeCaseHelper.narrow(ncRef.resolve_str("ChangeCase"));
    
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String res = ccRef.update(in.readLine());
            System.out.println(res);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }    
}