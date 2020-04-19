import java.util.Scanner;
public abstract class Publicacion{
	protected String nombre;
	protected String editorial;
		
	public Publicacion(){

	}

	public Publicacion(String nombre, String editorial){
		this.nombre = nombre;
		this.editorial = editorial;
	}

	public abstract void mostrar();
	public void mostrarDatos(){
		System.out.println("NOMBRE:    " + nombre +
						 "\nEDITORIAL: " + editorial);
	}

	public abstract void agregar();
	public void agregarDatos(){
		Scanner sc = new Scanner(System.in);
		System.out.print("NOMBRE: ");
		nombre = sc.nextLine();
		System.out.print("EDITORIAL: ");
		editorial = sc.nextLine();
	}
	
	public String construirRegistro(){
		return nombre + ";" + editorial;
	}
}