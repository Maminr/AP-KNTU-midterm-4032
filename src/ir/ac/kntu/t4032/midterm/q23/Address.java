package ir.ac.kntu.t4032.midterm.q23;

import java.util.Objects;

public class Address {
    private String mainStreet;
    private String street;
    private String alley;
    private String number;

    public Address(String mainStreet, String street, String alley, String number) {
        this.mainStreet = mainStreet;
        this.street = street;
        this.alley = alley;
        this.number = number;
    }

    public String getMainStreet() {
        return mainStreet;
    }

    public void setMainStreet(String mainStreet) {
        this.mainStreet = mainStreet;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAlley() {
        return alley;
    }

    public void setAlley(String alley) {
        this.alley = alley;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return Objects.equals(getMainStreet(), address.getMainStreet()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getAlley(), address.getAlley()) && Objects.equals(getNumber(), address.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMainStreet(), getStreet(), getAlley(), getNumber());
    }
}
