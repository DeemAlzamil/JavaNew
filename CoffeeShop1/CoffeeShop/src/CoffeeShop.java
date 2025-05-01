
import java.io.*;
public class CoffeeShop implements InputOtpuInterface {  


Node headItem ;

private String ShopName; // Name of the coffee shop 
private int NumOfOrder; // Number of current orders 
private Order orders[]; // Array to store orders 
//private Item Items[]; // Array to store available items 
//private int NumOfItems; // Number of items in the shop 
int maxNumOfItem = 20 ;

//Constructor to initialize the coffee shop with name, order size, and item size 
public CoffeeShop(String name, int Ordersize) {  
ShopName = name;  
NumOfOrder = 0;  
//NumOfItems = 0;  
orders = new Order[Ordersize];  
//Items = new Item[ItemSize];  
headItem = null ;
}  


public int CountItem()
{
if( headItem == null )
return 0 ;
int count =0 ;
Node current = headItem ;
while(current != null )
{
count++ ;
current = current.getNext();
}
return count ;
}




//Adds an item to the shop 
/*public boolean addItem(Item item) {  
if (NumOfItems < Items.length) {  
Items[NumOfItems++] = item;  
return true;  
}  
return false;  
}  */

public boolean addItem(Item item ){
if( CountItem() < maxNumOfItem ){ // aggregation
Node n = new Node(item) ;
n.setNext(headItem);
headItem = n ;
return true;
}
return false;
}


//Deletes an item from the shop based on its name 
/*public boolean deleteItem(String name) {  
for (int i = 0; i < NumOfItems; i++) {  
if (Items[i].getName().equalsIgnoreCase(name)) {  
Items[i] = Items[NumOfItems - 1]; // Replace with last item 
NumOfItems--;  
Items[NumOfItems] = null; // Remove last item 
return true;  
}  
}  
return false;  
}  */

public boolean deleteItem(String name) {
    if (headItem == null)
        return false;

    if (headItem.getData().getName().equalsIgnoreCase(name)) {
        headItem = headItem.getNext();
        return true;
    }
    Node prev = headItem;
    Node current = headItem.getNext();

    while (current != null) {
        if (current.getData().getName().equalsIgnoreCase(name)) {
            prev.setNext(current.getNext());
            return true;
        } else {
            prev = current;
            current = current.getNext();
        }
    }

    return false;
}




//Adds a new order to the shop 
public boolean addOrder(Order or) {  
if (NumOfOrder < orders.length) {  
orders[NumOfOrder++] = new Order(or); // Copy order 
return true;  
}  
return false;  
}  


//Cancels an order based on ID 
public boolean cancelOrder(int id) {  
for (int i = 0; i < NumOfOrder; i++)  
if (orders[i].getOrderID() == id) {  
orders[i].setOrderStatus("Canceled");  
return true;  
}  
return false;  
}  


//Displays the menu of available items with customization options 
/*public void displayMenu() {  
for (int i = 0; i < NumOfItems; i++)  
System.out.println(Items[i].toString()); 
System.out.println("You can upgrade to Medium for an extra 1.5 SAR or Large size for an extra 2.5 SAR.");  
System.out.println("You can add a candle for 1 SAR.");  
System.out.println("You can add milk for 1 SAR.");  
}  */

public void displayMenu() {
    Node current = headItem;

    while (current != null) {
        System.out.println(current.getData().toString());
        current = current.getNext();
    }

    System.out.println("You can upgrade to Medium for an extra 1.5 SAR or Large size for an extra 2.5 SAR.");
    System.out.println("You can add a candle for 1 SAR.");
    System.out.println("You can add milk for 1 SAR.");
}

public Item searchItem(String name ){
 if( headItem == null )
 return null ;

Node current = headItem ;
while(current != null ) {
if( current.getData().getName().equalsIgnoreCase(name))
return current.getData() ;

current = current.getNext(); }
return null ;
}



 


//Returns information about the coffee shop and its orders 
public String toString() {  
String ourOrders = "";  
for (int i = 0; i < NumOfOrder; i++) {  
ourOrders += orders[i].toString() + "\n";  
}  
return "CoffeeShop NumOfOrder: " + NumOfOrder + "\nOur Orders:\n" + ourOrders;  
}  


//Getters and Setters 
public int getNumOfOrder() { return NumOfOrder; }  
//public int getNumOfItems() { return NumOfItems; }  
public void setNumOfOrder(int numOfOrder) { NumOfOrder = numOfOrder; }  
//public void setNumOfItems(int numOfItems) { NumOfItems = numOfItems; }  


//Searches for an item by name 
/*public Item WhatItem(String name) {  
for (int i = 0; i < NumOfItems; i++) {  
if (Items[i].getName().equalsIgnoreCase(name))  
return Items[i];  
}  
return null;  
} */ 

public Item WhatItem(String name) {
    Node current = headItem;

    while (current != null) {
        if (current.getData().getName().equalsIgnoreCase(name)) {
            return current.getData();
        }
        current = current.getNext();
    }

    return null;  
}



//Searches for an order by ID 
public Order findOrder(int ID) {  
for (int i = 0; i < NumOfOrder; i++) {  
if (orders[i].getOrderID() == ID)  
return orders[i];  
}  
return null;  
}  

public void savaAllInfo(){

    try{
        /*File Ite=new File("Items.dat");
        FileOutputStream fos=new FileOutputStream(Ite);
        ObjectOutputStream oos=new ObjectOutputStream(fos);

        oos.writeObject(\\مدري شالمفروض هنا اعتقد شي من الداتا ستركتشر);
        oos.close();*/

        File orde =new File("Orders.dat");
        FileOutputStream fos2=new FileOutputStream(orde);
        ObjectOutputStream oos2=new ObjectOutputStream(fos2);

        oos2.writeInt(NumOfOrder);
        oos2.writeObject(orders);//write array all at once
        oos2.close();
     }
     catch(IOException e){
        System.err.println(e.toString());
     }

}

public void readAllInfo(){
    try {
        /*File Ite =new File("Items.dat");
        FileInputStream ff=new FileInputStream(Ite);
        ObjectInputStream in=new ObjectInputStream(ff);

        somthing Related to node=(Node) in.readObject();
        in.close(); */

        File orde =new File("Orders.dat");
        FileInputStream ff2=new FileInputStream(orde);
        ObjectInputStream in2=new ObjectInputStream(ff2);

        NumOfOrder = in2.readInt();
        orders=(Order[]) in2.readObject();
        in2.close();

        System.out.println("All data in files are loaded");
        
    } catch(ClassNotFoundException ex){
        System.out.println(ex.toString());}
        catch(IOException e){
            System.out.println(e.toString());
        }
    }
}


