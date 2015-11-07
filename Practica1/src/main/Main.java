package main;

import java.io.IOException;
import java.util.Scanner;

import controlador.Controlador;
import logica.Mundo;



public class Main {
	
	/**
	 * Metodo constructor del Main, que inicializa Scanner, Mundo y Controlador, y realiza la simulacion del juego
	 * @param args valor predeterminado por java
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		Mundo mundo = new Mundo();
		Controlador controlador = new Controlador(mundo, in);
		controlador.realizaSimulacion();
	}

}
