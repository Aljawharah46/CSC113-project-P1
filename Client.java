public class Client extends Person{

private Party party=null;

public Client(String n , String phoneNum){
super(n , phoneNum);
}

public void createParty(String name , String date , String location, int serviceNum, int guestNum){
party = new Party(name, date, location, serviceNum, guestNum);

}


public Party getParty(){
return party;
}


public void displayDetails(){
super.displayDetails();
}

}