import java.util.Scanner;
public class Libro extends Publicacion{
	private String autor;
	private int num_paginas;
	
	public Libro(){
		super();
	}
	public Libro(String nombre, String editorial, String autor, int num_paginas){
		super(nombre, editorial);
		this.autor = autor;
		this.num_paginas = num_paginas;
	}

	@Override
	public void mostrar(){
		mostrarDatos();
	}
	public void mostrarDatos(){
		System.out.println("\n------------------LIBRO-----------------");
		System.out.println("----------------------------------------");
		super.mostrarDatos();
		System.out.println("AUTOR:       " + autor + 
						 "\nNUM PAGINAS: " + num_paginas);
	}

	@Override
	public void agregar(){
		agregarDatos();
	}
	public void agregarDatos(){
		super.agregarDatos();
		Scanner sc = new Scanner(System.in);
		System.out.print("NOMBRE DEL AUTOR: ");
		autor = sc.nextLine();
		System.out.print("NUMERO DE PAGINAS: ");
		num_paginas = sc.nextInt();
	}

	public String construirRegistro(){
		return super.construirRegistro() + ";" + autor + ";" + num_paginas;
	}
}