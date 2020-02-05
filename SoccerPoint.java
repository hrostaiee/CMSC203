import java.util.Scanner;

public class SoccerPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Number of POints for your team has earned game this season.");
		System.out.println("Enter -1 when finished.");
		int total =0;
		int score = input.nextInt();
		
		while(score != -1) {
			total = total+score;
			System.out.println("Enter game point or -1 to end.");
			score = input.nextInt();
			
			
		}
		
		System.out.println("Total Score is: "+total);
		
		//Closing the input
		input.close();
	}

}
