import java.rmi.*;

public interface AddInterface extends Remote
{
    public int add(int a, int b) throws RemoteException;
}