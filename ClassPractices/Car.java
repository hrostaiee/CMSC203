
public class Car {

	private String make;
	private String color;
	private int year;
	
	//Default Constructor Metod
	public Car () {
		
	}
	
	public Car (String make, String color, int year) {
		this.make = make;
		this.color = color;
		this.year = year;
	}
	
	//Setter Method for Make;
	public void setMake(String make) {
		this.make = make;
	}
	//Getter method for Make
	public String getMake() {
		return make;
	}
	
	//setter for color
	public void setColor (String color) {
		this.color = color;
	}
	//getter for color
	public String getColor() {
		return color;
	}
	
	//setter for year
	public void setYear(int year) {
		this.year = year;
	}
	
	//getter for year
	public int getyear() {
		return year;
	}
}
