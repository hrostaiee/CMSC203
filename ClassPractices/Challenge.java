import java.util.Scanner;

public class Challenge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		String input;
		int countOfA=0; 
		
		System.out.println("Please Enter some String and I will tell you how many 'A' is there:");
		
		 input = keyboard.nextLine();
		
		input = input.toUpperCase();

		
		for(int i=0; i<input.length();i++)
		{
			char letter=input.charAt(i);
					
			if(letter=='A') {
				countOfA++;
			}
		}
		
		System.out.println("Total istance of A in your sentence/word is "+countOfA);
		
	}

}
