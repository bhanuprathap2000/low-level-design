package lowleveldesign.parkinglot;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingTicket {

    private final String ticketId;

    private final Vehicle vehicle;

    private final ParkingSpot parkingSpot;

    private final LocalDateTime entryTimestamp;

    private LocalDateTime exitTimestamp;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTimestamp = LocalDateTime.now();
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getEntryTimestamp() {
        return entryTimestamp;
    }

    public LocalDateTime getExitTimestamp() {
        return exitTimestamp;
    }

    public void setExitTimestamp(int hour) {
        this.exitTimestamp = LocalDateTime.now().plusHours(hour);
    }
}
