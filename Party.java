public class Party {

//Atributes
private String partyName;
private String date;
private String location;
private Service[]services;
private Guest[]guests;
private int serviceCount;
private int guestCount;

//Constructors

	public Party(String partyName, String date, String location, int serviceNum,
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

	public void addService(Service s) {/*adds services to the party’s services array if there is space available, 
and prints a message of success if added or message of fail otherwise*/
		if (serviceCount==services.length) 
			System.out.println("Service can't be added! You exceded the number of services you chose.");

		else {
			services[serviceCount++] = s;
			System.out.println("Service added successfully!");
		}

		}

	public void removeService(String name) { /*removes the service with the given name from the services array and 
prints a message of success if added or message of fail otherwise*/
		int index = searchServiceIndex(name);
		if (index != -1) {
			services[index] = services[serviceCount-1];
			services[serviceCount-1] = null;
         serviceCount--;
			System.out.println("Service removed successfully!");
		} 
		else
			System.out.println("Can't find a service with the name given!");
    
	}

	public int searchServiceIndex(String name) { /*searches for a service with the given name and returns the index of it 
if found or -1 otherwise*/
		for (int i = 0; i < serviceCount; i++) {
			if (services[i].getServiceName().equalsIgnoreCase(name)) {

				return i;
			}
		}
		return -1;
	}
	
	public void addGuest(Guest g) { /*adds guest G to the party’s guest array if there is space available, and 
prints a message of success if added or message of fail otherwise*/
		if (guestCount==guests.length) 
			System.out.println("Guest can't be added! You exceded the number of guests you chose.");

		else {
			guests[guestCount++] = g;
			System.out.println("Guest added successfully!");
		}
		
		
	}

		
		public void removeGuest(String name) { /*removes the guest with the given name from the guests array and 
prints a message of success if added or message of fail otherwise*/  
			int index = searchGuestIndex (name);
		    if (index!= -1) {
		            guests[index] = guests[guestCount - 1];
		            guests[guestCount - 1] = null;
		            guestCount--;
		            System.out.println("Guest removed successfully!");
		        }
		    else 
		    System.out.println("Can't find a guest with the name given!");
		}
		
	


		public int searchGuestIndex(String name) { /*searches for a guest with the given name and returns the index of it if 
found or -1 otherwise*/
		for (int i = 0; i < guestCount; i++) {
			if (guests[i].getName().equalsIgnoreCase(name)) {

				return i;
			}
		}
		return -1;
	}
	
	public double calculateTotalCost() { /*calculates and returns the total cost of all services in the party using 
polymorphism*/
	    double total = 0;

	    for (int i = 0; i < serviceCount; i++) {
	        total += services[i].calculateCost(); // polymorphism
	    }

	    return total;
	}


	
	public int countGuestsRecursive(int index) { /*recursively counts and returns the total number of guests starting 
from the given index*/
	    if (index >= guests.length) {
	        return 0;
	    }

	    return 1 + countGuestsRecursive(index + 1);
	}
	
	public void displayPartyDetails() { //displays the party's information

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