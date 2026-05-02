import java.io.Serializable;
//The super class must be Serializable
public class Person implements Serializable{

protected String name;
protected String phoneNumber;

public Person(String name , String phoneNumber){ //constructor
this.name=name;
this.phoneNumber=phoneNumber;
}

public String getName(){ //returns the name of the person
return name;
}

public String getPhoneNumber(){ //returns the phone number of the person
return phoneNumber;
}

public void displayDetails(){ //displays the person's information
System.out.println("Name: "+name);
System.out.println("Phone Number: "+phoneNumber);
}
public String getDetails() {
  return "Name: " + name + "\n";
  }


}
