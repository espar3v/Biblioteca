import java.util.Scanner;

public class Magazine extends Publication {
	private int year;
	private int number;
	
	static Scanner sc = new Scanner(System.in);
	
	public Magazine() {
		super();
	}
	public Magazine(String name, String editorial, int year, int number) {
		super(name, editorial);
		this.year = year;
		this.number = number;
	}

	@Override
	public void show() {
		showData();
	}
	public void showData() {
		System.out.println("\n=========================================");
		System.out.println("================ MAGAZINE ===============");
		System.out.println("=========================================");
		
		super.showData();

		System.out.println("YEAR: " + year);
		System.out.println("NUMBER: " + number);
	}

	@Override
	public void add() {
		addData();
	}
	public void addData() {
		super.addData();

		System.out.print("PUBLICATION YEAR: ");
		year = sc.nextInt();

		System.out.print("NUMBER OF THE MAGAZINE: ");
		number = sc.nextInt();
	}

	public String buildRegistry() {
		return super.buildRegistry() + ";" + year + ";" + number;
	}
}