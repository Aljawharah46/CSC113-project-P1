public class VenueService extends Service {
    private int capacity;

    public VenueService(String serviceName, double basePrice, int capacity) { //constructor
        super(serviceName, basePrice);
        this.capacity = capacity;
    }

    public double calculateCost() { /*calculates and returns the total cost of the venue service based on 
its base price*/
        return basePrice + (capacity * 10);
    }
}

