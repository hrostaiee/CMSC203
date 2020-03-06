
public class Person_Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person person1 = new Person();
		Person person2 = new Person("Hasib");
		Person person3 = new Person("John", 22);
		
		
	}

	public Person getMeASibling(Person a) {
		Person sibling = new Person("James", 22);
		return sibling;
	}
	
	
	public static boolean isSenior(Person a) {
		
		return a.getAge() > 65;
	}
}
