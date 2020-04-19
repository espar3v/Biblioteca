import java.util.Scanner;
public class Periodico extends Publicacion{
	private String director;
	private int dia;
	private int mes;
	private int anio;
	
	public Periodico(){
		super();
	}

	public Periodico(String nombre, String editorial, String director, int dia, int mes, int anio){
		super(nombre, editorial);
		this.director = director;
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}

	@Override
	public void mostrar(){
		mostrarDatos();
	}
	public void mostrarDatos(){
		System.out.println("\n----------------PERIODICO---------------");
		System.out.println("----------------------------------------");
		super.mostrarDatos();
		System.out.println("DIRECTOR: " + director + 
						 "\nDIA:      " + dia + 
						 "\nMES:      " + mes + 
						 "\nANIO:     " + anio);
	}

	@Override
	public void agregar(){
		agregarDatos();
	}
	public void agregarDatos(){
		super.agregarDatos();
		Scanner sc = new Scanner(System.in);
		System.out.print("NOMBRE DEL DIRECTOR: ");
		director = sc.nextLine();
		System.out.println("FECHA DE PUBLICACION");
		System.out.print("DIA: ");
		dia = sc.nextInt();
		System.out.print("MES: ");
		mes = sc.nextInt();
		System.out.print("ANIO: ");
		anio = sc.nextInt();
	}

	public String construirRegistro(){
		return super.construirRegistro() + ";" + director + ";" + dia + ";" + mes + ";" + anio;}
}