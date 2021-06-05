import java.util.Scanner;

abstract class Publication {
	protected String name;
	protected String editorial;
	
	static Scanner sc = new Scanner(System.in);
		
	Publication() { }
	Publication(String name, String editorial) {
		this.name = name;
		this.editorial = editorial;
	}

	abstract void show();
	void showData() {
		System.out.println("NAME: " + name);
		System.out.println("EDITORIAL: " + editorial);
	}

	abstract void add();
	void addData() {
		System.out.print("NAME: ");
		name = sc.nextLine();

		System.out.print("EDITORIAL: ");
		editorial = sc.nextLine();
	}
	
	String buildRegistry() {
		return name + ";" + editorial;
	}
}