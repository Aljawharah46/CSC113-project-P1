public class Organizer extends Staff{

private int experienceYears;

public Organizer(String name , String phoneNum , double salary , int expYears){
super(name , phoneNum , salary);
experienceYears=expYears;
}

public void performDuty(){
System.out.println(name+" is responsible for organizing the party");
}

public void displayDetails(){
System.out.println("Name: "+name);
System.out.println("Phone number: "+phoneNumber);
System.out.println("Salary: "+salary);
System.out.println("Experience Years: "+experienceYears);

}


}