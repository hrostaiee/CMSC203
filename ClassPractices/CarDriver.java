
public class CarDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car car1 = new Car();
		car1.setMake("BMW");
		car1.setColor("White");
		car1.setYear(2019);
		
		System.out.println("The Make of the Car is "+car1.getMake());
		System.out.println("The Color of the Car is "+car1.getColor());
		System.out.println("The Year of the Car is "+car1.getyear());
		
		Car car2 = new Car("Toyota", "Black", 2020);
		System.out.println("Second Car");
		System.out.println("The Make of the Car is "+car2.getMake());
		System.out.println("The Color of the Car is "+car2.getColor());
		System.out.println("The Year of the Car is "+car2.getyear());
	}

}
