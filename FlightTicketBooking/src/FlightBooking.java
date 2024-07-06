import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FlightBooking {
    HashMap<Integer,int[]> flightData=new HashMap<>();
    private static int passengerId=1;
    List<Flights> flights=new ArrayList<>();
    public void flightsData() {
        int[] t1={50,5000};
        int[] t2={50,5000};
        flightData.put(1,t1);
        flightData.put(2,t2);
    }
    public double incAmount(int noOfSeats,int flightId){
        double amount=0;
        for(int i=0;i<noOfSeats;i++){
            amount+=flightData.get(flightId)[1];
            --flightData.get(flightId)[0];
            flightData.get(flightId)[1]+=200;
            System.out.println(flightData.get(1)[0]+" "+flightData.get(2)[0]);
        }
        return amount;
    }
    public void decAmount(int noOfSeats,int flId){
        flightData.get(flId)[0]+=noOfSeats;
        flightData.get(flId)[1]-=200*noOfSeats;
    }
    public void ticketBooking(int flightId,int noOfSeats,String passengerName){

        if(flightData.get(flightId)==null){
            System.out.println("Valid flight id");
        } else if (flightData.get(flightId)[0]>=noOfSeats) {
            double amount=incAmount(noOfSeats,flightId);
            flights.add(new Flights(flightId,passengerId++,noOfSeats,passengerName,amount));
            System.out.println(passengerName+" Ticket booked successfully \n" +
                    "for "+noOfSeats+"seats RS="+amount+"\n" +
                    "And your passenger ID:"+passengerId);
            System.out.println();
        }
    }
    public void cancelBooking(int flidId,int passengerId){
        Iterator<Flights> iterator = flights.iterator();
        while (iterator.hasNext()) {
            Flights flight = iterator.next();
            if (flight.getPassengerId() == passengerId && flight.getFlightId() == flidId) {
                decAmount(flight.getNumberOfSeats(), flidId);
                iterator.remove();
                System.out.println("Flight for passenger ID " + passengerId + " on flight ID " + flidId + " removed.\n");
                return;
            }
        }
        System.out.println("no match ups");
    }
    public void printBooking(){
        System.out.println("FlightId  PassengerId  Passenger Name  No.of seated booked  Total Amount");
        for(Flights i:flights){
            System.out.println("    "+i.getFlightId()+"          "+i.getPassengerId()+
                    "       "+i.getPassengerName()+"                   "+i.getNumberOfSeats()+
                    "               "+i.getAmountPaid());
        }
    }
    public void availableTickects(){
        System.out.println("Flight 1 has "+flightData.get(1)[0]+"seats Price Starting from "+flightData.get(1)[1]);
        System.out.println("Flight 2 has "+flightData.get(2)[0]+"seats Price Starting from "+flightData.get(2)[1]);
    }
}
