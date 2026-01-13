package lowleveldesign.parkinglot;

import java.time.temporal.ChronoUnit;
import java.util.Map;

public class VehicleBasedFeeStrategy implements FeeStrategy {
    @Override
    public double calculateFee(ParkingTicket parkingTicket) {

        Map<VehicleSize, Double> HOURLY_RATES = Map.of(
                VehicleSize.SMALL, 10.0,
                VehicleSize.MEDIUM, 20.0,
                VehicleSize.LARGE, 30.0
        );

        long duration = ChronoUnit.HOURS.between(
                parkingTicket.getEntryTimestamp(), parkingTicket.getExitTimestamp()
        );

        Double hourlyRate = HOURLY_RATES.get(parkingTicket.getVehicle().getVehicleSize());

        if (hourlyRate == null) throw new RuntimeException("Fee cannot be calculated");

        return hourlyRate * duration;
    }
}
