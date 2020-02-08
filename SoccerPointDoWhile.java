import java.util.Scanner;

public class SoccerPointDoWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Number of Points for your team has earned game this season.");
		System.out.println("Enter -1 when finished.");
		System.out.println();
		int total = 0;
		int score = 0;
		
		do {
			total = total+score;
		System.out.println("Enter game point or -1 to end.");
		score = input.nextInt();
	}
		while(score != -1) ;
		
		
		System.out.println("Total Score is: "+total);
		
		//Closing the input
		input.close();
	}

}