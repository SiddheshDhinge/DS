import java.rmi.*;
import java.time.LocalTime;

public interface ClockInterface extends Remote{
    public LocalTime getTime() throws RemoteException;
    public void updateTime(int deltaSeconds) throws RemoteException;
}