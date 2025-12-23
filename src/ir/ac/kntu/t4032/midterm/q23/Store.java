package ir.ac.kntu.t4032.midterm.q23;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Store {
    private String name;
    private int foundationYear;
    private Phone phone;
    private StoreType type;
    private Address address;
    private String owner;

    private Map<Integer, Double> taxes;

    public Store(String name, int foundationYear, Phone phone, StoreType type, Address address, String owner) {
        this.name = name;
        this.setFoundationYear(foundationYear);
        this.phone = phone;
        this.type = type;
        this.address = address;
        this.owner = owner;
        this.taxes = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(int foundationYear) {
        if (foundationYear < 1300 || foundationYear > 1404){
            System.out.println("Not valid Year");
            return;
        }
        this.foundationYear = foundationYear;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public StoreType getType() {
        return type;
    }

    public void setType(StoreType type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addTax(int year, double amount){
        if (amount <= 0 || (year < this.foundationYear || year > 1404)){
            return;
        }
        taxes.put(year, amount);

    }

    public void editTax(int year, double newAmount){
        if (!taxes.containsKey(year) || newAmount <= 0){
            return;
        }
        taxes.put(year, newAmount);
    }

    public void removeTax(int year){
        if (!taxes.containsKey(year)){
            return;
        }
        taxes.remove(year);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                "owner='" + owner + '\'' +
                ", foundationYear=" + foundationYear +
                ", phone=" + phone +
                ", type=" + type +
                ", address=" + address +
                ", taxes=" + taxes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store store)) return false;
        return Objects.equals(getAddress(), store.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getAddress());
    }

    public double calculateTotalTax() {
        double total = 0;
        for (Double amount : taxes.values()) {
            total += amount;
        }
        return total;
    }

    public static Store generateRandomStore() {
        Random rand = new Random();
        String[] names = {"HyperStar", "Refah", "Ofogh", "Shahrvand", "Digikala"};
        String[] owners = {"Ali", "Reza", "Sara", "Mohammad", "Maryam"};

        String cname = names[rand.nextInt(names.length)] + rand.nextInt(100);
        String cowner = owners[rand.nextInt(owners.length)];
        int cyear = 1300 + rand.nextInt(105); // 1300 to 1404

        StoreType[] types = StoreType.values();
        StoreType ctype = types[rand.nextInt(types.length)];

        Address caddr = new Address("Main " + rand.nextInt(10), "St " + rand.nextInt(50), "Alley", String.valueOf(rand.nextInt(100)));
        Phone cphone = new Phone("021", String.valueOf(rand.nextInt(8999999) + 1000000));

        Store s = new Store(cname, cyear, cphone, ctype, caddr, cowner);

        s.addTax(cyear, 1000 + rand.nextInt(9000));
        return s;
    }
}
