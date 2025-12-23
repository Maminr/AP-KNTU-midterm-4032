package ir.ac.kntu.t4032.midterm.q23;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<CityStoreInfo> cities = new ArrayList<>();
        for (int i = 0; i < 5; i++) cities.add(CityStoreInfo.generateCityStoreInfo());

        cities.get(2).printStoresInRange(1300, 1404);

        CityStoreInfo.printGlobalOldestAndNewest(cities);
        CityStoreInfo.printGlobalTaxStats(cities);
    }
}