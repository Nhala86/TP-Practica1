package juego;

import java.util.Scanner;

public class Controlador {
	private Mundo mundo;
	private Scanner in;
	
	public Controlador(){
		this.mundo = new Mundo();
		this.in = new Scanner(System.in);
	}
	
    public Controlador(Mundo mundo, Scanner in){
        this.mundo = mundo;
        this.in = in;
    }

	public void realizaSimulacion(){
		boolean fin = false;
        mundo.toString();
		System.out.println("Comando > ");
		String string = in.nextLine();
		String [] palabras = string.split(" ");
		while (!fin){
			//falta hacer mundo.evoluciona
			if (string.equalsIgnoreCase("paso")){
				mundo.evoluciona();
				mundo.toString();
			}
			
			else if (string.equalsIgnoreCase("iniciar")){
				System.out.println("Iniciando de nuevo el juego....");
				mundo.vaciar();
				for (int i = 0; i < Constantes.NUMEROCELULAS; i++){
					mundo.generarCelulaAleatoria();
				}
                mundo.toString();
			}
			
			else if (palabras[0].equalsIgnoreCase("crearcelula")){
				int f = new Integer (palabras[1]);
				int c = new Integer (palabras[2]);
				if (mundo.crearCelulaSuperficie(f, c)){
					System.out.print("Eliminamos la celula en: (");
					System.out.print(palabras[1]);  System.out.print(",");
					System.out.print(palabras[2]);   System.out.println(")");
				}
				else {
					System.out.println("Error, la posicion indicada no existe o esta ocupada");
				}
                mundo.toString();			
             }
			
			else if (palabras[0].equalsIgnoreCase("eliminarcelula")){
				int f = new Integer (palabras[1]);
				int c = new Integer (palabras[2]);
				if (mundo.eliminarCelulaSuperficie(f, c)){
					System.out.print("Eliminamos la celula en: (");
					System.out.print( palabras[1]);  System.out.print(",");
					System.out.print(palabras[2]);   System.out.println(")");
				}
				else {
					System.out.println("Error, la posicion indicada no existe o esta ocupada");
				}
                mundo.toString();
			}
			else if (string.equalsIgnoreCase("ayuda")){
				System.out.println("POSIBLES COMANDOS:");
				System.out.println("PASO: realiza un paso en la simulacion");
				System.out.println("AYUDA: muestra esta ayuda");
				System.out.println("VACIAR: crea un mundo vacio");
				System.out.println("CREARCELULA F C: crea una nueva celula en la posicion (f,c) si es posible");
				System.out.println("ELIMINARCELULA F C: elimina una celula de la posicion (f,c) si es posible");
                mundo.toString();
			}
			else if (string.equalsIgnoreCase ("vaciar")){
				mundo.vaciar();
				System.out.println("Vaciando la superficie....");
                mundo.toString();
			}
			else if (string.equalsIgnoreCase("salir")){
				System.out.println("Fin de la simulacion.....");
				fin = true;
			}
			else {
				System.out.println("Comando no valido, introduzca otro > ");
                mundo.toString();
			}
		}
	}
}
