package ir.ac.kntu.t4032.midterm.q23;

import java.util.*;

public class CityStoreInfo {
    private String city;
    private Map<StoreType, List<Store>> storesByType;
    private Map<Integer, List<Store>> storesByYear;

    public CityStoreInfo(String name) {
        this.city = name;
        this.storesByType = new HashMap<>();
        this.storesByYear = new HashMap<>();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void addStore(Store store){
        if (!storesByYear.containsKey(store.getFoundationYear())) {
            storesByYear.put(store.getFoundationYear(), new ArrayList<>());
        }
        storesByYear.get(store.getFoundationYear()).add(store);

        if (!storesByType.containsKey(store.getType())) {
            storesByType.put(store.getType(), new ArrayList<>());
        }
        storesByType.get(store.getType()).add(store);
    }

    public void removeStore(Store store){
        if (!storesByYear.containsKey(store.getFoundationYear())) {
            storesByYear.put(store.getFoundationYear(), new ArrayList<>());
        }
        storesByYear.get(store.getFoundationYear()).remove(store);

        // 2. Handle Type Map
        if (!storesByType.containsKey(store.getType())) {
            storesByType.put(store.getType(), new ArrayList<>());
        }
        storesByType.get(store.getType()).remove(store);
    }

    @Override
    public String toString() {
        return "CityStoreInfo{" +
                "name='" + city + '\'' +
                ", storesByType=" + storesByType +
                ", storesByYear=" + storesByYear +
                '}';
    }

    public void printStoresInRange(int startYear, int endYear){
        for (int year = startYear; year <= endYear; year++ ){
            if (storesByYear.containsKey(year)){
                for(Store s : storesByYear.get(year)){
                    System.out.println(s);
                }
            }
        }
    }

    public List<Store> getStoresByType(StoreType type) {
        return storesByType.getOrDefault(type, new ArrayList<>());
    }

    public double calculateTaxForType(StoreType type) {
        double total = 0;
        List<Store> stores = getStoresByType(type);
        for (Store s : stores) {
            total += s.calculateTotalTax();
        }
        return total;
    }

    public static void printGlobalOldestAndNewest(List<CityStoreInfo> cities) {

        for (StoreType type : StoreType.values()) {
            List<Store> allStoresOfType = new ArrayList<>();
            for (CityStoreInfo city : cities) {
                allStoresOfType.addAll(city.getStoresByType(type));
            }

            if (allStoresOfType.isEmpty()) continue;

            int minYear = 1405, maxYear = 1299;
            for (Store s : allStoresOfType) {
                if (s.getFoundationYear() < minYear) minYear = s.getFoundationYear();
                if (s.getFoundationYear() > maxYear) maxYear = s.getFoundationYear();
            }

            System.out.println("Type: " + type);
            System.out.print("   Oldest (" + minYear + "): ");
            for (Store s : allStoresOfType) {
                if (s.getFoundationYear() == minYear) System.out.print(s.getName() + " ");
            }
            System.out.print("\n   Newest (" + maxYear + "): ");
            for (Store s : allStoresOfType) {
                if (s.getFoundationYear() == maxYear) System.out.print(s.getName() + " ");
            }
            System.out.println();
        }
    }

    public static void printGlobalTaxStats(List<CityStoreInfo> cities) {
        StoreType maxType = null, minType = null;
        double maxVal = -1, minVal = Double.MAX_VALUE;

        for (StoreType type : StoreType.values()) {
            double globalTotal = 0;

            for (CityStoreInfo city : cities) {
                globalTotal += city.calculateTaxForType(type);
            }

            if (globalTotal > 0) {
                if (globalTotal > maxVal) { maxVal = globalTotal; maxType = type; }
                if (globalTotal < minVal) { minVal = globalTotal; minType = type; }
            }
        }

        if (maxType != null) System.out.printf("Highest Tax Payer: %s (Total: %.2f)\n", maxType, maxVal);
        if (minType != null) System.out.printf("Lowest Tax Payer:  %s (Total: %.2f)\n", minType, minVal);
    }

    public static CityStoreInfo generateCityStoreInfo(){
        Random rand = new Random();
        String[] cities = {"Tehran", "Shiraz", "Isfahan", "Sari", "Tabriz"};

        String ccity = cities[rand.nextInt(cities.length)];
        CityStoreInfo newCity = new CityStoreInfo(ccity);
        int num = rand.nextInt(7);
        for (int i = 0; i < num; i++) newCity.addStore(Store.generateRandomStore());

        return newCity;
    }
}

