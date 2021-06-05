import java.util.Scanner;

class Newspaper extends Publication {
	private String director;
	private int day;
	private int month;
	private int year;
	
	static Scanner sc = new Scanner(System.in);
	
	Newspaper() {
		super();
	}
	Newspaper(String name, String editorial, String director, int day, int month, int year) {
		super(name, editorial);
		this.director = director;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	void show() {
		showData();
	}
	void showData() {
		System.out.println("\n=========================================");
		System.out.println("=           N E W S P A P E R           =");
		System.out.println("=========================================");

		super.showData();
		
		System.out.println("DIRECTOR: " + director);
		System.out.printf("DATE: %02d/%s/%s\n", day, month, year);
	}

	@Override
	void add() {
		addData();
	}
	void addData() {
		super.addData();

		System.out.print("DIRECTOR's NAME: ");
		director = sc.nextLine();

		System.out.println("PUBLICATION DATE");
		System.out.println("================");

		System.out.print("DAY: ");
		day = sc.nextInt();

		System.out.print("MONTH: ");
		month = sc.nextInt();

		System.out.print("YEAR: ");
		year = sc.nextInt();
	}

	String buildRegistry() {
		return super.buildRegistry() + ";" + director + ";" + day + ";" + month + ";" + year;}
}