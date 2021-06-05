/**
 * Java program of a virtual library where you can add Books, Magazines, Newspapers, Encyclopedias & Comics into .txt files using FileWriter
 * @author esparev
 */
class Main {
	public static void main(String[] args) {
		BookStand stand = new BookStand();
		stand.show();
		stand.newPublication();
		stand.show();
	}
}