

import java.io.File;
import java.util.Scanner; 
 
public class Test {// Test class for the Coffee Shop ordering system. 
    
    // Creating a coffee shop instance with capacity for 20 orders and 20 items 
   static CoffeeShop ourCoffee = new CoffeeShop("Our Coffee", 20, 20); 

public static void main(String[] args) { 

    File Ite=new File("Items.dat");
    File orde =new File("Orders.dat");

    if(Ite.exists() && orde.exists()){
        ourCoffee.readAllInfo();
    }
    else{
 
        
        
        // Creating menu items (cakes and drinks) to be added to the shop's menu 
        Cake K1 = new Cake("Cheesecake", 15.0, "Blueberry", false); 
        
        Cake K2 = new Cake("Cupcake", 7.0, "Vanilla", false); 
        
        Coffee C1 = new Coffee("Cappuccino", 12.0, true, true, 'S'); 
        
        Coffee C2 = new Coffee("Iced Coffee", 16.0, false, false, 'S'); 
        
        Tea T1 = new Tea("Green Tea", 11.0, true, false, "Green", 'S'); 
        
        Tea T2 = new Tea("Cold Tea Sweet Mango", 17.0, false, false, "Fruit", 'S'); 
        
        // Adding items to the coffee shop's menu 
        ourCoffee.addItem(K1); 
        
        ourCoffee.addItem(K2); 
        
        ourCoffee.addItem(C1); 
        
        ourCoffee.addItem(C2); 
        
        ourCoffee.addItem(T1); 
        
        ourCoffee.addItem(T2); }//end of else
        
        int Id = 100;// Starting order ID for customers, incremented with each new order 
        boolean customerHaveOneItem = false; 

        Scanner input=new Scanner (System.in) ;
        int choice;// Stores the user's menu selection 
        
        // Main menu loop that runs until the user chooses to exit 
do { 
 
// Displaying the main menu options 
System.out.println("\n--- Coffee Shop Menu ---"); 
 
System.out.println("1. View Menu"); 
 
System.out.println("2. Place an Order"); 
 
System.out.println("3. Cancel Order"); 
 
System.out.println("4. Search for an order"); 
 
System.out.println("5. Exit"); 
 
System.out.print("Enter your choice: "); 
 
choice = input.nextInt(); 
 
switch (choice) { 
 
case 1: 
// View available menu items 
ourCoffee.displayMenu(); 
break; 
 
case 2: 
// Placing a new order 
 
System.out.println("Enter Your Name: "); 
 
String Name = input.next(); 
 

String Number;
while(true){
    try{
System.out.println("Enter Your Number: "); 
 Number = input.next(); 
if(Number.length()!=10 || !Number.startsWith("05"))
throw new invalidMobileNum("Please enter a valid number that starts with 05 and contains exactly 10 digits");

long num=Long.parseLong(Number);
break;
    }
    catch(NumberFormatException e){
        System.out.println("Phone number should contain only numbers. Try again.");
    }
    catch(invalidMobileNum ex){
        System.out.println(ex.getMessage());
    }
}//end of while
 
// Create a new order for the customer 
Order CoustomerOrder = new Order(Name, Number, Id); 
 
Id++; 
 
int choose;// Used for order modification choices 
boolean MoreItems = false; // Track if the customer wants to add more items 
 
 
input.nextLine();// Clear buffer 
 
do { 
System.out.println("Please enter the item name you want to order."); 
String itemName = input.nextLine(); 
 
Item h = ourCoffee.WhatItem(itemName);// Search for the item in the menu 
 
if (h != null) { 
 
if (CoustomerOrder.addItem(h)) { 
System.out.println("Adding " + h.getName() + " done"); 
customerHaveOneItem = true; 
} 
} else { 
System.out.println("Item not found. Please try again."); // Inform user 
} 
 
} while (!customerHaveOneItem); // Keep looping until an item is added 
 
// Order management loop 
do { System.out.println("Welcome " + Name); 

System.out.println("\n--- Order Menu ---"); 

System.out.println("1. Add Item to Order"); 

System.out.println("2. Remove Item from Order"); 

System.out.println("3. Exit"); 

System.out.print("Enter your choice: "); 

choose = input.nextInt(); 

switch (choose) { 

case 1:// Add Item to Order 

do { 

System.out.println("Please enter the item name you want to order."); 

input.nextLine();// Clear buffer 

String itemName = input.nextLine(); 

Item h = ourCoffee.WhatItem(itemName);// Search for the item in the menu 

if (h != null) { 

if (CoustomerOrder.addItem(h)) { 

System.out.println("Adding " + h.getName() + " done"); 
} 

else 

System.out.println("You reached the Maximum number of items"); 

} else 

System.out.println("Sorry incorrect item try again"); 

//Ask if the user wants to add more items 
System.out.println("Do you want to add more items? if yes type Y if no type N"); 

char ch = input.next().charAt(0); 

if (ch == 'Y' || ch == 'y') 

MoreItems = true; 

else 

break; 

} while (MoreItems); 

break; 

case 2: 
//Removing an item from the order 
System.out.println("Plesae enter the item Name you want to remove"); 

input.nextLine(); 
String str = input.nextLine(); 

if (CoustomerOrder.deleteItem(str)) { 
 
System.out.println("Delete done succsesfly"); 
 
break; 
 
} else 
 
System.out.println("Sorry we didnt find this item in your order"); 
 
break; 
 
case 3: 
 
// Completing the order 
System.out.println("Thank you for ordering, this is your order info:"); 
 
System.out.println(CoustomerOrder.toString()); 
 
ourCoffee.addOrder(CoustomerOrder);// Store the order in the coffeeShop order array 
 
break; 
 
} 
 
} while (choose != 3);// Continue order menu until the user chooses to complete the order 
 
break; 
 
case 3: 
// Canceling an existing order 
 
System.out.print("Enter your Order ID: "); 
 
int Orderid = input.nextInt(); 
 
if (ourCoffee.cancelOrder(Orderid)) { 
 
System.out.println("\n Your order is canceled"); 
 
} 
 
else 
 
System.out.println("TRY AGAIN"); 
 
break; 
 
case 4: 
// Searching for an order by Order ID 
 
System.out.print("Enter your Order ID: "); 
 
int findOr = input.nextInt(); 
 
if (ourCoffee.findOrder(findOr) != null) { 
 
System.out.println(ourCoffee.findOrder(findOr).toString()); 
 
} 
 
else 
 
System.out.println("Sorry we can't find your order"); 
 
break; 
 
case 5: 
// Exiting the program 
 
System.out.println(ourCoffee.toString()); 
System.out.println("Exiting... Thank you for visiting!"); 
 
break; 
 
default: 
// Handling invalid menu choices 
System.out.println("Invalid choice! Please enter a number between 1 and 5."); 
 
} 
 
} while (choice != 5);// end of main menu loop, The loop continues until the user chooses to exit 
 
ourCoffee.savaAllInfo();
} 
 
} 