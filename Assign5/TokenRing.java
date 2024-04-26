import java.util.Scanner;

public class TokenRing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Total Nodes: ");
        int n = sc.nextInt();
        
        int token = 0;

        while(true)
        {
            try
            {
                System.out.print("Enter Sender: ");
                int s = sc.nextInt();
                System.out.print("Enter Receiver: ");
                int r = sc.nextInt();
                System.out.print("Enter Data: ");
                int d = sc.nextInt();

                for(int i=token; i!=s; i = (i + 1) % n)
                {
                    System.out.println(i + " -> " + ((i + 1) % n));
                }

                System.out.println("Sender Got Token...");
                System.out.println("Sender Sending data...");
                
                for(int i=s; i!=r; i=(i+1)%n)
                {
                    System.out.println(i + " forwarded data to " + ((i + 1) % n));
                }

                System.out.println("Data Received..");
                token = (token + 1) % n;
            }
            catch(Exception e)
            {
                System.err.println(e);
            }
        }
    }
}
