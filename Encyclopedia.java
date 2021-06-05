import java.util.Scanner;

class Encyclopedia extends Publication {
	private String thematic;
	private int volume;
	private int year;
	
	static Scanner sc = new Scanner(System.in);
	
	Encyclopedia() {
		super();
	}
	Encyclopedia(String name, String editorial, String thematic, int volume, int year){
		super(name, editorial);
		this.thematic = thematic;
		this.volume = volume;
		this.year = year;
	}

	@Override
	void show() {
		showData();
	}
	void showData() {
		System.out.println("\n=========================================");
		System.out.println("=        E N C Y C L O P E D I A        =");
		System.out.println("=========================================");

		super.showData();

		System.out.println("THEMATIC: " + thematic);
		System.out.println("VOLUME: " + volume);
		System.out.println("YEAR: " + year);
	}

	@Override
	void add() {
		addData();
	}
	void addData() {
		super.addData();
		
		System.out.print("THEMATIC: ");
		thematic = sc.nextLine();

		System.out.print("VOLUME: ");
		volume = sc.nextInt();

		System.out.print("YEAR OF PUBLICATION: ");
		year = sc.nextInt();
	}
	
	String buildRegistry() {
		return super.buildRegistry() + ";" + thematic + ";" + volume + ";" + year;
	}
}