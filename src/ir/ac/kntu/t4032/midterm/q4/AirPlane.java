package ir.ac.kntu.t4032.midterm.q4;
public class AirPlane {
    private int type, crewNumber;
    private double x, y, z, weight;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCrewNumber() {
        return crewNumber;
    }

    public void setCrewNumber(int crewNumber) {
        this.crewNumber = crewNumber;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public AirPlane(int type, int crewNumber, double x, double y, double z, double weight) {
        this.type = type;
        this.crewNumber = crewNumber;
        this.x = x;
        this.y = y;
        this.z = z;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "AirPlane [type=" + type + ", crewNumber=" + crewNumber + ", x=" + x + ", y=" + y + ", z=" + z
                + ", weight=" + weight + "]";
    }

    public double dist(AirPlane other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2) + Math.pow(this.z - other.z, 2));
    }

    public boolean safeDistance(AirPlane other){
        return true;
    }

    public double getTotalWeight (){
        return this.weight+this.crewNumber*80;
    }

}
