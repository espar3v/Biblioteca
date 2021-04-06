import java.util.Scanner;

public abstract class Publication {
	protected String name;
	protected String editorial;
	
	static Scanner sc = new Scanner(System.in);
		
	public Publication() { }
	public Publication(String name, String editorial) {
		this.name = name;
		this.editorial = editorial;
	}

	public abstract void show();
	public void showData() {
		System.out.println("NAME: " + name);
		System.out.println("EDITORIAL: " + editorial);
	}

	public abstract void add();
	public void addData() {
		System.out.print("NAME: ");
		name = sc.nextLine();

		System.out.print("EDITORIAL: ");
		editorial = sc.nextLine();
	}
	
	public String buildRegistry() {
		return name + ";" + editorial;
	}
}