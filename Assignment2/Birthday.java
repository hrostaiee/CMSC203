import java.util.Random;
import java.util.Scanner;

/**
 * @author Hasib Rostaiee
 *
 */
public class Birthday {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String PROGRAMMER = "HASIB ROSTAIEE";
		String name; // Store name of the child
		int age; // Store age of the child
		char cancel; // To be used if user want to cancel after a warning
		String toyName; // Store the name of the toy from the choice
		String addToy;
		double totalCost = 0;
		// Declare Toy Object
		Toy toy;

		// Create Scanner Object
		Scanner keyboard = new Scanner(System.in);

		// Ask user to Enter name and age of the child and get the inputs
		System.out.println("Welcome to the Birthday Gifts Program!");

		do {

			addToy = " ";
			do {
				cancel = 'N';
				System.out.println("Please enter the name of your child:");
				name = keyboard.nextLine();

				System.out.println("Please Enter the Age of your child:");
				age = keyboard.nextInt();

				keyboard.nextLine(); // To avoid ignoring the next input by scanner

				// Call displayGiftList method to display list of Gifts
				displayGiftList();

				// Get usesr's choice from keyboard from the list
				toyName = keyboard.nextLine();

				// Create an instance of the child using the constructor methods
				toy = new Toy(toyName, age);

				// Warning if invalid choice
				while (!(toyName.equalsIgnoreCase("plushie") || toyName.equalsIgnoreCase("book")
						|| toyName.equalsIgnoreCase("blocks"))) {
					System.out.println("Please enter a correct name for the list: ");
					displayGiftList();
					toyName = keyboard.nextLine();
					toy.setToy(toyName);

				}

				// Call method to display warning if the age is not appropriate and ask user if
				// want to cancel
				if (toy.ageOK() == false) {
					System.out.println("This Toy is not appropriate for age of your child.\n"
							+ "Do you want to cancel and try again? (y/n)");

					cancel = keyboard.next().toUpperCase().charAt(0);

					// Display Warning message if neither y or n is entered
					while (!(cancel == 'Y' || cancel == 'N')) {
						System.out.println("Please enter 'Y' to cancel or 'N/n' to continue: ");
						cancel = keyboard.next().toUpperCase().charAt(0);
					}
					keyboard.nextLine();

				}

			} while (cancel == 'Y');

			toy.setCost(toy.getToy());

			// Ask if user want to add a card to balloon
			System.out.println("Do you want to add a card with the gift? (yes/no)");
			String addCard = keyboard.next();
			toy.addCard(addCard);

			// Ask if user want to add a card to balloon
			System.out.println("Do you want to add a Balloon with the gift? (yes/no)");
			String addBalloon = keyboard.next().toUpperCase();
			toy.addBalloon(addBalloon);

			System.out.println("The Gift for " + name + toy);

			totalCost += toy.getCost();
			// ask user want more toy
			System.out.println("Do you want to add more Toy? (yes/no)");
			addToy = keyboard.next();
			keyboard.nextLine();

		} while (addToy.equalsIgnoreCase("Yes"));

		toy.setCost(toy.getToy());

		System.out.println("The total cost is:\t$" + toy.dollar.format(totalCost));
		Random rand = new Random();
		int order = rand.nextInt(100000) + 1;
		System.out.println("Order Number:\t\t" + order);
		System.out.println("Programmer Name:\t" + PROGRAMMER);

		keyboard.close();
		System.exit(0);
		// End of Main Method
	}

	/**
	 * This method display the list of toys that user need to choose
	 * 
	 */
	public static void displayGiftList() {
		System.out.println("Please Enter which toy you want form the below list: \n" + "\t 1.Plushie \n"
				+ "\t 2.Book \n" + "\t 3.Blocks");
	}
}