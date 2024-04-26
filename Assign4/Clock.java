import java.rmi.Naming;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clock {
    public static void main(String[] args) {
        try
        {
            LocalTime time = LocalTime.parse(args[1], DateTimeFormatter.ofPattern("HH:mm:ss"));
            ClockImpl clock = new ClockImpl(time);
            Naming.rebind(args[0], clock);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
