public class Client extends Person implements Payable {

private Party party=null;

public Client(String n , String phoneNum){ //constructor
super(n , phoneNum);
}

public void createParty(String name , String date , String location, int serviceNum, int guestNum){ //creates a new party for the client
party = new Party(name, date, location, serviceNum, guestNum);

}


public Party getParty(){ //returns the party associated with the client
return party;
}


public void displayDetails(){ //displays the client's information
super.displayDetails();
}

public double calculateCost() { /*calculates the total cost of the party for the client by calling the 
calculateTotalCost() method from the Party class and returns the result*/
    return party.calculateTotalCost();
}

}