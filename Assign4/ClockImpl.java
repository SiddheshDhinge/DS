import java.rmi.*;
import java.rmi.server.*;
import java.time.DateTimeException;
import java.time.LocalTime;

public class ClockImpl extends UnicastRemoteObject implements ClockInterface {
    LocalTime currentTime;

    public ClockImpl(LocalTime time) throws RemoteException {
        this.currentTime = time;
    }

    public LocalTime getTime() throws RemoteException{
        return this.currentTime;
    }

    public void updateTime(int deltaSeconds) throws RemoteException{
        this.currentTime = LocalTime.ofSecondOfDay(this.currentTime.toSecondOfDay() + deltaSeconds);
    }
}