public abstract class Service implements Payable {
    protected String serviceName;
    protected double basePrice;

    public Service(String serviceName, double basePrice) { //constructor
        this.serviceName = serviceName;
        this.basePrice = basePrice;
    }

    public String getServiceName() { //returns the service's name
        return serviceName;
    }

    public abstract double calculateCost(); //calculates and returns the total cost of the service

    public void displayService() { //displays the service's details
        System.out.println("Service Name: " + serviceName);
        System.out.println("Base Price: " + basePrice);
        System.out.println("Total Cost: " + calculateCost());
    }
}
