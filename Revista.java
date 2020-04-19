import java.util.Scanner;
public class Revista extends Publicacion{
	private int anio;
	private int numero;
	
	public Revista(){
		super();
	}
	public Revista(String nombre, String editorial, int anio, int numero){
		super(nombre, editorial);
		this.anio = anio;
		this.numero = numero;
	}

	@Override
	public void mostrar(){
		mostrarDatos();
	}
	public void mostrarDatos(){
		System.out.println("\n-----------------REVISTA----------------");
		System.out.println("----------------------------------------");
		super.mostrarDatos();
		System.out.println("ANIO:   " + anio + 
						 "\nNUMERO: " + numero);
	}

	@Override
	public void agregar(){
		agregarDatos();
	}
	public void agregarDatos(){
		super.agregarDatos();
		Scanner sc = new Scanner(System.in);
		System.out.print("ANIO DE LA PUBLICACION: ");
		anio = sc.nextInt();
		System.out.print("NUMERO DE LA REVISTA: ");
		numero = sc.nextInt();
	}

	public String construirRegistro(){
		return super.construirRegistro() + ";" + anio + ";" + numero;
	}
}