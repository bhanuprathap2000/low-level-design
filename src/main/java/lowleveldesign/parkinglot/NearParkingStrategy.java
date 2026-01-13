package lowleveldesign.parkinglot;

import java.util.List;
import java.util.Optional;

public class NearParkingStrategy implements ParkingStrategy {
    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {

        for (ParkingFloor parkingFloor : floors) {

            var parkingSpot = parkingFloor.findAvailableSpot(vehicle);

            if (parkingSpot.isPresent()) return parkingSpot;
        }

        return Optional.empty();

    }
}
