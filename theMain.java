import java.lang.Character;
import java.util.*;
class theMain {
public static void main (String[]args){
Scanner read = new Scanner (System.in);
int choice;
Party clientParty=null;
boolean partyCreated =false;

System.out.println("Hello! enter your information to create a party");
System.out.println("Enter your name: ");
String clientName=read.nextLine();

System.out.println("Enter your phone number");
String phoneNum="";
boolean validPhoneNum = true;
while (validPhoneNum) {
try { 
phoneNum=read.nextLine();
if (phoneNum.length() != 10) 
throw new InvalidPhoneNumberException ("Phone number must be 10 digits. ");
for (int i=0 ; i<phoneNum.length() ; i++ ){
if (!Character.isDigit(phoneNum.charAt(i))){
throw new InvalidPhoneNumberException ("Your phone number must be 10 and only didgits.");
}
}
validPhoneNum=false;
}
catch (InvalidPhoneNumberException e) {
System.out.println(e.getMessage());
}
}
Client client=new Client(clientName,phoneNum);


do {
System.out.println ("-------Menu------");
System.out.println ("1.Create party");
System.out.println ("2.Manage Guests");
System.out.println ("3.Manage services");
System.out.println ("4.Total cost");
System.out.println ("5.Print summary");
System.out.println ("6.Exit");
System.out.println ("----------------");
System.out.println ("Enter the choice you want.");
 
try {
choice= read.nextInt();
read.nextLine();//garbage
}
catch (InputMismatchException e){
read.nextLine();
choice=0;
}



//boolean partyCreated =false; //whenever the menu is repeated it will return to false
switch (choice){
case 1 -> {
System.out.println ("Enter party name: ");
String name = read.nextLine ();
System.out.println ("Enter the date (dd/mm/yy): ");
String date = read.nextLine ();
System.out.println ("Enter the party location: ");
String location = read.nextLine ();
System.out.println ("Enter number of guests: ");
int guestsNum = read.nextInt();
System.out.println ("Enter number of services: ");
int servicesNum = read.nextInt ();

client.createParty(name , date , location , servicesNum , guestsNum);
clientParty=client.getParty();

System.out.println ("Party is created successfully!");
partyCreated =true;
}


case 2 -> {
if (partyCreated){
System.out.println ("----Guests Managment------");
System.out.println ("1.Add gusets");
System.out.println ("2.Remove gusets");
System.out.println ("--------------------------");
int guestChoice= read.nextInt();
read.nextLine();//garbage

if (guestChoice ==1){
System.out.println ("Enter the guest name: ");
String guestName = read.nextLine();
System.out.println ("Enter the guest phone number: ");
String guestPhoneNum = read.nextLine();
System.out.println ("Enter the guest invitation ID: ");
String guestID = read.nextLine();
Guest newGuest = new Guest (guestName,guestPhoneNum,guestID);
clientParty.addGuest(newGuest); 
}

else if (guestChoice==2){
System.out.println ("Enter the guest name you want to remove");
String GuestToRemove = read.nextLine();
clientParty.removeGuest(GuestToRemove);
}

else
System.out.println ("Invalid choice!");


}
else 
System.out.println ("Create a party first!");

}


case 3-> {
if (partyCreated){
System.out.println ("----Services Managment------");
System.out.println ("1.Add service");
System.out.println ("2.Remove service");
System.out.println ("--------------------------");
int serviceChoice= read.nextInt();
read.nextLine();//garbage

if (serviceChoice==1){

System.out.println ("--- The type of services available-----");
System.out.println ("1.Entertainment");
System.out.println ("2.Venue");
System.out.println ("3.Catering");
System.out.println ("----------------------------------------");
int serviceType = read.nextInt();
read.nextLine();//garbage

switch( serviceType){
case 1 -> {
System.out.println ("Enter the service name: ");
String serviceName = read.nextLine();
System.out.println ("Enter the service base price: ");
double basePrice = read.nextDouble();
System.out.println ("Enter the number of hours: ");
int hours = read.nextInt();
read.nextLine();//garbage

EntertainmentService newEntService = new  EntertainmentService (serviceName, basePrice, hours);
clientParty.addService(newEntService);
} 
case 2 -> {
System.out.println ("Enter the service name: ");
String serviceName = read.nextLine();
System.out.println ("Enter the service base price: ");
double basePrice = read.nextDouble();
System.out.println ("Enter the capacity: ");
int capacity = read.nextInt();
read.nextLine();

VenueService newVenService = new  VenueService (serviceName, basePrice, capacity);
clientParty.addService(newVenService);//newVanService fixed

}
case 3 -> {
System.out.println ("Enter the service name: ");
String serviceName = read.nextLine();
System.out.println ("Enter the service base price: ");
double basePrice = read.nextDouble();

int cateringNumGuests = clientParty.countGuestsRecursive(0);
read.nextLine();//garbage

CateringService newCatService = new  CateringService (serviceName, basePrice, cateringNumGuests);
clientParty.addService(newCatService);}

default ->System.out.println ("Invalid choice!");
}

}

else if (serviceChoice==2){
System.out.println ("Enter the service name you want to remove: ");
String ServiceToRemove = read.nextLine();
clientParty.removeService(ServiceToRemove);

}

else
System.out.println ("Invalid choice!");

}

else 
System.out.println ("Error! Create a party first!");
}



case 4->{
if (partyCreated){
Payable p = client;  // treat client as Payable
double totalCost = p.calculateCost();

System.out.println("The total cost of the party is " + totalCost + ".");
}
else
System.out.println ("Error! Create a party first!");
}


case 5-> {
if (partyCreated)
 clientParty.displayPartyDetails();
else
System.out.println ("Error! Create a party first!");

}
case 6-> {System.out.println ("It was nice having you with us.");
}
default ->{System.out.println ("Invaild choice! please choose again. ");
}


}


}
while (choice !=6);
}


}
