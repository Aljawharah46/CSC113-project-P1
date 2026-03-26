
public class EntertainmentService extends Service {
    private int hours;

    public EntertainmentService(String serviceName, double basePrice, int hours) {
        super(serviceName, basePrice);
        this.hours = hours;
    }

    public double calculateCost() {
        return basePrice + (hours * 150);
    }
}
