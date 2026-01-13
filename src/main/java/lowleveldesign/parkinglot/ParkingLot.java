package lowleveldesign.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {

    private static final ParkingLot INSTANCE = new ParkingLot();
    private final List<ParkingFloor> floors = new ArrayList<>();

    private final Map<String, ParkingTicket> activeTickets = new ConcurrentHashMap<>();

    private FeeStrategy feeStrategy;


    public static synchronized ParkingLot getInstance() {
        return INSTANCE;
    }

    public void addFloor(ParkingFloor parkingFloor) {
        floors.add(parkingFloor);
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public synchronized Optional<ParkingTicket> parkVehicle(Vehicle vehicle) {
        for (ParkingFloor parkingFloor : floors) {

            var parkingSpotOpt = parkingFloor.findAvailableSpot(vehicle);

            if (parkingSpotOpt.isPresent()) {

                ParkingSpot spot = parkingSpotOpt.get();

                spot.parkVehicle(vehicle);

                ParkingTicket parkingTicket = new ParkingTicket(vehicle, spot);
                activeTickets.put(vehicle.getLicenseNumber(), parkingTicket);
                return Optional.of(parkingTicket);


            }
        }
        return Optional.empty();
    }

    public synchronized Optional<Double> unparkVehicle(String license) {
        ParkingTicket parkingTicket = activeTickets.get(license);
        if (parkingTicket == null) throw new RuntimeException("Parking Ticket not available");

        parkingTicket.getParkingSpot().unparkVehicle();

        parkingTicket.setExitTimestamp(1);
        Double parkingFee = feeStrategy.calculateFee(parkingTicket);

        return Optional.of(parkingFee);

    }


}
