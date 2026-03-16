public abstract class Service {
    protected String serviceName;
    protected double basePrice;

    public Service(String serviceName, double basePrice) {
        this.serviceName = serviceName;
        this.basePrice = basePrice;
    }

    public String getServiceName() {
        return serviceName;
    }

    public abstract double calculateCost();

    public void displayService() {
        System.out.println("Service Name: " + serviceName);
        System.out.println("Base Price: " + basePrice);
        System.out.println("Total Cost: " + calculateCost());
    }
}
