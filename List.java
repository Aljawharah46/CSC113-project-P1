public class List{
private Node head;
private Node tail;
private String Name;

public List(){
head=tail=null;
Name="No Name";
}

public List(String name){
head=tail=null;
Name=name;
}

public boolean isEmpty(){
return head==null;
}

public void insertAtBack(Object obj){
Node newNode=new Node(obj);
if(isEmpty())
head=tail=newNode;
else
tail.setNext(newNode);
tail=newNode;

}

public Object removeFromFront(){

if(isEmpty())
return null;

Node first=head;
if (head==tail)
head=tail=null;
else
head=head.getNext();
return first.getData();

}


public Node getHead(){
return head;
}

}//end class