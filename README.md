# CSC113-project-P1
```mermaid
classDiagram
class Person{
# name : String
# phoneNumber : String
+ getName() String
+ getPhone() String
+ displayDetails() void
}

class Client{
- party : Party
+ createParty(name : String , date : String , location : String) void
+ getParty() Party
+ displayDetails() void
}

class Guest{
- invitationID : String
+ displayDetails() void
}


class Party{
- partyName : String
- date : String
- location : String
- services : Service[]
- guests : Guest[]
- serviceCount : int
- guestCount : int
+ addService(s : Service) boolean
+ removeService(name : String) boolean
+ searchService(name : String) Service
+ addGuest(g : Guest) boolean
+ removeGuest(name : String) boolean
+ calculateTotalCost() double
+ countGuestsRecursive(index : int) int
+ displayPartyDetails() void
}


class Service {
#serviceName : String
#basePrice : double
+getServiceName()  String
+calculateCost()  double
+displayService()  void
}

class VenueService {
-capacity : int
+calculateCost()  double
}

class CateringService {
-numOfGuests : int
+calculateCost() double
}

class EntertainmentService {
-hours : int
+calculateCost()  double
}

class Payable {
<<interface>>
+calculateCost() double
}

Person <|-- Client
Person <|-- Guest


Party o-- Client
Party o-- Guest
Party o-- Service

Service <|-- VenueService
Service <|-- CateringService
Service <|-- EntertainmentService

Payable <|.. Service



```
