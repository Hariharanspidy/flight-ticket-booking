public class Flights {
    private int flightId;
    private int passengerId;
    private int numberOfSeats;
    private double amountPaid;
    private String passengerName;
    public Flights(int flightId,int passengerId,int numberOfSeats,String passengerName,double amountPaid){
        this.flightId=flightId;
        this.passengerId=passengerId;
        this.passengerName=passengerName;
        this.numberOfSeats=numberOfSeats;
        this.amountPaid=amountPaid;
    }
    public int getFlightId(){
        return flightId;
    }
    public int getPassengerId(){
        return passengerId;
    }
    public int getNumberOfSeats(){
        return numberOfSeats;
    }
    public String getPassengerName(){
        return passengerName;
    }
    public double getAmountPaid(){
        return amountPaid;
    }
}
