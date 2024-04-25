import java.rmi.*;

public interface FactorialInterface extends Remote
{
    int factorial(int num) throws RemoteException;
}
