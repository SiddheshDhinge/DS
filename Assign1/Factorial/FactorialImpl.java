import java.rmi.*;
import java.rmi.server.*;
import java.util.Vector;

public class FactorialImpl extends UnicastRemoteObject implements FactorialInterface{
    public FactorialImpl() throws RemoteException
    {

    }

    public int f(int num, Vector<Integer> dp)
    {
        if(num <= 1)
            return 1;
        
        if(dp.get(num) != -1)
            return dp.get(num);

        int l = f(num - 1, dp);
        int r = f(num - 2, dp);

        dp.set(num, l + r);
        return l + r;
    }

    @Override
    public int factorial(int num) throws RemoteException {
        Vector<Integer> dp = new Vector<Integer>(num + 1);
        
        for (int i = 0; i <= num; i++)
        {
            dp.add(-1);
        }

        return f(num, dp);
    }
}
