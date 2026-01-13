package lowleveldesign.parkinglot;

public interface FeeStrategy {

    double calculateFee(ParkingTicket parkingTicket);
}
