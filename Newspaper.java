import java.util.Scanner;

public class Newspaper extends Publication {
	private String director;
	private int day;
	private int month;
	private int year;
	
	static Scanner sc = new Scanner(System.in);
	
	public Newspaper() {
		super();
	}
	public Newspaper(String name, String editorial, String director, int day, int month, int year) {
		super(name, editorial);
		this.director = director;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public void show() {
		showData();
	}
	public void showData() {
		System.out.println("\n=========================================");
		System.out.println("================ NEWSPAPER ==============");
		System.out.println("=========================================");


		super.showData();
		
		System.out.println("DIRECTOR: " + director);
		System.out.println("DAY: " + day);
		System.out.println("MONTH: " + month);
		System.out.println("YEAR: " + year);
	}

	@Override
	public void add() {
		addData();
	}
	public void addData() {
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

	public String buildRegistry() {
		return super.buildRegistry() + ";" + director + ";" + day + ";" + month + ";" + year;}
}