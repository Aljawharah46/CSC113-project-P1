
import java.io.Serializable;

public class Client extends Person implements Payable,Serializable{
private String password;
private Party party=null;

public Client(String n , String phoneNum, String p){
super(n , phoneNum);
password=p;
}

public void createParty(String name , String date , String location, int serviceNum, int guestNum)  {
party = new Party(name, date, location, serviceNum, guestNum); 

}


public Party getParty(){
return party;
}


public void displayDetails(){
super.displayDetails();
}

public double calculateCost() {
    return party.calculateTotalCost();
}

public String getPassword() {
    return password;
}

}
