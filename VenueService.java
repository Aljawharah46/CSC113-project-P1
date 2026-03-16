public class VenueService extends Service {
    private int capacity;

    public VenueService(String serviceName, double basePrice, int capacity) {
        super(serviceName, basePrice);
        this.capacity = capacity;
    }

    public double calculateCost() {
        return basePrice + (capacity * 10);
    }
}

