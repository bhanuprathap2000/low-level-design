package lowleveldesign.parkinglot;

public class Truck extends Vehicle {
    public Truck(String licenseNumber) {
        super(licenseNumber, VehicleSize.LARGE);
    }
}
