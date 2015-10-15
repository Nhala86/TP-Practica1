package juego;

import java.util.Scanner;

public class Controlador {
	private Mundo mundo;
	private Scanner in;
	
/**
 * 
 * @param nf valor entero positivo que indica el numero de filas del mundo
 * @param nc valor entero positivo que indica el numero de columnas del mundo
 * @param n numero entero positivo de celulas que se generan en el mundo
 */
	public Controlador(int nf, int nc, int n){
		this.mundo = new Mundo();
		this.in = new Scanner(System.in);
	}
	
	public void realizaSimulacion(){
		boolean fin = false;
		System.out.println("Comando > ");
		String string = in.nextLine();
		String [] palabras = string.split(" ");
		//Al final de cada comando hay que mostrar el tablero
		while (!fin){
			if (string.equalsIgnoreCase("paso")){
				mundo.evoluciona();
				//Mostrar tablero
			}
			
			else if (string.equalsIgnoreCase("iniciar")){
				System.out.println("Iniciando de nuevo el juego....");
				mundo.vaciar();
				for (int i = 0; i < Constantes.NUMEROCELULAS; i++){
					generarCelulaAleatoria();
				}
			}
			//Hay que coger tambien 2 enteros
			else if (palabras[0].equalsIgnoreCase("crearcelula")){
				int f = new Integer (palabras[1]);
				int c = new Integer (palabras[2]);
				if (crearCelulaSuperficie(f, c)){
					System.out.print("Creamos nueva celula en: (" palabras[1] "," palabras[2] ")");
					//Mostrar tablero
				}
				else {
					System.out.println("Error, la posicion indicada no existe o esta ocupada");
				}
			}
			//Hay que coger tambien 2 enteros
			else if (palabras[0].equalsIgnoreCase("eliminarcelula")){
				int f = new Integer (palabras[1]);
				int c = new Integer (palabras[2]);
				if (eliminarCelulaSuperficie(f, c)){
					System.out.print("Eliminamos la celula en: (" palabras[1] "," palabras[2] ")");
					//Mostrar tablero
				}
				else {
					System.out.println("Error, la posicion indicada no existe o esta ocupada");
				}
			}
			else if (string.equalsIgnoreCase("ayuda")){
				System.out.println("POSIBLES COMANDOS:");
				System.out.println("PASO: realiza un paso en la simulacion");
				System.out.println("AYUDA: muestra esta ayuda");
				System.out.println("VACIAR: crea un mundo vacio");
				System.out.println("CREARCELULA F C: crea una nueva celula en la posicion (f,c) si es posible");
				System.out.println("ELIMINARCELULA F C: elimina una celula de la posicion (f,c) si es posible");
			}
			else if (string.equalsIgnoreCase ("vaciar")){
				mundo.vaciar();
				System.out.println("Vaciando la superficie....");
			}
			else if (string.equalsIgnoreCase("salir")){
				System.out.println("Fin de la simulacion.....");
				fin = true;
			}
			else {
				System.out.println("Comando no valido, introduzca otro > ");
			}
		}
	}
	
	//Pruebas de la simulacion
	public static void main(String[] args) {
		

	}
}
