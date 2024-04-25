import java.rmi.*;
import java.rmi.server.*;

public class AddImp extends UnicastRemoteObject implements AddInterface{
    public AddImp() throws RemoteException
    {

    }
    @Override
    public int add(int a, int b) throws RemoteException
    {
        return a + b;
    }
}