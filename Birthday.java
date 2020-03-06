package _solution;

import java.util.Scanner;

/**
 * @author Hasib Rostaiee
 *
 */
public class Birthday {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name;
		int age;
		boolean ageWarning;
		char cancel;
		String toyName;
		//Create Scanner Object
		Scanner keyboard = new Scanner(System.in);
		
		//Ask user to Enter name and age of the child and get the inputs
		System.out.println("Welcome to the Birthday Gifts Program!");
		System.out.println("Please enter the name of your child:");
		name = keyboard.nextLine();
		System.out.println("Please Enter the Age of your child:");
		age = keyboard.nextInt();
		
		//Create an instance of the child using the constructor methods
		Toy toy = new Toy(name, age);
		
		keyboard.nextLine();
		//Call  displayGiftList method to display list of Gifts
		displayGiftList();
		
		//Get usesr's choice from keyboard from the list
		toyName = keyboard.nextLine();
		
		//call method to save the toyname for the object
		toy.setToy(toyName);
		String nameOfToy = toy.getToy();
		while(!(nameOfToy.equals("plushie") || nameOfToy.equals("book")|| nameOfToy.equals("blocks")))
		{
			System.out.println("Please enter a correc name for the list: ");
			displayGiftList();
			toyName = keyboard.nextLine();
			toy.setToy(toyName);
			nameOfToy = toy.getToy();
		}
		
		//Call method to check if the toy is age appropriate;
//		ageWarning = toy.ageOK();
//		System.out.println("Value of Age warning: "+ageWarning);
		//Call method to display warning if the age is not appropriate
		displayAgeWarning(toy.ageOK());
		
//		String input = keyboard.nextLine();
//		input = input.toUpperCase();
//		cancel = input.charAt(0);
//		while(cancel !='Y' || cancel !='N') {
//			System.out.println("Please enter 'Y' to cancel or 'N' to continue: ");
//			input = keyboard.nextLine();
//			input = input.toUpperCase();
//			cancel = input.charAt(0);
//		}
		
		
	}


	/**
	 * This method display the warning message if the age is not appropriate
	 * @param warning Get the boolean value from the "ageOK" method of Toy class
	 */
	public static void displayAgeWarning(boolean warning) {
		if (warning == false);
		{	System.out.println("This Toy is not appropriate for age of your child.\n"
				+ "Do you want to cancel and try again? (y/n)");}
	}
	
	public static void displayGiftList() {
		System.out.println("Please Enter which toy you want form the below list: \n"
				+ "\t 1.Plushies \n"
				+ "\t 2.Book \n"
				+ "\t 3.Blocks");
	}
}