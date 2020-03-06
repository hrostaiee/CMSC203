import java.util.Random;

public class Employee {

	private int id;
	private String name;
	private int age;
	private double monthlySalary;
	
	//constructors
	public Employee() {
		
	}
	public Employee(String name) {
		this.name = name;
	}
	public Employee(int id, String name) {
	this.id=id;
	this.name = name;
}
	public Employee(int id, String name, int age, double monthlySalary) {
	this.id = id;
	this.name = name;
	this.age = age;
	this.monthlySalary = monthlySalary;

}
	
	 
	public void setRandomId() {
		Random rand = new Random();
		int randomId = rand.nextInt(100)+1;
		this.id = randomId;
	}
	
	
	//Setters and Getters of ID
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	//Setter and Getter of Name
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	//Setter and Getter for age
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	//Setter and Getter monthlySalary
	public void setMonthlySalary(int monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	public double getMonthlySalary() {
		return monthlySalary;
	}
	
}
