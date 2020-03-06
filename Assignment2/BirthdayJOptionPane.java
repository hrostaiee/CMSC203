package _solution;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.Random;

/**  	Project 2 -- Spring 2020     uses constructor with arguments
 * 
 * This Birthday Gift Program is the driver that uses the Toy class to purchase birthday 
 * gifts for young children.  A card and/or a balloon may be added to each gift.  A 
 * report showing all the gifts, the total cost, and a randomly generated order number 
 * will print to the console.  Input and message boxes are used for all other
 * input/output items.  Program assumes the name and age are input correctly.
 * @author Ida Justh
*/

public class BirthdayJOptionPane
{
   public static void main(String[] args)
   {
	  String name;		//name of the child 
	  String toy;		//one of the three toys available
	  String numInput;	//number from keyboard as a string
	  String yesOrNo = " ";	//user response from keyboard
	  String add = " ";		//yes or no to add a card or balloon
	  String ageCheck = " "; //yes or no from the keyboard
	  int age;			//numeric input for age
	  double cost=0;	//running total cost for the order
	  	// Create a DecimalFormat object for dollar formatting.
	  DecimalFormat dollar = new DecimalFormat("#,##0.00");
      Toy t;  
      System.out.println("     BIRTHDAY GIFTS\n"); //console title
      
      		//begin the order for toys
      do
      {		//enter the name of the child
    	  name = JOptionPane.showInputDialog("Enter the name of the child");
    	  	//enter the age of the child and convert to integer
    	  numInput =JOptionPane.showInputDialog("How old is the child?");
    	  age = Integer.parseInt(numInput);
    	  
    	  	//begin loop to input toy
    	do
    	{	
    		//enter the type of toy
    	  toy = JOptionPane.showInputDialog("Choose a toy: a plushie, blocks, or a book");

    	  	//while loop to validate toy choice
    	  while (!(toy.equalsIgnoreCase("plushie")||toy.equalsIgnoreCase("blocks")
    			  ||toy.equalsIgnoreCase("book")))
    	  {
    		  JOptionPane.showMessageDialog(null,"Invalid choice\nPlease choose again");
    		  toy = JOptionPane.showInputDialog("Choose a toy: a plushie, blocks, or a book");
    	  }
    	  
    	  		//create a Toy object
    	  t = new Toy(toy, age);
    	  
    	   	  	//check if age-appropriate
    	  if (t.ageOK())
    	  {
    		  JOptionPane.showMessageDialog(null,"Good Choice!");
    		  ageCheck = "no";
    	  }
    	  else
    	      		  	//check if toy is age-appropriate
    		  ageCheck = JOptionPane.showInputDialog("Toy is not age-appropriate\n"
    				  + "Do you want to buy a different toy? Yes or No ");
    	 }while (ageCheck.equalsIgnoreCase("yes"));  //get a new toy
    	
    			//check if a card or balloon should accompany the gift
    	  add = JOptionPane.showInputDialog("Do you want a card with the gift? Yes or No");
    	  t.addCard(add);
    	  add = JOptionPane.showInputDialog("Do you want a balloon with the gift? Yes or No");
    	  t.addBalloon(add);
    	  
      			// Display on the console the cost for one toy 
   		  System.out.println("The gift for " + name + t);
   		  cost += t.getCost();		//add toy cost to total
    	  yesOrNo = JOptionPane.showInputDialog("Do you want another toy? Yes or No ");
      }while(yesOrNo.equalsIgnoreCase("yes"));
      
      		//output total cost of order
      System.out.println("\nThe total cost of your order is $" + dollar.format(cost) );
      		//Generate a random order number
      Random rand = new Random();
      int order = rand.nextInt(100000) + 1;
      System.out.println("\nOrder number is " + order);
      System.exit(0);
   }
}
  
  