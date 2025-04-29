package CoffeeShop1;

public class Drink extends Item {//The Drink class represents a Drink item in the coffee shop It is a subclass of Item  

private char Size;// The size of the drink: 'S' (Small), 'M' (Medium), 'L' (Large) 

private boolean isHot;// True if the drink is served hot, false if it's cold 

private boolean withMilk; // True if milk is added, false otherwise 
public Drink(String name, double price, boolean isHot, boolean withMilk, char size) {//Constructor for creating a Drink object. 

super(name, price); 

Size = size; 

this.isHot = isHot; 

this.withMilk = withMilk; 

} 

public double calculatePrice() { 
/*Calculates the total price of the drink based on its size and if it is with milk or not. 
    Medium drinks cost 1.5 SAR extra. 
    Large drinks cost 2.5 SAR extra. 
    Drinks with milk cost 2.5 SAR extra. */ 

double extraCost = (Size == 'L') ? 2.5 : (Size == 'M') ? 1.5 : 0; 

return price + extraCost + (withMilk ? 2.5 : 0); 

} 
//Returns a string representation of the drink. 
public String toString() { 

return super.toString() + " Size: " + Size + ", " + (isHot ? "Hot" : "Cold") + (withMilk ? " With Milk" : " ") 

; 

} 

//setters and getters 
public char getSize() { 

return Size; 

} 

public void setSize(char size) { 

Size = size; 

} 

public boolean isHot() { 

return isHot; 

} 

public void setHot(boolean isHot) { 

this.isHot = isHot; 

} 

public boolean isWithMilk() { 

return withMilk; 

} 

public void setWithMilk(boolean withMilk) { 

this.withMilk = withMilk; 

} 

} 