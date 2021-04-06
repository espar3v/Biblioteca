import java.util.Scanner;

public class Encyclopedia extends Publication {
	private String thematic;
	private int volume;
	private int year;
	
	static Scanner sc = new Scanner(System.in);
	
	public Encyclopedia() {
		super();
	}
	public Encyclopedia(String name, String editorial, String thematic, int volume, int year){
		super(name, editorial);
		this.thematic = thematic;
		this.volume = volume;
		this.year = year;
	}

	@Override
	public void show() {
		showData();
	}
	public void showData() {
		System.out.println("\n=========================================");
		System.out.println("============== ENCYCLOPEDIA =============");
		System.out.println("=========================================");

		super.showData();

		System.out.println("THEMATIC: " + thematic);
		System.out.println("VOLUME: " + volume);
		System.out.println("YEAR: " + year);
	}

	@Override
	public void add() {
		addData();
	}
	public void addData() {
		super.addData();
		
		System.out.print("THEMATIC: ");
		thematic = sc.nextLine();

		System.out.print("VOLUME: ");
		volume = sc.nextInt();

		System.out.print("YEAR OF PUBLICATION: ");
		year = sc.nextInt();
	}
	
	public String buildRegistry() {
		return super.buildRegistry() + ";" + thematic + ";" + volume + ";" + year;
	}
}