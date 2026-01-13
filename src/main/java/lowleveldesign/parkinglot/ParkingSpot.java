package lowleveldesign.parkinglot;

public class ParkingSpot {

    private final String spotId;

    private final VehicleSize spotSize;

    private boolean isOccupied;

    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, VehicleSize spotSize) {
        this.spotId = spotId;
        this.spotSize = spotSize;
        isOccupied = false;
        parkedVehicle = null;
    }

    public String getSpotId() {
        return spotId;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public VehicleSize getSpotSize() {
        return spotSize;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        isOccupied = true;
    }

    public synchronized void unparkVehicle() {
        this.parkedVehicle = null;
        isOccupied = false;
    }

    public boolean canFitVehicle(Vehicle vehicle) {

        if (isOccupied) return false;

        return switch (vehicle.getVehicleSize()) {

            case SMALL -> spotSize == VehicleSize.SMALL;
            case MEDIUM -> (spotSize == VehicleSize.MEDIUM || spotSize == VehicleSize.LARGE);
            case LARGE -> spotSize == VehicleSize.LARGE;
            default -> false;
        };

    }
}
