import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class LoopBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner console = new Scanner (System.in);
		int input;
		
		System.out.println("Please Enter a number between 1 and 100");
		input = console.nextInt();

		for (; input>0; input--)
		{
			System.out.println("number"+input);
			if(input%10 ==0) {
				break;
			}
		}
		System.out.println("The Number is "+input);
	}

}
