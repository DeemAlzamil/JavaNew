package CoffeeShop1;
public abstract class Item { 
	 
protected String Name; // Name of the item 
 
protected double price;// Base price of the item 
 
 
 
public Item(String name, double price) {//Constructor to initialize the item with a name and price. 
 
Name = name; 
 
this.price = price; 
 
} 
 
 
public abstract double calculatePrice();//Abstract method that must be implemented by subclasses to calculate the final price. 
 
 
 
public String toString() {//Returns a string representation of the item. 
 
return Name + " Price: " + calculatePrice() + " SAR"; 
 
} 
//setters and getters 
 
public String getName() { 
 
return Name; 
 
} 
 
public double getPrice() { 
 
return price; 
 
} 
 
public void setName(String name) { 
 
Name = name; 
 
} 
 
public void setPrice(double price) { 
 
this.price = price; 
 
} 
 
} 