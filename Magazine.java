import java.util.Scanner;

class Magazine extends Publication {
	private int year;
	private int number;
	
	static Scanner sc = new Scanner(System.in);
	
	Magazine() {
		super();
	}
	Magazine(String name, String editorial, int year, int number) {
		super(name, editorial);
		this.year = year;
		this.number = number;
	}

	@Override
	void show() {
		showData();
	}
	void showData() {
		System.out.println("\n=========================================");
		System.out.println("=            M A G A Z I N E            =");
		System.out.println("=========================================");
		
		super.showData();

		System.out.println("YEAR: " + year);
		System.out.println("NUMBER: " + number);
	}

	@Override
	void add() {
		addData();
	}
	void addData() {
		super.addData();

		System.out.print("PUBLICATION YEAR: ");
		year = sc.nextInt();

		System.out.print("NUMBER OF THE MAGAZINE: ");
		number = sc.nextInt();
	}

	String buildRegistry() {
		return super.buildRegistry() + ";" + year + ";" + number;
	}
}