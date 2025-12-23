package ir.ac.kntu.t4032.midterm.q4;

public class CargoPlane extends AirPlane {
    private double cargoWeight;

    public CargoPlane(int type, int crewNumber, double x, double y, double z, double weight, double cargoWeight) {
        super(type, crewNumber, x, y, z, weight);
        this.cargoWeight = cargoWeight;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    @Override
    public double getTotalWeight() {
        return super.getTotalWeight() + cargoWeight;
    }

    @Override
    public boolean safeDistance(AirPlane other) {
        return this.dist(other) > 4000;
    }

    @Override
    public String toString() {
        return "CargoPlane " + super.toString() + " Cargo: " + cargoWeight;
    }
}