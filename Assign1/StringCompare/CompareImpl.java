import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CompareImpl extends UnicastRemoteObject implements CompareInterface{
    public CompareImpl() throws RemoteException
    {

    }
    public boolean compare(String a, String b) throws RemoteException
    {
        return a.compareTo(b) == 0;
    }
}