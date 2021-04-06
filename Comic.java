import java.util.Scanner;

public class Comic extends Publication {
	private double price;
	private boolean paste;
	private int chapters;

	static Scanner sc = new Scanner(System.in);

	public Comic() {
		super();
	}
	public Comic(String name, String editorial, double price, boolean paste, int chapters) {
		super(name, editorial);
		this.price = price;
		this.paste = paste;
		this.chapters = chapters;
	}

	@Override
	public void show() {
		showData();
	}
	public void showData() {
		System.out.println("\n=========================================");
		System.out.println("================== COMIC ================");
		System.out.println("=========================================");

		super.showData();

		String isPaste;

		if (paste == true)
			isPaste = "HARD";
		else
			isPaste = "SOFT";

		System.out.println("PRICE: " + price);
		System.out.println("PASTE: " + isPaste );
		System.out.println("CHAPTERS: " + chapters);
	}

	@Override
	public void add() {
		addData();
	}
	public void addData() {
		super.addData();

		System.out.print("PRICE: ");
		price = sc.nextDouble();

		System.out.print("PASTE | HARD (H) | SOFT (S) |\n-> ");
		char pasteOp = sc.next().charAt(0);
		pasteOp = Character.toUpperCase(pasteOp);

		if (pasteOp == 'H')
			paste = true;
		else if (pasteOp == 'S')
			paste = false;
		else
			System.out.print("::: UNDEFINED TYPE OF PASTE :::\n");

		System.out.print("CHAPTERS: ");
		chapters = sc.nextInt();
	}

	public String buildRegistry() {
		return super.buildRegistry() + ";" + price + ";" + paste + ";" + chapters;
	}
}