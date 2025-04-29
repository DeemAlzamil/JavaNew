 

 
 public class Tea extends Drink {//The Tea class represents a Tea item in the coffee shop It is a subclass of Drink  
	 
	 
	 private String teaType;// The type of tea (e.g., Green, Black, Herbal, Fruit) 
	  
	  
	 public Tea(String name, double price, boolean isHot, boolean withMilk, String teaType, char size) { 
	 //Constructor for creating a Tea object. 
	  
	 super(name, price, isHot, withMilk, size); 
	  
	 this.teaType = teaType; 
	  
	 } 
	  
	  
	 /* Calculates and return the total price of the tea. 
	    Adds a 1 SAR charge for Fruit teas. */ 
	 public double calculatePrice() { 
	  
	 double basePrice = super.calculatePrice();// Get base drink price 
	  
	 return basePrice + (teaType.equalsIgnoreCase("Fruit") ? 1 : 0); 
	  
	 } 
	  
	 //Returns a string representation of the tea, including its type and price. 
	 public String toString() { 
	  
	 return "Tea : " + super.toString() + " Type: " + teaType; 
	  
	 } 
	  
	 //setters and getters 
	 public String getTeaType() { 
	  
	 return teaType; 
	  
	 } 
	  
	 public void setTeaType(String teaType) { 
	  
	 this.teaType = teaType; 
	  
	 } 
	  
	 } 