import java.util.Scanner;

class Book extends Publication {
	private String author;
	private int pages;

	static Scanner sc = new Scanner(System.in);
	
	Book() {
		super();
	}
	Book(String name, String editorial, String author, int pages) {
		super(name, editorial);
		this.author = author;
		this.pages = pages;
	}

	@Override
	void show() {
		showData();
	}
	void showData() {
		System.out.println("\n=========================================");
		System.out.println("=                B O O K                =");
		System.out.println("=========================================");

		super.showData();

		System.out.println("AUTHOR: " + author);
		System.out.println("PAGES: " + pages);
	}

	@Override
	void add() {
		addData();
	}
	void addData() {
		super.addData();
		
		System.out.print("AUTHOR'S NAME: ");
		author = sc.nextLine();

		System.out.print("NUMBER OF PAGES: ");
		pages = sc.nextInt();
	}

	String buildRegistry() {
		return super.buildRegistry() + ";" + author + ";" + pages;
	}
}