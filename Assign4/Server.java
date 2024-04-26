import java.rmi.Naming;
import java.time.Clock;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Server {
    public static void main(String[] args) {
        try
        {
            ClockInterface clock1 = (ClockInterface) Naming.lookup("rmi://127.0.0.1/" + args[0]);
            ClockInterface clock2 = (ClockInterface) Naming.lookup("rmi://127.0.0.1/" + args[1]);
            ClockInterface clock3 = (ClockInterface) Naming.lookup("rmi://127.0.0.1/" + args[2]);
            LocalTime mainTime = LocalTime.parse(args[3], DateTimeFormatter.ofPattern("HH:mm:ss"));

            int timeBefore1 = mainTime.toSecondOfDay();
            LocalTime time1 = clock1.getTime();
            int iTime1 = time1.toSecondOfDay();
            int timeBefore2 = mainTime.toSecondOfDay();
            LocalTime time2 = clock2.getTime();
            int iTime2 = time2.toSecondOfDay();
            int timeBefore3 = mainTime.toSecondOfDay();
            LocalTime time3 = clock3.getTime();
            int iTime3 = time3.toSecondOfDay();
            int lastTime = mainTime.toSecondOfDay();

            System.out.println("Before Clock1: " + time1.toString());
            System.out.println("Before Clock2: " + time2.toString());
            System.out.println("Before Clock3: " + time3.toString());
            System.out.println("Before Main Clock: " + mainTime.toString());

            int average = (iTime1 + iTime2 + iTime3 + mainTime.toSecondOfDay()) / 4;
            System.out.println("Setting Time to: " + LocalTime.ofSecondOfDay(average).toString());
            
            int delta1 = (timeBefore2 - timeBefore1) / 2;
            int delta2 = (timeBefore3 - timeBefore2) / 2;
            int delta3 = (lastTime - timeBefore3) / 2;

            int cdelta1 = average - iTime1 + delta1;
            int cdelta2 = average - iTime2 + delta2;
            int cdelta3 = average - iTime3 + delta3;

            System.out.println("Delta for clock1: " + LocalTime.ofSecondOfDay(Math.abs(cdelta1)).toString());
            System.out.println("Delta for clock2: " + LocalTime.ofSecondOfDay(Math.abs(cdelta2)).toString());
            System.out.println("Delta for clock3: " + LocalTime.ofSecondOfDay(Math.abs(cdelta3)).toString());

            clock1.updateTime(cdelta1);
            clock2.updateTime(cdelta2);
            clock3.updateTime(cdelta3);
            mainTime = LocalTime.ofSecondOfDay(average);
            
            System.out.println("After Clock1: " + clock1.getTime().toString());
            System.out.println("After Clock2: " + clock2.getTime().toString());
            System.out.println("After Clock3: " + clock3.getTime().toString());
            System.out.println("After Main Clock: " + mainTime.toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}