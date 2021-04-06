import java.util.Scanner;

public class Book extends Publication {
	private String author;
	private int pages;

	static Scanner sc = new Scanner(System.in);
	
	public Book() {
		super();
	}
	public Book(String name, String editorial, String author, int pages) {
		super(name, editorial);
		this.author = author;
		this.pages = pages;
	}

	@Override
	public void show() {
		showData();
	}
	public void showData() {
		System.out.println("\n=========================================");
		System.out.println("================== BOOK =================");
		System.out.println("=========================================");

		super.showData();

		System.out.println("AUTHOR: " + author);
		System.out.println("PAGES: " + pages);
	}

	@Override
	public void add() {
		addData();
	}
	public void addData() {
		super.addData();
		
		System.out.print("AUTHOR'S NAME: ");
		author = sc.nextLine();

		System.out.print("NUMBER OF PAGES: ");
		pages = sc.nextInt();
	}

	public String buildRegistry() {
		return super.buildRegistry() + ";" + author + ";" + pages;
	}
}