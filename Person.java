public class Person {
	private String name;
	private double stamina;
	private int health;
	private static int count;

	public Person(String name) {
		// setName(name);
		// this.stamina = 0.5;
		this(name, 0.5, 50);//, look for one of the constructors with these arguments
		

		run();
		run(200);

	}

	public Person(String name, double stamina, int health) {
		setName(name);
		this.stamina = stamina;
		this.health = health;
		//this(name, stamina, 100);
		Person.addOne();
	}

	public static void main(String[] args) {
		Person p1 = new Person("Alice");
		Person p2 = new Person("Bob", 0.25); //matches the (String name, double stamina) constructor
	}

	public static addOne() { //static: when you don't want every single object to get a copy of that method
		count++;
	}


	public String name() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void run() {

	}

	public void run(int x) {
		//runs x feet
	}
	
}

//method overloading
