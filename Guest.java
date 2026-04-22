public class Guest extends Person{

private String invitationID;

public Guest(String n , String phoneNum , String invitationID){ //constructor
super(n , phoneNum);
this.invitationID=invitationID;
}

public void displayDetails(){ //displays the guest's information
super.displayDetails();
System.out.println("Invitation ID: "+invitationID);
}

}//end of class