
public class CateringService extends Service {
    private int numberOfGuests;

    public CateringService(String serviceName, double basePrice, int numberOfGuests) { //constructor
        super(serviceName, basePrice);
        this.numberOfGuests = numberOfGuests;
    }

    public double calculateCost() { //calculates and returns the total cost of the catering service based on the number of guests
        return basePrice + (numberOfGuests * 25);
    }
    
}
