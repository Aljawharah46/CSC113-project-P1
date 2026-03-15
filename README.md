# CSC113-project-P1
```mermaid
classDiagram
class Person{
#String name
#String phoneNumber
+String getName()
+String getPhone()
+void displayDetails()
}

class Client{
party
createParty()
getParty()
}

Person <|-- Client
```
