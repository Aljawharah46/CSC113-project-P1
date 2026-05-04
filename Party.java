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
public boolean addService(Service s){
if(s!=null){
services.insertAtBack(s);
return true;
}
return false;
}


public boolean removeService(String name){
Node current=services.getHead();

if(current!=null){
Service s=(Service)current.getData();

if(s.getServiceName().equalsIgnoreCase(name)){//if the wanted service is the first one in list
services.removeFromFront();
return true;
}
}//end if

Node previous=current;

if(current!=null)
current=current.getNext();

while(current!=null){
Service s=(Service)current.getData();

if(s.getServiceName().equalsIgnoreCase(name)){
previous.setNext(current.getNext());
return true;
}
previous=current;
current=current.getNext();

}//end while

return false;

}//end removeService


public boolean addGuest(Guest g){
if(g!=null){
guests.insertAtBack(g);
return true;
}
return false;
}	
	
public boolean removeGuest(String name){
Node current=guests.getHead();

if(current!=null){
Guest g=(Guest)current.getData();
if(g.getName().equalsIgnoreCase(name)){//if the wanted guest is the first one in list
guests.removeFromFront();
return true;
}

}
Node previous=current;
if(current!=null)
current=current.getNext();

while(current!=null){
Guest g=(Guest)current.getData();
if(g.getName().equalsIgnoreCase(name)){
previous.setNext(current.getNext());
return true;

}//end if
previous=current;
current=current.getNext();


}//end while

return false;


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