import java.util.Scanner;

public class SphereVolume {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("Purpose of Program: Calculate Volume of a Sphere");
		
		Scanner keyboard = new Scanner(System.in);
		//defining variables
		double diam, radius, volume;
		final double PI=Math.PI;
		System.out.println("Please Enter diameter of the Sphere: ");
		//Reading user's input in to variable diameter
		diam = keyboard.nextDouble();
		
		//Calculate radius
		radius = diam/2;
		//Calculate volume
		volume = (4*(PI*Math.pow(radius, 3))/3);
		
		System.out.printf("The Volume of the Sphere is: %.2f",volume);
		
		keyboard.close();
		
	}

}
