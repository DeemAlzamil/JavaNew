import java.io.Serializable;

public class Node implements Serializable{
private Item data ;
private Node next ;

public Node(Item obj)
{
data = obj ;
next = null;
}

public void setNext(Node nextI)
{
next = nextI;
}

public Node getNext()
{
    return next;
}

public void setData(Item obj){
    data = obj ;
}

public Item getData(){
    return data;
}
}
