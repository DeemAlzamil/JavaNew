package CoffeeShop1;



public class Cake extends Item {//The Cake class represents a cake item in the coffee shop It is a subclass of Item  

private String Flavor;//Flavor of the cake 

private boolean AddCandle;//Indicates whether a candle is added for an extra charge 

public Cake(String name, double price, String flavor, boolean addCandle) {//Constructor for creating a Cake object. 

super(name, price); 

Flavor = flavor; 

AddCandle = addCandle; 

} 

public double calculatePrice() {//Calculates and return the total price of the cake, If a candle is added, an extra charge is applied. 

return price + (AddCandle ? 1.0 : 0); 

} 

public String toString() {//Returns a string representation of the cake, including its flavor and price. 

return "Cake : " + super.toString() + " Flavor: " + Flavor + (AddCandle ? ", with Candle" : ""); 

} 


//setters and getters 

public String getFlavor() { 

return Flavor; 

} 

public void setFlavor(String flavor) { 

Flavor = flavor; 

} 

public boolean isAddCandle() { 

return AddCandle; 

} 

public void setAddCandle(boolean addCandle) { 

AddCandle = addCandle; 

} 

} 
