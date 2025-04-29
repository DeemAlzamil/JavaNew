
import java.io.Serializable;
import java.util.Scanner; 
 
public class Order implements Serializable { 
public static Scanner input = new Scanner(System.in); 
// Scanner for user input used in methods 
 
private int OrderID; 
private String UserName; 
private String UserNumber; 
private int NumOfItem; 
private double totalPrice; 
private String orderStatus; 
private Item List[]; 
// Array to store items in the order 
 
// Constructor to initialize order details 
public Order(String userName, String userNumber, int OrderID) { 
UserName = userName; 
UserNumber = userNumber; 
NumOfItem = 0; 
totalPrice = 0; 
List = new Item[20]; // Fixed-size array for storing items 
orderStatus = "Processing"; 
this.OrderID = OrderID; 
} 
 
// Copy constructor to duplicate an order 
public Order(Order obj) { 
OrderID = obj.OrderID; 
UserName = obj.UserName; 
UserNumber = obj.UserNumber; 
totalPrice = obj.totalPrice; 
orderStatus = obj.orderStatus; 
List = new Item[obj.List.length]; 
 
for (int i = 0; i < obj.NumOfItem; i++) 
List[NumOfItem++] = obj.List[i]; 
} 
 
// Method to add an item to the order 
public boolean addItem(Item item) { 
if (NumOfItem < List.length) { 
 
if (item instanceof Cake) { 
System.out.println("Do you want a candle?"); 
char ans = input.next().charAt(0); 
if (ans == 'Y' || ans == 'y') 
List[NumOfItem++] = new Cake(item.getName(), item.getPrice(), ((Cake) item).getFlavor(), true); 
else 
List[NumOfItem++] = new Cake(item.getName(), item.getPrice(), ((Cake) item).getFlavor(), false); 
 
return true; 
} 
 
else if (item instanceof Coffee) { 
System.out.println("What size? (S/M/L)"); 
char ans = input.next().charAt(0); 
if (ans == 'L' || ans == 'l') 
List[NumOfItem++] = new Coffee(item.getName(), item.getPrice(), ((Coffee) item).isHot(), 
((Coffee) item).isWithMilk(), 'L'); 
else if (ans == 'M' || ans == 'm') 
List[NumOfItem++] = new Coffee(item.getName(), item.getPrice(), ((Coffee) item).isHot(), 
((Coffee) item).isWithMilk(), 'M'); 
else 
List[NumOfItem++] = new Coffee(item.getName(), item.getPrice(), ((Coffee) item).isHot(), 
((Coffee) item).isWithMilk(), 'S'); 
 
return true; 
} 
 
else if (item instanceof Tea) { 
System.out.println("What size? (S/M/L)"); 
char ans = input.next().charAt(0); 
if (ans == 'L' || ans == 'l') 
List[NumOfItem++] = new Tea(item.getName(), item.getPrice(), ((Tea) item).isHot(), 
((Tea) item).isWithMilk(), ((Tea) item).getTeaType(), 'L'); 
else if (ans == 'M' || ans == 'm') 
List[NumOfItem++] = new Tea(item.getName(), item.getPrice(), ((Tea) item).isHot(), 
((Tea) item).isWithMilk(), ((Tea) item).getTeaType(), 'M'); 
else 
List[NumOfItem++] = new Tea(item.getName(), item.getPrice(), ((Tea) item).isHot(), 
((Tea) item).isWithMilk(), ((Tea) item).getTeaType(), 'S'); 
 
return true; 
} 
} 
 
return false; 
} 
 
// Method to remove an item from the order 
public boolean deleteItem(String name) { 
Item itemToDelete = FindItem(name); // Find the item first 
 
    if (itemToDelete == null) { 
        return false; // No matching item found 
    } 
 
    // Remove the item from the list 
    for (int i = 0; i < NumOfItem; i++) { 
        if (List[i] == itemToDelete) { 
            List[i] = List[NumOfItem - 1]; // Replace with last item 
            NumOfItem--; 
            List[NumOfItem] = null; 
            return true; // Successfully deleted 
        } 
    } 
 
    return false; // Should never reach here 
} 
 
// Method to calculate the total cost of the order 
public double calculateTotal() { 
double total = 0; 
for (int i = 0; i < NumOfItem; i++) 
total += List[i].calculatePrice(); 
return total; 
} 
 
// Method to find an item in the order 
public Item FindItem(String name) { 
char ans = ' '; 
boolean candle = false; 
boolean firstPromptDone = false; // Prevents repeated input prompts 
 
for (int i = 0; i < NumOfItem; i++) { 
if (List[i].getName().equalsIgnoreCase(name)) { 
 
if (List[i] instanceof Cake) { 
if (!firstPromptDone) { // Ask only once 
System.out.println("Is it with a candle? Y for yes, anything else will be considered no: "); 
ans = input.next().charAt(0); 
candle = (ans == 'y' || ans == 'Y'); 
firstPromptDone = true; 
} 
 
if (((Cake) List[i]).isAddCandle() == candle) { 
 
return List[i]; 
} 
} 
 
else if (List[i] instanceof Drink) { 
if (!firstPromptDone) { // Ask only once 
System.out.println("What is the size? (S/M/L): "); 
ans = input.next().charAt(0); 
 
while (ans != 'S' && ans != 's' && ans != 'M' && ans != 'm' && ans != 'L' && ans != 'l') { 
System.out.println("Invalid size. We only have S, M, or L. Try again: "); 
ans = input.next().charAt(0); 
} 
ans = Character.toUpperCase(ans); // Standardizing input 
firstPromptDone = true; 
} 
 
if (((Drink) List[i]).getSize() == ans) { 
 
return List[i]; 
} 
} 
} 
} 
return null; 
} 
 
 
 
// Method to return order details as a string 
public String toString() { 
String str = "OrderID: " + OrderID + "\nUserName: " + UserName + "\nUserNumber: " + UserNumber 
+ "\nNumber of items: " + NumOfItem + "\nOrder Status: " + orderStatus + "\nTotal Price = " 
+ calculateTotal(); 
 
for (int i = 0; i < NumOfItem; i++) { 
str += "\n" + List[i].toString(); 
} 
return str; 
} 
 
// Getter method for OrderID 
public int getOrderID() { 
return OrderID; 
} 
 
// Setter method for OrderID 
public void setOrderID(int orderID) { 
OrderID = orderID; 
} 
 
// Getter method for order status 
public String getOrderStatus() { 
return orderStatus; 
} 
 
// Setter method for order status 
public void setOrderStatus(String orderStatus) { 
this.orderStatus = orderStatus; 
} 
 
// Getter method for user name 
public String getUserName() { 
return UserName; 
} 
 
// Setter method for user name 
public void setUserName(String userName) { 
UserName = userName; 
} 
 
// Getter method for user phone number 
public String getUserNumber() { 
return UserNumber; 
} 
 
// Setter method for user phone number 
public void setUserNumber(String userNumber) { 
UserNumber = userNumber; 
} 
 
// Getter method for number of items in order 
public int getNumOfItem() { 
return NumOfItem; 
} 
 
// Setter method for number of items in order 
public void setNumOfItem(int numOfItem) { 
NumOfItem = numOfItem; 
} 
 
// Getter method for total price of order 
public double getTotalPrice() { 
return totalPrice; 
} 
 
// Setter method for total price of order 
public void setTotalPrice(double totalPrice) { 
this.totalPrice = totalPrice; 
} 
} 