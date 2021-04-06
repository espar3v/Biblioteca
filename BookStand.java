import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BookStand {
	private Publication[] myPublications = new Publication[100];
	private int index, option;
	
	static Scanner sc = new Scanner(System.in);
	
	public BookStand() {
		index = 0;
		loadRegistry();
	}

	/**
	 * Adds a new publication of a Book, Magazine, Encyclopedia, Newspaper & Comic 
	 */
	public void newPublication() {
		char otraPub = 0, opcion = 0;
		do {
			System.out.println("\n===== ADD PUBLICATION =====");
			System.out.println("1. Book");
			System.out.println("2. Magazine");
			System.out.println("3. Newspaper");
			System.out.println("4. Encyclopedia");
			System.out.println("5. Comic");
			System.out.println("0. Exit");

			System.out.print("-> ");
			option = sc.nextInt();

			switch(option) {
				case 1:
					do {
						System.out.println("============= NEW BOOK =============");
						System.out.println("========== ENTER THE DATA ==========");
						
						// Book Data
						myPublications[index] = new Book();
						myPublications[index].add();
						
						saveRegistry();

						System.out.print("Want to add another Book? |Y/N|\n-> ");
						otraPub = sc.next().charAt(0); otraPub = Character.toUpperCase(otraPub);
						sc.nextLine();
					} while(otraPub != 'N');
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
						otraPub = sc.next().charAt(0);
						otraPub = Character.toUpperCase(otraPub);
						sc.nextLine();
					} while(otraPub != 'N');
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
						otraPub = sc.next().charAt(0);
						otraPub = Character.toUpperCase(otraPub);
						sc.nextLine();
					} while(otraPub != 'N');
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
						otraPub = sc.next().charAt(0);
						otraPub = Character.toUpperCase(otraPub);
						sc.nextLine();
					} while(otraPub!='N');
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
						otraPub = sc.next().charAt(0);
						otraPub = Character.toUpperCase(otraPub);
						sc.nextLine();
					} while(otraPub != 'N');
					break;
				case 0:
					return;
			}
			System.out.print("Want to add another Publication |Y/N|\n-> ");
			opcion = sc.next().charAt(0);
			opcion = Character.toUpperCase(opcion);
		} while(opcion != 'N');
	}

	/**
	 * Shows all the publications, Books, Magazines, Encyclopedias, Newspapers & Comics
	 */
	public void show() {
		for(int i = 0; i < index; i++) {
			myPublications[i].show();
		}
	}

	/**
	 * Saves the publications in .txt files
	 */
	public void saveRegistry() {
		String registry = myPublications[index++].buildRegistry();

		File archL = new File("books.txt");
		File archR = new File("magazines.txt");
		File archP = new File("newspapers.txt");
		File archE = new File("encyclopedias.txt");
		File archC = new File("comics.txt");

		PrintWriter pw = null;

		if(option == 1) { // Book Option
			try {
				pw = new PrintWriter(new FileWriter(archL, true));
				pw.println(registry);
				pw.close();
			}
			catch(IOException e) {
				System.out.println(e.toString() + "::: FILE ERROR :::");
			}
		}
		if(option == 2) { //Magazine Option
			try {
				pw = new PrintWriter(new FileWriter(archR, true));
				pw.println(registry);
				pw.close();}
			catch(IOException e) {
				System.out.println(e.toString()+"::: FILE ERROR :::");
			}
		}
		if(option == 3) { // Newspaper Option
			try {
				pw = new PrintWriter(new FileWriter(archP, true));
				pw.println(registry);
				pw.close();
			}
			catch(IOException e) {
				System.out.println(e.toString() + "::: FILE ERROR :::");
			}
		}
		if(option == 4) { // Encyclopedia Option
			try {
				pw = new PrintWriter(new FileWriter(archE, true));
				pw.println(registry);
				pw.close();
			}
			catch(IOException e) {
				System.out.println(e.toString() + "::: FILE ERROR :::");
			}
		}
		if(option == 5) { // Comic Option
			try {
				pw = new PrintWriter(new FileWriter(archC, true));
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
	public void loadRegistry() {
		BufferedReader input = null;
		String registry;

		// Load Books
		try {
			input = new BufferedReader(new FileReader("books.txt"));

			System.out.println("=========== EXISTING RECORDS ============");

			while((registry = input.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(registry, ";");
				myPublications[index++] = new Book(tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), Integer.parseInt(tokens.nextToken()));
			}
		}
		catch(IOException e) {
			System.out.println(e.toString() + "::: FILE ERROR :::");
		}

		// Load Magazines
		try {
			input = new BufferedReader(new FileReader("magazines.txt"));
			while((registry = input.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(registry, ";");
				myPublications[index++] = new Magazine(tokens.nextToken(), tokens.nextToken(), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
			}
		}
		catch(IOException e) {
			System.out.println(e.toString() + "::: FILE ERROR :::");
		}

		// Load Newspapers
		try {
			input = new BufferedReader(new FileReader("newspapers.txt"));
			while((registry = input.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(registry, ";");
				myPublications[index++] = new Newspaper(tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
			}
		}
		catch(IOException e) {
			System.out.println(e.toString() + "::: FILE ERROR :::");
		}

		// Load Encyclopedias
		try {
			input = new BufferedReader(new FileReader("encyclopedias.txt"));
			while((registry = input.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(registry, ";");
				myPublications[index++] = new Encyclopedia(tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
			}
		}
		catch(IOException e) {
			System.out.println(e.toString() + "::: FILE ERROR :::");
		}

		// Load Comics
		try {
			input = new BufferedReader(new FileReader("comics.txt"));
			while((registry = input.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(registry, ";");
				myPublications[index++] = new Comic(tokens.nextToken(), tokens.nextToken(), Double.parseDouble(tokens.nextToken()), Boolean.parseBoolean(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
			}
		}
		catch(IOException e) {
			System.out.println(e.toString() + "::: FILE ERROR :::");
		}
	}
}