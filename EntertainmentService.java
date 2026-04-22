
public class EntertainmentService extends Service {
    private int hours;

    public EntertainmentService(String serviceName, double basePrice, int hours) { //constructor
        super(serviceName, basePrice);
        this.hours = hours;
    }

    public double calculateCost() { /*calculates and returns the total cost of the entertainment service 
based on the number of hours*/
        return basePrice + (hours * 150);
    }
}
