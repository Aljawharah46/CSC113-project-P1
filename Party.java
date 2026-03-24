package Party;

//Atributes
private String partyName;
private String date;
private String location;
private Service[]services;
private Guest[]guests;
private int serviceCount;
private int guestCount;

//Constructors
public class Party {

	public Party(String partyName, String date, String location, int serviceCount, int guestCount, int serviceNum,
			int guestNum) {
		this.partyName = partyName;
		this.date = date;
		this.location = location;

		services = new Service[serviceNum];
		guests = new Guest[guestNum];

		this.serviceCount = 0;
		this.guestCount = 0;
	}

	// Methods

	public boolean addService(Service s) {
		if (serviceCount==services.length) 
			return false;

		else {
			services[serviceCount++] = s;
			return true;
		}

		}

	public boolean removeService(String name) {
		int index = searchServiceIndex(name);
		if (index != -1) {
			services[index] = services[serviceCount-1];
			services[serviceCount--] = null;
			return true;
		} else
			return false;

	}

	public int searchServiceIndex(String name) {
		for (int i = 0; i < serviceCount; i++) {
			if (services[i].getServiceName().equalsIgnoreCase(name)) {

				return i;
			}
				

		}
		return -1;
	}
	
	public boolean addGuest(Guest g) {
		if (guestCount==guests.length) 
			return false;

		else {
			guests[guestCount++] = g;
			return true;
		}
		
		
	}
	
	public boolean removeGuest(String name) {	
		public boolean removeGuest(String name) {    
		    for (int i = 0; i < guestCount; i++) {
		        if (guests[i].getName().equalsIgnoreCase(name)) {
		            guests[i] = guests[guestCount - 1];
		            guests[guestCount - 1] = null;
		            guestCount--;
		            return true;
		        }
		    }
		    return false;
		}
		
	}
	
	
	public double calculateTotalCost() {
	    double total = 0;

	    for (int i = 0; i < serviceCount; i++) {
	        total += services[i].calculateCost(); // polymorphism
	    }

	    return total;
	}
	
	public int countGuestsRecursive(int index) {
	    if (index >= guestCount) {
	        return 0;
	    }

	    return 1 + countGuestsRecursive(index + 1);
	}
	
	public void displayPartyDetails() {

	    System.out.println("Party Name: " + partyName);
	    System.out.println("Date: " + date);
	    System.out.println("Location: " + location);

	    System.out.println("\nServices:");
	    for (int i = 0; i < serviceCount; i++) {
	        services[i].displayService();
	    }

	    System.out.println("\nGuests:");
	    for (int i = 0; i < guestCount; i++) {
	        guests[i].displayDetails();
	    }
	}

}
