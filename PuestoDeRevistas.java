import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
public class PuestoDeRevistas{
	private Publicacion misPublicaciones[] = new Publicacion[100];
	private int indice, agregar;
	
	public PuestoDeRevistas(){
		indice = 0;
		cargarRegistros();
	}
//METODO PARA AGREGAR UNA NUEVA PUBLICACION
	public void nuevaPublicacion(){
		Scanner sc = new Scanner(System.in);
		char otraPub = 0, opcion = 0;
		do{
			System.out.println("\n-----------------------------AGREGAR-----------------------------");
			System.out.print    ("1. LIBRO | 2. REVISTA | 3. PERIODICO | 4. ENCICLOPEDIA | 5. COMIC\n0. SALIR\nELIGA UNA OPCION: ");
			agregar = sc.nextInt();
			switch(agregar){
				case 1:
					do{
						System.out.println("\n--------------NUEVO LIBRO------------");
						System.out.println("----------INGRESE LOS DATOS----------");
					///DATOS DEL LIBRO
						misPublicaciones[indice] = new Libro();
						misPublicaciones[indice].agregar();
						guardarRegistro();
						System.out.print("DESEA AGREGAR OTRO LIBRO? |S/N|: ");
						otraPub = sc.next().charAt(0); otraPub = Character.toUpperCase(otraPub);
						sc.nextLine();
					}while(otraPub != 'N');
					break;
				case 2:
					do{
						System.out.println("\n-------------NUEVA REVISTA-----------");
						System.out.println("----------INGRESE LOS DATOS----------");
					///DATOS DE LA REVISTA
						misPublicaciones[indice] = new Revista();
						misPublicaciones[indice].agregar();
						guardarRegistro();
						System.out.print("DESEA AGREGAR OTRA REVISTA? |S/N|: ");
						otraPub = sc.next().charAt(0);
						otraPub = Character.toUpperCase(otraPub);
						sc.nextLine();
					}while(otraPub != 'N');
					break;
				case 3:
					do{
						System.out.println("\n-----------NUEVO PERIODICO-----------");
						System.out.println("----------INGRESE LOS DATOS----------");
					///DATOS DEL PERIODICO
						misPublicaciones[indice] = new Periodico();
						misPublicaciones[indice].agregar();
						guardarRegistro();
						System.out.print("DESEA AGREGAR OTRO PERIODICO? |S/N|: ");
						otraPub = sc.next().charAt(0);
						otraPub = Character.toUpperCase(otraPub);
						sc.nextLine();
					}while(otraPub != 'N');
					break;
				case 4:
					do{
						System.out.println("\n----------NUEVA ENCICLOPEDIA---------");
						System.out.println("----------INGRESE LOS DATOS----------");
					///DATOS DE LA ENCICLOPEDIA
						misPublicaciones[indice] = new Enciclopedia();
						misPublicaciones[indice].agregar();
						guardarRegistro();
						System.out.print("DESEA AGREGAR OTRA ENCICLOPEDIA? |S/N|: ");
						otraPub = sc.next().charAt(0);
						otraPub = Character.toUpperCase(otraPub);
						sc.nextLine();
					}while(otraPub!='N');
					break;
				case 5:
					do{
						System.out.println("\n--------------NUEVO COMIC------------");
						System.out.println("----------INGRESE LOS DATOS----------");
					///DATOS DEL COMIC
						misPublicaciones[indice] = new Comic();
						misPublicaciones[indice].agregar();
						guardarRegistro();
						System.out.print("DESEA AGREGAR OTRO COMIC? |S/N|: ");
						otraPub = sc.next().charAt(0);
						otraPub = Character.toUpperCase(otraPub);
						sc.nextLine();
					}while(otraPub != 'N');
					break;
				case 0:
					return;
			}
			System.out.print("DESEA AGREGAR OTRA PUBLICACION |S/N|: ");
			opcion = sc.next().charAt(0);
			opcion = Character.toUpperCase(opcion);
		}while(opcion != 'N');
	}
//METODO PARA MOSTRAR LAS PUBLICACIONES
	public void mostrar(){
		for(int i = 0; i < indice; i++){
			misPublicaciones[i].mostrar();
		}
	}
//METODO PARA GUARDAR LAS PUBLICACIONES EN ARCHIVOS
	public void guardarRegistro(){
		String registro = misPublicaciones[indice++].construirRegistro();
		File archL = new File("libros.txt");
		File archR = new File("revistas.txt");
		File archP = new File("periodicos.txt");
		File archE = new File("enciclopedias.txt");
		File archC = new File("comics.txt");
		PrintWriter pw = null;
		if(agregar == 1){//AGREGAR LIBRO
			try{
				pw = new PrintWriter(new FileWriter(archL, true));
				pw.println(registro);
				pw.close();
			}
			catch(IOException e){
				System.out.println(e.toString() + "ERROR EN EL ARCHIVO");
			}
		}
		if(agregar == 2){//AGREGAR REVISTA
			try{
				pw = new PrintWriter(new FileWriter(archR, true));
				pw.println(registro);
				pw.close();}
			catch(IOException e){
				System.out.println(e.toString()+"ERROR EN EL ARCHIVO");
			}
		}
		if(agregar == 3){//AGREGAR PERIODICO
			try{
				pw = new PrintWriter(new FileWriter(archP, true));
				pw.println(registro);
				pw.close();
			}
			catch(IOException e){
				System.out.println(e.toString() + "ERROR EN EL ARCHIVO");
			}
		}
		if(agregar == 4){//AGREGAR ENCICLOPEDIA
			try{
				pw = new PrintWriter(new FileWriter(archE, true));
				pw.println(registro);
				pw.close();
			}
			catch(IOException e){
				System.out.println(e.toString() + "ERROR EN EL ARCHIVO");
			}
		}
		if(agregar == 5){//AGREGAR COMIC
			try{
				pw = new PrintWriter(new FileWriter(archC, true));
				pw.println(registro);
				pw.close();
			}
			catch(IOException e){
				System.out.println(e.toString() + "ERROR EN EL ARCHIVO");
			}
		}
	}
//METODO PARA CARGAR LAS PUBLICACIONES DE LOS ARCHIVOS AL PROGRAMA
	public void cargarRegistros(){
		BufferedReader entrada = null;
		String registro;
	//CARGAR LIBROS
		try{
			entrada = new BufferedReader(new FileReader("libros.txt"));
			System.out.println("----------REGISTROS EXISTENTES----------");
			while((registro = entrada.readLine()) != null){
				StringTokenizer tokens = new StringTokenizer(registro, ";");
				misPublicaciones[indice++] = new Libro(tokens.nextToken(), tokens.nextToken(),
													   tokens.nextToken(), Integer.parseInt(tokens.nextToken()));
			}
		}
		catch(IOException e){
			System.out.println(e.toString() + "ERROR EN EL ARCHIVO");
		}
	//CARGAR REVISTAS
		try{
			entrada = new BufferedReader(new FileReader("revistas.txt"));
			while((registro = entrada.readLine()) != null){
				StringTokenizer tokens = new StringTokenizer(registro, ";");
				misPublicaciones[indice++] = new Revista(tokens.nextToken(), tokens.nextToken(),
					Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
			}
		}
		catch(IOException e){
			System.out.println(e.toString() + "ERROR EN EL ARCHIVO");
		}
	//CARGAR PERIODICOS
		try{
			entrada = new BufferedReader(new FileReader("periodicos.txt"));
			while((registro = entrada.readLine()) != null){
				StringTokenizer tokens = new StringTokenizer(registro, ";");
				misPublicaciones[indice++] = new Periodico(tokens.nextToken(), tokens.nextToken(), 
					tokens.nextToken(), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), 
					Integer.parseInt(tokens.nextToken()));
			}
		}
		catch(IOException e){
			System.out.println(e.toString() + "ERROR EN EL ARCHIVO");
		}
	//CARGAR ENCICLOPEDIAS
		try{
			entrada = new BufferedReader(new FileReader("enciclopedias.txt"));
			while((registro = entrada.readLine()) != null){
				StringTokenizer tokens = new StringTokenizer(registro, ";");
				misPublicaciones[indice++] = new Enciclopedia(tokens.nextToken(), tokens.nextToken(), 
					tokens.nextToken(), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));}}
		catch(IOException e){
			System.out.println(e.toString() + "ERROR EN EL ARCHIVO");
		}
	//CARGAR COMICS
		try{
			entrada = new BufferedReader(new FileReader("comics.txt"));
			while((registro = entrada.readLine()) != null){
				StringTokenizer tokens = new StringTokenizer(registro, ";");
				misPublicaciones[indice++] = new Comic(tokens.nextToken(), tokens.nextToken(), 
					Double.parseDouble(tokens.nextToken()), Boolean.parseBoolean(tokens.nextToken()), 
					Integer.parseInt(tokens.nextToken()));
			}
		}
		catch(IOException e){
			System.out.println(e.toString() + "ERROR EN EL ARCHIVO");
		}
	}
}