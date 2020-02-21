
public class Person {

	private int age;
	private String name;
	private double height;
	
	public Person( ) {
		name= "No Name";
		age =0;
		height = 5.0;
		
	}
	
	public Person(String name ) {
		this.name = name;
	}
	public Person( String name, int age) {
		this.age = age;
		this.name = name;
	}
	
	public String toString() {
					return	"Name: "+ name +"\n"
							+"Age: 	"+age +"\n"
							+"Height: "+height +"\n";
	
	}
	
	public boolean equals(Person p) {
	return (this.age == p.getAge() && this.name.equals(p.getName()));
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
}
