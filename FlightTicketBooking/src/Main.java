import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        FlightBooking fB=new FlightBooking();
        fB.flightsData();
        while (true){
            System.out.println("1.Ticket Booking\n2.Cancel Booking\n3.Print\n4.Show available tickets\n5.Exit");
            int input= sc.nextInt();
            switch (input){
                case 1:
                    System.out.println("Enter you Name:");
                    String name=sc.next();
                    System.out.println("Enter Flight ID:");
                    int flId= sc.nextInt();
                    System.out.println("Enter number of seats:");
                    int noS=sc.nextInt();
                    fB.ticketBooking(flId,noS,name);
                    break;
                case 2:
                    System.out.println("Enter flight id:");
                    int flid=sc.nextInt();
                    System.out.println("Enter Passenger id:");
                    int pid=sc.nextInt();
                    fB.cancelBooking(flid,pid);
                    break;
                case 3:
                    fB.printBooking();
                    break;
                case 4:
                    fB.availableTickects();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Give Valid input");
            }
        }
    }
}