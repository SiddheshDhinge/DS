import java.rmi.*;

interface CompareInterface extends Remote
{
    public boolean compare(String a, String b) throws RemoteException;
}