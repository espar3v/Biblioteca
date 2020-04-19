import java.util.Scanner;
public class Enciclopedia extends Publicacion{
	private String tematica;
	private int tomos;
	private int anio;
	
	public Enciclopedia(){
		super();
	}
	public Enciclopedia(String nombre, String editorial, String tematica, int tomos, int anio){
		super(nombre, editorial);
		this.tematica = tematica;
		this.tomos = tomos;
		this.anio = anio;
	}

	@Override
	public void mostrar(){
		mostrarDatos();
	}
	public void mostrarDatos(){
		System.out.println("\n--------------ENCICLOPEDIA--------------");
		System.out.println("----------------------------------------");
		super.mostrarDatos();
		System.out.println("TEMATICA: " + tematica + 
						 "\nTOMOS:    " + tomos + 
						 "\nANIO:     " + anio);
	}

	@Override
	public void agregar(){
		agregarDatos();
	}
	public void agregarDatos(){
		super.agregarDatos();
		Scanner sc = new Scanner(System.in);
		System.out.print("TEMATICA: ");
		tematica = sc.nextLine();
		System.out.print("TOMOS: ");
		tomos = sc.nextInt();
		System.out.print("ANIO DE PUBLICACION: ");
		anio = sc.nextInt();
	}
	
	public String construirRegistro(){
		return super.construirRegistro() + ";" + tematica + ";" + tomos + ";" + anio;}
}