import java.rmi.Naming;

public class Client {
    public static void main(String[] args)
    {
        try
        {
            String str1 = args[0];
            String str2 = args[1];

            CompareInterface compareInterface = (CompareInterface) Naming.lookup("compare");

            boolean res = compareInterface.compare(str1, str2);
            System.out.println(res);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
