public class CateringService extends Service {
    private int numberOfGuests;

    public CateringService(String serviceName, double basePrice, int numberOfGuests) {
        super(serviceName, basePrice);
        this.numberOfGuests = numberOfGuests;
    }

    public double calculateCost() {
        return basePrice + (numberOfGuests * 25);
    }
}
