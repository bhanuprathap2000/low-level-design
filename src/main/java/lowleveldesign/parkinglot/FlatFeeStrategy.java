package lowleveldesign.parkinglot;

import java.time.temporal.ChronoUnit;

public class FlatFeeStrategy implements FeeStrategy {


    @Override
    public double calculateFee(ParkingTicket parkingTicket) {
        long duration = ChronoUnit.HOURS.between(
                parkingTicket.getEntryTimestamp(), parkingTicket.getExitTimestamp()
        );

        double RATE_PER_HOUR = 10.0;
        return duration * RATE_PER_HOUR;


    }
}
