package juego;

import java.util.Scanner;

public class Main {
	
	/**
	 * Metodo constructor del Main, que inicializa Scanner, Mundo y Controlador, y realiza la simulacion del juego
	 * @param args valor predeterminado por java
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Mundo mundo = new Mundo();
		Controlador controlador = new Controlador(mundo, in);
		controlador.realizaSimulacion();
	}

}
