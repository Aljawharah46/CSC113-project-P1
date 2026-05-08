import java.lang.Character;
import java.util.*;
import java.io.*;
class theMain {
public static void main (String[]args) throws ClassNotFoundException {

      LoginFrame f = new LoginFrame();
        f.setVisible(true);
// File SystemFile = new File("System.dat");
// Scanner read = new Scanner (System.in);


// int choice;
// Party clientParty=null;
// boolean partyCreated =false;

// System.out.println("Hello!");

// System.out.println("Enter your name: ");
// String clientName=read.nextLine();

// System.out.println("Enter your password:");
// String password = read.nextLine();


// Client client= fetchClient(clientName, password, SystemFile );
// // In the case of new user
// if (client == null){ 
// // Take the new user phone number
// System.out.println("Enter your phone number");
// //Validate the phone number first
// String phoneNum="";
// boolean validPhoneNum = true;
// while (validPhoneNum) {

// try { 
// phoneNum=read.nextLine();
// if (phoneNum.length() != 10) 
// throw new InvalidPhoneNumberException ("Phone number must be 10 digits. ");
// for (int i=0 ; i<phoneNum.length() ; i++ ){
// if (!Character.isDigit(phoneNum.charAt(i))){
// throw new InvalidPhoneNumberException ("Your phone number must be 10 and only didgits.");}
// }
// validPhoneNum=false;
// }

// catch (InvalidPhoneNumberException e) {
// System.out.println(e.getMessage());
// }
// }
// //Craete a new Client and save it to the file
// client= new Client(clientName,phoneNum,password);
// saveClient(client, SystemFile);
// System.out.println("\n=========================================");
// System.out.println("        Hello " + client.getName() );
// System.out.println("   Your account has been created!");
// System.out.println("   Let's start planning your party ");
// System.out.println("=========================================\n");
// }

// //In the case of user found in the file
// else{
// System.out.println("\n=========================================");
// System.out.println("         Welcome Back, " + client.getName() + "!");
// System.out.println("         We missed you <3");
// System.out.println("=========================================\n");
// }


// do {
// System.out.println ("============== MAIN MENU ==============");
// System.out.println ("1.Create party");
// System.out.println ("2.Manage Guests");
// System.out.println ("3.Manage services");
// System.out.println ("4.Total cost");
// System.out.println ("5.Print summary");
// System.out.println ("6.Exit");
// System.out.println ("======================================");
// System.out.println ("Enter the choice you want.");
 
// try {
// choice= read.nextInt();
// read.nextLine();//garbage
// }
// catch (InputMismatchException e){
// read.nextLine();
// choice=0;
// }



// //boolean partyCreated =false; //whenever the menu is repeated it will return to false
// switch (choice){
// case 1 -> {
// System.out.println ("Enter party name: ");
// String name = read.nextLine ();
// System.out.println ("Enter the date (dd/mm/yy): ");
// String date = read.nextLine ();
// System.out.println ("Enter the party location: ");
// String location = read.nextLine ();

// client.createParty(name , date , location);
// clientParty=client.getParty();

// System.out.println ("Party is created successfully!");
// partyCreated =true;
// }


// case 2 -> {
// if (partyCreated){
// System.out.println ("----Guests Managment------");
// System.out.println ("1.Add gusets");
// System.out.println ("2.Remove gusets");
// System.out.println ("--------------------------");
// int guestChoice= read.nextInt();
// read.nextLine();//garbage

// if (guestChoice ==1){
// System.out.println ("Enter the guest name: ");
// String guestName = read.nextLine();
// System.out.println ("Enter the guest phone number: ");
// String guestPhoneNum = read.nextLine();
// System.out.println ("Enter the guest invitation ID: ");
// String guestID = read.nextLine();
// Guest newGuest = new Guest (guestName,guestPhoneNum,guestID);
// if(clientParty.addGuest(newGuest))
//     System.out.println("Guest added successfully!");
// else
//     System.out.println("Guest can't be added! Maximum guest limit reached.");
// }

// else if (guestChoice==2){
// System.out.println ("Enter the guest name you want to remove");
// String GuestToRemove = read.nextLine();
// if(clientParty.removeGuest(GuestToRemove))
//     System.out.println("Guest removed successfully!");
// else
//     System.out.println("Can't find a guest with the name given!");
// }

// else
// System.out.println ("Invalid choice!");


// }
// else 
// System.out.println ("Create a party first!");

// }


// case 3-> {
// if (partyCreated){
// System.out.println ("----Services Managment------");
// System.out.println ("1.Add service");
// System.out.println ("2.Remove service");
// System.out.println ("--------------------------");
// int serviceChoice= read.nextInt();
// read.nextLine();//garbage

// if (serviceChoice==1){

// System.out.println ("--- The type of services available-----");
// System.out.println ("1.Entertainment");
// System.out.println ("2.Venue");
// System.out.println ("3.Catering");
// System.out.println ("----------------------------------------");
// int serviceType = read.nextInt();
// read.nextLine();//garbage

// switch( serviceType){
// case 1 -> {
// System.out.println ("Enter the service name: ");
// String serviceName = read.nextLine();
// System.out.println ("Enter the service base price: ");
// double basePrice = read.nextDouble();
// System.out.println ("Enter the number of hours: ");
// int hours = read.nextInt();
// read.nextLine();//garbage

// EntertainmentService newEntService = new  EntertainmentService (serviceName, basePrice, hours);
// if(clientParty.addService(newEntService))
//     System.out.println("Service added successfully!");
// else
//     System.out.println("Service can't be added! Maximum service limit reached.");
// } 
// case 2 -> {
// System.out.println ("Enter the service name: ");
// String serviceName = read.nextLine();
// System.out.println ("Enter the service base price: ");
// double basePrice = read.nextDouble();
// System.out.println ("Enter the capacity: ");
// int capacity = read.nextInt();
// read.nextLine();

// VenueService newVenService = new  VenueService (serviceName, basePrice, capacity);
// if(clientParty.addService(newVenService))
//     System.out.println("Service added successfully!");
// else
//     System.out.println("Service can't be added! Maximum service limit reached.");//newVanService fixed

// }
// case 3 -> {
// System.out.println ("Enter the service name: ");
// String serviceName = read.nextLine();
// System.out.println ("Enter the service base price: ");
// double basePrice = read.nextDouble();

// int cateringNumGuests = clientParty.countGuests();
// read.nextLine();//garbage

// CateringService newCatService = new  CateringService (serviceName, basePrice, cateringNumGuests);
// if(clientParty.addService(newCatService))
//     System.out.println("Service added successfully!");
// else
//     System.out.println("Service can't be added! Maximum service limit reached.");}

// default ->System.out.println ("Invalid choice!");
// }

// }

// else if (serviceChoice==2){
// System.out.println ("Enter the service name you want to remove: ");
// String ServiceToRemove = read.nextLine();
// if(clientParty.removeService(ServiceToRemove))
//     System.out.println("Service removed successfully!");
// else
//     System.out.println("Can't find a service with the name given!");

// }

// else
// System.out.println ("Invalid choice!");

// }

// else 
// System.out.println ("Error! Create a party first!");
// }



// case 4->{
// if (partyCreated){
// Payable p = client;  // treat client as Payable
// double totalCost = p.calculateCost();

// System.out.println("The total cost of the party is " + totalCost + ".");
// }
// else
// System.out.println ("Error! Create a party first!");
// }


// case 5-> {
// if (partyCreated)
//  clientParty.displayPartyDetails();
// else
// System.out.println ("Error! Create a party first!");

// }
// case 6-> {System.out.println ("It was nice having you with us.");
// }
// default ->{System.out.println ("Invaild choice! please choose again. ");
// }


// }


// }
// while (choice !=6);
}

public static void saveClient(Client newClient, File f) {//A method that saves new Client to System File

    try {
        // 1. Read all existing clients in the file if exist and store it temporarily
        Client[] temp = new Client[100];
        int count = 0;

        if (f.exists()) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));

            try {
                while (true) {
                    temp[count++] = (Client) in.readObject();
                }
            } catch (EOFException e) {
                // done reading
            }

            in.close();
        }

        // 2. Add new client to them
        temp[count++] = newClient;

        // 3. Rewrite the whole file again after adding by iterating
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));

        for (int i = 0; i < count; i++) {
            out.writeObject(temp[i]);
        }

        out.close();

    } catch (Exception e) {
        System.out.println("Error saving.");
    }
}

//fetchClient method search the file for a client object with the entered name and password, returns the object if there and null otherwise
public static Client fetchClient (String n, String p, File f) throws ClassNotFoundException{
 
    try { 
    ObjectInputStream in = new ObjectInputStream(new FileInputStream(f)) ;
    Client client;
    while (true){
client = (Client) in.readObject();

if (client!= null && client.getName().equalsIgnoreCase(n)&&client.getPassword().equals(p)&&client.getName() != null &&client.getPassword() != null){
in.close();
return client;
}
}
} 
catch (EOFException e) {
  //just to catch
}
catch (IOException e) {
  //just to catch

}
return null;


}

public static void saveUpdatedClient(Client updatedClient, File f) {
    saveClient(updatedClient, f);
}
}
