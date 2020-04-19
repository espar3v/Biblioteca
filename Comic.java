import java.util.Scanner;
public class Comic extends Publicacion{
    private double precio;
	private boolean pasta;
    private int capitulos;
    
    public Comic(){
        super();
    }
    public Comic(String nombre, String editorial, double precio, boolean pasta, int capitulos){
        super(nombre, editorial);
        this.precio = precio;
        this.pasta = pasta;
        this.capitulos = capitulos;
    }

    @Override
	public void mostrar(){
        mostrarDatos();
    }
	public void mostrarDatos(){
        System.out.println("\n------------------COMIC-----------------");
        System.out.println("----------------------------------------");
        super.mostrarDatos();
        String tipoPasta;
        if(pasta == true)
            tipoPasta = "DURA";
        else
            tipoPasta = "SUAVE";
        System.out.println("PRECIO:    " + precio + 
                         "\nPASTA:     " + tipoPasta + 
                         "\nCAPITULOS: " + capitulos);
    }

	@Override
	public void agregar(){
        agregarDatos();
    }
	public void agregarDatos(){
		super.agregarDatos();
		Scanner sc = new Scanner(System.in);
        System.out.print("PRECIO: ");
        precio = sc.nextDouble();
		System.out.print("PASTA: |DURA (D)/SUAVE (S)|: ");
        char pastaOp = sc.next().charAt(0);
        pastaOp = Character.toUpperCase(pastaOp);
        if(pastaOp == 'D')
            pasta = true;
        else if(pastaOp == 'S')
            pasta = false;
        else
            System.out.print("--TIPO DE PASTA INDEFINIDO--\n");
        System.out.print("CAPITULOS: ");
        capitulos = sc.nextInt();
    }

    public String construirRegistro(){
        return super.construirRegistro() + ";" + precio + ";" + pasta + ";" + capitulos;
    }
}