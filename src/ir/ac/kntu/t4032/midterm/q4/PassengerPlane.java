package ir.ac.kntu.t4032.midterm.q4;

import java.util.HashMap;
import java.util.Map;

public class PassengerPlane extends AirPlane {
    private Map<String, Double> passengers;

    public PassengerPlane(int type, int crewNumber, double x, double y, double z, double weight) {
        super(type, crewNumber, x, y, z, weight);
        this.passengers = new HashMap<>();
    }

    public void addPassenger(String name, double weight) {
        passengers.put(name, weight);
    }

    public void editPassenger(String name, double newWeight) {
        passengers.put(name, newWeight);
    }

    public void removePassenger(String name) {
        passengers.remove(name);
    }

    @Override
    public double getTotalWeight() {
        double totalPassengerWeight = 0;
        for (double w : passengers.values()) {
            totalPassengerWeight += w;
        }
        return super.getTotalWeight() + totalPassengerWeight;
    }

    @Override
    public boolean safeDistance(AirPlane other) {
        double limit = (other instanceof PassengerPlane) ? 5000 : 6000;
        return this.dist(other) > limit;
    }
}