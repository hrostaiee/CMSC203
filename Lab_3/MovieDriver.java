import java.util.Scanner;

public class MovieDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creating Scanner Class
		Scanner keyboard = new Scanner(System.in);
		char answer;
		do {
		//Creating Movie Object
		Movie movie1 = new Movie();
		
		//Ask user for title and add to the movie1
		System.out.println("Please Enter the Movie Title");
		movie1.setTitle(keyboard.nextLine());
		//Ask user for rating and add to the movie1
		System.out.println("Please Enter the Movie Rating");
		movie1.setRating(keyboard.nextLine());
		//Ask user for tickets sold and add to the movie1
		System.out.println("How Many tickets have been sold for this Movie");
		movie1.setSoldTickets(keyboard.nextInt());
		//Display information of Movie1 using toString
		System.out.println(movie1);
		System.out.println();
		//Ask user if want to enter another information and repeate if answer is y
		System.out.println("Do you want to enter another? (y or n):");
		answer = keyboard.next().charAt(0);
		keyboard.nextLine();
		}while (answer =='y'|| answer =='Y');
		System.out.println("Good Bye");
		keyboard.close();
	}

}
