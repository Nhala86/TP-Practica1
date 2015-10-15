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
		this.mundo = new Mundo(nf, nc, n);
		this.in = new Scanner(System.in);
	}
	
	public void realizaSimulacion(){
		boolean fin = false;
		System.out.println("Comando > ");
		String string = in.nextLine();
		//convierte la cadena (string) a minúsculas
		string.toLowerCase();
		//Al final de cada comando hay que mostrar el tablero
		while (!fin){
			//if (string == "paso"){ // "==" no va a funcionar, hay que utilizar el "equals"
			if (string.equals("paso")){
				//Lista de movimientos
			}
			//else if (string == "iniciar"){
			else if (string.equals("iniciar")){
				//Inicio
			}
			//Hay que coger tambien 2 enteros
			//else if (string == "crearcelula"){
			else if (string.equals("crearcelula")){
				
			}
			//Hay que coger tambien 2 enteros
			//else if (string == "eliminarcelula"){
			else if (string.equals("eliminarcelula")){
				
			}
			else if (string == "ayuda"){
				System.out.println("POSIBLES COMANDOS:");
				System.out.println("PASO: realiza un paso en la simulacion");
				System.out.println("AYUDA: muestra esta ayuda");
				System.out.println("VACIAR: crea un mundo vacío");
				System.out.println("CREARCELULA F C: crea una nueva celula en la posición (f,c) si es posible");
				System.out.println("ELIMINARCELULA F C: elimina una celula de la posición (f,c) si es posible");
			}
			else if (string == "vaciar"){
				System.out.println("Vaciando la superficie....");
			}
			else if (string == "salir"){
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
