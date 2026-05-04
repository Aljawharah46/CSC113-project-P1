//All related classes to client must implement Serialiazable
import java.io.Serializable;

public class Party implements Serializable{

//Atributes
private String partyName;
private String date;
private String location;
private List services;
private List  guests;


//Constructors

	public Party(String partyName, String date, String location) {
		this.partyName = partyName;
		this.date = date;
		this.location = location;

		services=new List("Services list");
      guests=new List("Guests list");
	}

	// Methods
public void addService(Service s){
services.insertAtBack(s);
System.out.println("Service is added successfully");
}


public void removeService(String name){
Node current=services.getHead();

if(current!=null){
Service s=(Service)current.getData();
if(s.getServiceName().equalsIgnoreCase(name)){//if the wanted service is the first one in list
services.removeFromFront();
System.out.println("Service removed successfully");
}
}//end if

Node previous=current;
current=current.getNext();

while(current!=null){
Service s=(Service)current.getData();

if(s.getServiceName().equalsIgnoreCase(name)){
previous.setNext(current.getNext());
System.out.println("Service removed successfully");
}
previous=current;
current=current.getNext();

}//end while

System.out.println("couldn't find a service with the given name");

}//end removeService


public void addGuest(Guest g){
guests.insertAtBack(g);
System.out.println("Guest is added successfully");
}	
	
public void removeGuest(String name){
Node current=guests.getHead();

if(current!=null){
Guest g=(Guest)current.getData();
if(g.getName().equalsIgnoreCase(name)){//if the wanted guest is the first one in list
guests.removeFromFront();
System.out.println("Guest is removed successfully");
}

}
Node previous=current;
current=current.getNext();

while(current!=null){
Guest g=(Guest)current.getData();
if(g.getName().equalsIgnoreCase(name)){
previous.setNext(current.getNext());
System.out.println("Guest is removed successfully");

}//end if
previous=current;
current=current.getNext();


}//end while

System.out.println("couldn't find a guest with the given name");


}//end removeGuest

			
   public double calculateTotalCost(){
   double total=0;
   Node current=services.getHead();
   
   while(current!=null){
   Service s=(Service)current.getData();
   total=total+s.calculateCost();
   current=current.getNext();
   
   }//end while
   
   return total;
   
   }//end calcTotalCost

	   
   public int countGuestsRecursive(Node node){//count guests statring from the given node
   if(node==null)
   return 0;
   
   return 1 + countGuestsRecursive(node.getNext());
   
   }//end countGuestRecursive
   
   public int countGuests(){
return countGuestsRecursive(guests.getHead());
}
	
	
   
   public void displayPartyDetails() { //displays the party's information

	    System.out.println("Party Name: " + partyName);
	    System.out.println("Date: " + date);
	    System.out.println("Location: " + location);

	    System.out.println("\nServices:");
       Node currentService=services.getHead();
       while(currentService!=null){
       Service s=(Service)currentService.getData() ;
       s.displayService();
       currentService=currentService.getNext(); 
       }//end while
       
       System.out.println("\nGuests:");
       Node currentGuest=guests.getHead();
       while(currentGuest!=null){
       Guest g=(Guest)currentGuest.getData() ;
       g.displayDetails();
       currentGuest=currentGuest.getNext(); 
       }//end while
        
       
       }
   
	 /*public String getPartyDetails() {
    String details = "";

    details += "Party Name: " + partyName + "\n";
    details += "Date: " + date + "\n";
    details += "Location: " + location + "\n";

    details += "\nServices:\n";
    Node currentService=services.getHead();
       while(currentService!=null){
       Service s=(Service)currentService.getData() ;
       s.getServiceDetails();
       currentService=currentService.getNext(); 
       }//end while
    

    details += "\nGuests:\n";
    Node currentGuest=guests.getHead();
       while(currentGuest!=null){
       Guest g=(Guest)currentGuest.getData() ;
       g.getGuestDetails();
       currentGuest=currentGuest.getNext(); 
       }//end while
    
    return details;
}

*/



}