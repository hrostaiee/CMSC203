import java.util.Scanner;

public class WindChill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Define Variables
		double temperature;
		double windSpeed;
		double windChill;
		//Import Scanner Calss to read data from keyboard input
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Welcome to Wind Chill Calculator!\n");
		
		/*
		 * Asking for Temperature and wind Speed and and read the values in to
		 * "temperature" and windSpeed variables
		 */
		System.out.println("Please enter temperature in Fahrenheit (Must bee between -45 and 40):");
		temperature = userInput.nextDouble();
		System.out.println("Please enter wind speed in mph (Must bee between 5 and 60):");
		windSpeed = userInput.nextDouble();
		
		//closing input
		userInput.close();
		//Calculate the Wind Chill
		windChill = 35.74 + 0.6215*temperature - 35.75 * (Math.pow(windSpeed, 0.16)) + 
				0.4275*temperature*(Math.pow(windSpeed, 0.16));

		System.out.println("Wind Chill(F) Temprature is:"+windChill);
		
		System.out.println("\nProgrammer: Hasib Rostaiee");
	}

}
