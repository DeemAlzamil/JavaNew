package CoffeeShop1;
public class Coffee extends Drink {//The Coffee class represents a Coffee item in the coffee shop It is a subclass of Drink  
	 
private double NumOfEspShots;// The number of espresso shots in the coffee 
 
public Coffee(String name, double price, boolean isHot, boolean withMilk, char size) {//Constructor for creating a Coffee object. 
 
super(name, price, isHot, withMilk, size); 
 
NumOfEspShots = 1; 
 
} 
 
 
/** 
     Calculates and return the total price of the coffee. 
    Adds an extra charge of 2 SAR per additional espresso shot. 
     */ 
public double calculatePrice() { 
 
double basePrice = super.calculatePrice(); // Get base drink price 
 
return basePrice + ((NumOfEspShots - 1) * 2); // Extra charge for extra espresso shots 
 
} 
 
//Returns a string representation of the coffee, including its espresso shots and price. 
public String toString() { 
 
return "Coffee: " + super.toString() + (NumOfEspShots > 1 ? NumOfEspShots + " Extra Shots" : ""); 
 
} 
 
} 