package lowleveldesign.parkinglot;

import java.util.*;

public class FartherParkingStrategy implements ParkingStrategy {
    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {

        List<ParkingFloor> reversedFloors = new ArrayList<>(floors);

        Collections.reverse(reversedFloors);

        for (ParkingFloor parkingFloor : reversedFloors) {

            var parkingSpot = parkingFloor.findAvailableSpot(vehicle);

            if (parkingSpot.isPresent()) return parkingSpot;
        }

        return Optional.empty();


    }
}
