import java.util.Scanner;

class Comic extends Publication {
	private double price;
	private boolean paste;
	private int chapters;

	static Scanner sc = new Scanner(System.in);

	Comic() {
		super();
	}
	Comic(String name, String editorial, double price, boolean paste, int chapters) {
		super(name, editorial);
		this.price = price;
		this.paste = paste;
		this.chapters = chapters;
	}

	@Override
	void show() {
		showData();
	}
	void showData() {
		System.out.println("\n=========================================");
		System.out.println("=               C O M I C               =");
		System.out.println("=========================================");

		super.showData();

		String isPaste;

		isPaste = (paste == true) ? "HARD" : "SOFT";

		System.out.println("PRICE: " + price);
		System.out.println("PASTE: " + isPaste );
		System.out.println("CHAPTERS: " + chapters);
	}

	@Override
	void add() {
		addData();
	}
	void addData() {
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

	String buildRegistry() {
		return super.buildRegistry() + ";" + price + ";" + paste + ";" + chapters;
	}
}