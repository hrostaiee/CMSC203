package _solution;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.Optional;
import java.util.Random;

/**  	Project 2 -- Spring 2020    uses constructor with arguments
 * 
 * This Birthday Gift Program is the driver that uses the Toy class to purchase birthday 
 * gifts for young children.  A card and/or a balloon may be added to each gift.  A 
 * report showing all the gifts, the total cost, and a randomly generated order number 
 * will print to the console.  Input and message boxes are used for all other
 * input/output items.  Program assumes the name and age are input correctly.
 * @author Ida Justh
*/

public class BirthdayFX extends Application
{
	public static void main(String[] args) {
		launch(args);   
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	  String name = "";		//name of the child 
	  String toy = "";		//one of the three toys available
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
      Alert alert = new Alert(AlertType.NONE); //   .CONFIRMATION);
	  alert.setTitle("");
	  //alert.setHeaderText("Look, a Confirmation Dialog");
	  alert.setContentText("Welcome to the Toy Company");
	  ButtonType buttonTypeOne = new ButtonType("Continue");
	  ButtonType buttonTypeTwo = new ButtonType("Cancel");
	  alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
	  Optional<ButtonType> btnResult = alert.showAndWait();
	  	if (btnResult.get() == buttonTypeOne){
	  		// ... user chose buttonTypeOne
	  		yesOrNo = "yes";
	  	} else {
	  		// ... user chose buttonTypeTwo or closed the dialog
	  		yesOrNo = "no";
	  	}
	  if(yesOrNo.equalsIgnoreCase("yes")) {
      do
      {	  //enter the name of the child
    	  TextInputDialog dialog = new TextInputDialog("");
      	  dialog.setHeaderText("");
    	  dialog.setTitle("Child's Name");
    	  dialog.setContentText("Enter the name of the child");
    	  Optional<String> result = dialog.showAndWait();
    	  if (result.isPresent()) name = result.get();
    	  
    	  //enter the age of the child and convert to integer
    	  dialog = new TextInputDialog("");
      	  dialog.setHeaderText("");
    	  dialog.setTitle("Child's Age");
    	  dialog.setContentText("How old is the child?");
    	  result = dialog.showAndWait();
    	  String ageString = "0";
		  if (result.isPresent()) ageString = result.get();
    	  age = Integer.parseInt(ageString);
    	  
    	  //begin loop to input toy
    	do
    	{	
    	  //enter the type of toy
    	  dialog = new TextInputDialog("");
    	  dialog.setHeaderText("");
    	  dialog.setTitle("Toy Selection");
    	  dialog.setContentText("Choose a toy: a plushie, blocks, or a book");
    	  result = dialog.showAndWait();
    	  if (result.isPresent()) toy = result.get();

    	  //while loop to validate toy choice
    	  while (!(toy.equalsIgnoreCase("plushie")||toy.equalsIgnoreCase("blocks")
    			  ||toy.equalsIgnoreCase("book")))
    	  {
    		  dialog = new TextInputDialog("");
    	  	  dialog.setHeaderText("");
        	  dialog.setTitle("Invalid choice\nPlease choose again");
        	  dialog.setContentText("Choose a toy: a plushie, blocks, or a book");
        	  result = dialog.showAndWait();
        	  if (result.isPresent()) toy = result.get();
    	  }
    	  
    	  //create a Toy object
    	  t = new Toy(toy, age);
    	  
    	  //check if age-appropriate
    	  if (t.ageOK())
    	  {
    		  alert = new Alert(AlertType.INFORMATION);
    		  alert.setTitle("Good Choice!");
    		  alert.setHeaderText(null);
    		  alert.setContentText("Good Choice!");
    		  alert.showAndWait();
    		  
    		  ageCheck = "no";
    	  }
    	  else {
    	      //check if toy is age-appropriate
    		  alert = new Alert(AlertType.NONE); //   .CONFIRMATION);
    		  alert.setTitle("Buy this toy?");
    		  //alert.setHeaderText("Look, a Confirmation Dialog");
    		  alert.setContentText("Toy is not age-appropriate\n"
    				  + "Do you want to buy a different toy? Yes or No ");

    		  buttonTypeOne = new ButtonType("Yes");
    		  buttonTypeTwo = new ButtonType("No");
    		  alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
    		  btnResult = alert.showAndWait();
    		  	if (btnResult.get() == buttonTypeOne){
    		  		// ... user chose buttonTypeOne
    		  		ageCheck = "yes";
    		  	} else {
    		  		// ... user chose buttonTypeTwo or closed the dialog
    		  		ageCheck = "no";
    		  	}
    	  }
    	 }while (ageCheck.equalsIgnoreCase("yes"));  //get a different toy
    	
    	  //check if a card or balloon should accompany the gift
    	  alert = new Alert(AlertType.NONE); 
    	  alert.setTitle("Include a card?");
		  //alert.setHeaderText("Look, a Confirmation Dialog");
		  alert.setContentText("Do you want a card with the gift? Yes or No");

		  buttonTypeOne = new ButtonType("Yes");
		  buttonTypeTwo = new ButtonType("No");
		  alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
		  btnResult = alert.showAndWait();
		  	if (btnResult.get() == buttonTypeOne){
		  		// ... user chose buttonTypeOne
		  		add = "yes";
		  	} else {
		  		// ... user chose buttonTypeTwo or closed the dialog
		  		add = "no";
		  	}
		  	t.addCard(add);
    	  alert = new Alert(AlertType.NONE); 
    	  alert.setTitle("Include a card?");
		  alert.setContentText("Do you want a card with the gift? Yes or No");

		  buttonTypeOne = new ButtonType("Yes");
		  buttonTypeTwo = new ButtonType("No");
		  alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
		  btnResult = alert.showAndWait();
		  	if (btnResult.get() == buttonTypeOne){
		  		// ... user chose buttonTypeOne
		  		add = "yes";
		  	} else {
		  		// ... user chose buttonTypeTwo or closed the dialog
		  		add = "no";
		  	}
		  	t.addBalloon(add);
    	  
      			// Display on the console the cost for one toy 
   		  System.out.println("The gift for " + name + t);
   		  cost += t.getCost();		//add toy cost to total
    	  alert = new Alert(AlertType.NONE); 
    	  alert.setTitle("Another gift?");
		  alert.setContentText("Do you want another gift? Yes or No");

		  buttonTypeOne = new ButtonType("Yes");
		  buttonTypeTwo = new ButtonType("No");
		  alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
		  btnResult = alert.showAndWait();
		  	if (btnResult.get() == buttonTypeOne){
		  		// ... user chose buttonTypeOne
		  		yesOrNo = "yes";
		  	} else {
		  		// ... user chose buttonTypeTwo or closed the dialog
		  		yesOrNo = "no";
		  	}
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


}
  
  