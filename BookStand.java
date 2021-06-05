import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;

class BookStand {
	private Publication[] myPublications = new Publication[100];
	private int index, publishingOption;
	
	static Scanner sc = new Scanner(System.in);
	
	BookStand() {
		index = 0;
		loadRegistry();
	}

	/**
	 * Adds a new publication of a Book, Magazine, Encyclopedia, Newspaper & Comic 
	 */
	void newPublication() {
		char addOption = 0, addOption2 = 0;
		do {
			System.out.println("\n===== ADD PUBLICATION =====");
			System.out.println("1. Book");
			System.out.println("2. Magazine");
			System.out.println("3. Newspaper");
			System.out.println("4. Encyclopedia");
			System.out.println("5. Comic");
			System.out.println("0. Exit");

			System.out.print("-> ");
			publishingOption = sc.nextInt();

			switch (publishingOption) {
				case 1:
					do {
						System.out.println("============= NEW BOOK =============");
						System.out.println("========== ENTER THE DATA ==========");
						
						// Book Data
						myPublications[index] = new Book();
						myPublications[index].add();
						
						saveRegistry();

						System.out.print("Want to add another Book? |Y/N|\n-> ");
						addOption = sc.next().charAt(0);
						addOption = Character.toUpperCase(addOption);
						sc.nextLine();
					} while(addOption != 'N');
					break;
				case 2:
					do {
						System.out.println("=========== NEW MAGAZINE ===========");
						System.out.println("========== ENTER THE DATA===========");
						
						// Magazine Data
						myPublications[index] = new Magazine();
						myPublications[index].add();

						saveRegistry();
						
						System.out.print("Want to add another Magazine? |Y/N|\n-> ");
						addOption = sc.next().charAt(0);
						addOption = Character.toUpperCase(addOption);
						sc.nextLine();
					} while(addOption != 'N');
					break;
				case 3:
					do {
						System.out.println("========== NEW NEWSPAPER ===========");
						System.out.println("========== ENTER THE DATA ==========");

						// Newspaper Data
						myPublications[index] = new Newspaper();
						myPublications[index].add();

						saveRegistry();
						
						System.out.print("Want to add another Newspaper? |T/N|\n-> ");
						addOption = sc.next().charAt(0);
						addOption = Character.toUpperCase(addOption);
						sc.nextLine();
					} while(addOption != 'N');
					break;
				case 4:
					do {
						System.out.println("========= NEW ENCYCLOPEDIA =========");
						System.out.println("========== ENTER THE DATA ==========");
						
						// Encyclopedia Data
						myPublications[index] = new Encyclopedia();
						myPublications[index].add();
						
						saveRegistry();

						System.out.print("Want to add another Encyclopedia? |Y/N|\n-> ");
						addOption = sc.next().charAt(0);
						addOption = Character.toUpperCase(addOption);
						sc.nextLine();
					} while(addOption!='N');
					break;
				case 5:
					do {
						System.out.println("=========== NEW COMIC ===========");
						System.out.println("======== ENTER THE DATA =========");

						// Comic Data
						myPublications[index] = new Comic();
						myPublications[index].add();

						saveRegistry();
						
						System.out.print("Want to add another Comic? |Y/N|\n-> ");
						addOption = sc.next().charAt(0);
						addOption = Character.toUpperCase(addOption);
						sc.nextLine();
					} while(addOption != 'N');
					break;
				case 0:
					return;
			}
			System.out.print("Want to add another Publication |Y/N|\n-> ");
			addOption2 = sc.next().charAt(0);
			addOption2 = Character.toUpperCase(addOption2);
		} while(addOption2 != 'N');
	}

	/**
	 * Shows all the publications, Books, Magazines, Encyclopedias, Newspapers & Comics
	 */
	void show() {
		for (int i = 0; i < index; i++) {
			myPublications[i].show();
		}
	}

	/**
	 * Saves the publications in .txt files
	 */
	void saveRegistry() {
		String registry = myPublications[index++].buildRegistry();

		File bookFile = new File("books.txt");
		File magazineFile = new File("magazines.txt");
		File newspaperFile = new File("newspapers.txt");
		File encyclopediaFile = new File("encyclopedias.txt");
		File comicFile = new File("comics.txt");

		PrintWriter pw = null;

		if (publishingOption == 1) { // Book Option
			try {
				pw = new PrintWriter(new FileWriter(bookFile, true));
				pw.println(registry);
				pw.close();
			}
			catch (IOException e) {
				System.out.println(e.toString() + "::: FILE ERROR :::");
			}
		}
		if (publishingOption == 2) { //Magazine Option
			try {
				pw = new PrintWriter(new FileWriter(magazineFile, true));
				pw.println(registry);
				pw.close();}
			catch (IOException e) {
				System.out.println(e.toString()+"::: FILE ERROR :::");
			}
		}
		if (publishingOption == 3) { // Newspaper Option
			try {
				pw = new PrintWriter(new FileWriter(newspaperFile, true));
				pw.println(registry);
				pw.close();
			}
			catch (IOException e) {
				System.out.println(e.toString() + "::: FILE ERROR :::");
			}
		}
		if (publishingOption == 4) { // Encyclopedia Option
			try {
				pw = new PrintWriter(new FileWriter(encyclopediaFile, true));
				pw.println(registry);
				pw.close();
			}
			catch (IOException e) {
				System.out.println(e.toString() + "::: FILE ERROR :::");
			}
		}
		if (publishingOption == 5) { // Comic Option
			try {
				pw = new PrintWriter(new FileWriter(comicFile, true));
				pw.println(registry);
				pw.close();
			}
			catch(IOException e) {
				System.out.println(e.toString() + "::: FILE ERROR :::");
			}
		}
	}

	/**
	 * Loads the publications of Books, Magazines, Encyclopedias, Newspapers & Comics from the .txt files to the program
	 */
	void loadRegistry() {
		BufferedReader input = null;
		String registry;

		// Load Books
		try {
			input = new BufferedReader(new FileReader("books.txt"));

			System.out.println("=========== EXISTING RECORDS ============");

			while ((registry = input.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(registry, ";");
				myPublications[index++] = new Book(tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), Integer.parseInt(tokens.nextToken()));
			}
		}
		catch (IOException e) {
			System.out.println(e.toString() + "::: FILE ERROR :::");
		}

		// Load Magazines
		try {
			input = new BufferedReader(new FileReader("magazines.txt"));
			while ((registry = input.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(registry, ";");
				myPublications[index++] = new Magazine(tokens.nextToken(), tokens.nextToken(), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
			}
		}
		catch (IOException e) {
			System.out.println(e.toString() + "::: FILE ERROR :::");
		}

		// Load Newspapers
		try {
			input = new BufferedReader(new FileReader("newspapers.txt"));
			while ((registry = input.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(registry, ";");
				myPublications[index++] = new Newspaper(tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
			}
		}
		catch (IOException e) {
			System.out.println(e.toString() + "::: FILE ERROR :::");
		}

		// Load Encyclopedias
		try {
			input = new BufferedReader(new FileReader("encyclopedias.txt"));
			while ((registry = input.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(registry, ";");
				myPublications[index++] = new Encyclopedia(tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
			}
		}
		catch (IOException e) {
			System.out.println(e.toString() + "::: FILE ERROR :::");
		}

		// Load Comics
		try {
			input = new BufferedReader(new FileReader("comics.txt"));
			while ((registry = input.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(registry, ";");
				myPublications[index++] = new Comic(tokens.nextToken(), tokens.nextToken(), Double.parseDouble(tokens.nextToken()), Boolean.parseBoolean(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
			}
		}
		catch (IOException e) {
			System.out.println(e.toString() + "::: FILE ERROR :::");
		}
	}
}